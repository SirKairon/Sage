import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * Enemy class
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    
    private int speed;
    GreenfootImage img1 = new GreenfootImage("Walk1.png");
    GreenfootImage img2 = new GreenfootImage("Walk2.png");
    GreenfootImage img3 = new GreenfootImage("Walk3.png");
    GreenfootImage img4 = new GreenfootImage("Walk4.png");
    GreenfootImage img5 = new GreenfootImage("Walk5.png");
    public int counter;
    int orbTimer = 0;
    
    private boolean moveAway;
    
    int animateTime = 0;
    int width = 120;
    int height = 60;
    
    public Dragon()
    {
        img1.scale(width, height);
        setImage(img1);
        speed = 4;      // random speed: 1 to 3
        setRotation(Greenfoot.getRandomNumber(360));
        moveAway = false;
    }
    
    public boolean getMoveAway(){
        return moveAway;
    }
    
    public void setMoveAway(boolean value){
        moveAway = value;
    }
    
    /**
     * Move around.
     */
    public void act() 
    {
        animateTime++;
        checkCollision();
        animate();
        if (isAtEdge()) 
        {
            turn(Greenfoot.getRandomNumber(360));
        }
        
        if (moveAway) {
            
            
            if (counter > 0) {
                goUp();
            }
            else {
              move(speed);  
            }
        }
        
        else {
            move(speed);
        }
        
        
        if (orbTimer > 0) {
            speed = 6;
            
            orbTimer--;
        }
        
        
        
        else {
            speed = 4;
            
        }
        
        if (orbTimer < 95 && orbTimer > 85){
            turnTowards(622, 350);
        }
        
        
    }
    
    public void goUp()
    {
        setLocation(getX(), getY() - 4);
        setRotation(0);
        counter--;
    }
    
    public void checkCollision()
    {
        if (isTouching(Orb.class)) {
            orbTimer = 100;
            
            
            removeTouching(Orb.class);
        }
    }
    
    private void animate()
    {
        if (animateTime == 0) {
            
            setImage(img1);
        }
        if (animateTime == 4) {
            img2.scale(width, height);
            setImage(img2);
        }
        if (animateTime == 8) {
            img3.scale(width, height);
            setImage(img3);
        }
        if (animateTime == 12) {
            img4.scale(width, height);
            setImage(img4);
        }
        if (animateTime == 16) {
            img5.scale(width, height);
            setImage(img5);
            animateTime = 0;
        }
        
        
        } 
}
    
    

