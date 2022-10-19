import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicWorld extends World
{
    
    
    int Life;
    int orbTime = 0;
    GreenfootImage img1 = new GreenfootImage("youwin.png");
    GreenfootImage img2 = new GreenfootImage("gameover.png");
    
    
    int timer;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MagicWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1244, 700, 1);
        Life = 3;
        prepare();
        timer = 3000;

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Sage.class, Dragon.class, Portal.class);

        Sage sage = new Sage();
        addObject(sage,98,405);
        Dragon dragon = new Dragon();
        addObject(dragon,880,169);
        Dragon dragon2 = new Dragon();
        addObject(dragon2,1128,175);
        Dragon dragon3 = new Dragon();
        addObject(dragon3,1130,283);
        Dragon dragon4 = new Dragon();
        addObject(dragon4,902,299);
        Dragon dragon5 = new Dragon();
        addObject(dragon5,873,506);
        Dragon dragon6 = new Dragon();
        addObject(dragon6,1130,503);
        Dragon dragon7 = new Dragon();
        addObject(dragon7,1019,400);
        Key key = new Key();
        addObject(key,1202,371);

        

        
    }
    
    public void addScore()
    {
       Life --;
       if (Life == 0) {
           Greenfoot.playSound("lose.wav");
           
           gameOver();
           
        }
    }
    
    public void resetLife() {
        Life = 3;
    }
    
    public void act()
    {
        orbTime++;
        if (orbTime % 200 == 0) {
            addObject(new Orb(), Greenfoot.getRandomNumber(getWidth()), 0);
            
        }
         if (orbTime % 500 == 0) {
            addObject(new PowerOrb(), Greenfoot.getRandomNumber(getWidth()), 0);
        }
        
        showTime();
        countTime();
        showLife();
        
    }
    
    public void gameOver()
    {
        addObject(new GameOver(),616,326);
        Life = 0;
        Greenfoot.stop();
        
    }
    
    public void countTime()
    {
       timer--;
       if (timer < 0) {
           
           gameOver();
        }
    }
    
    public void showTime()
    {
        showText("Time: " + timer, 80, 50);
    }
    
     public void showLife()
    {
        showText("Lives: " + Life, 1100, 50);
    }
    
    
    
   
    
    
    
}
