import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Sage here.
 * 
 * Main Hero class of my game. All the interactions with other classes are her along with the animation
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sage extends Actor
{
    int worldCount = 1;
    
    int dragonCount = 7;
    
    int orbTimer = 0;
    
    int xSpeed = 7;
    int ySpeed = 8;
    
    Portal portal = new Portal();
    YouWin youwin = new YouWin();
    Dragon newDragon = new Dragon();
    Key key2 = new Key();
    Key key3 = new Key();
    Key key4 = new Key();
    Key key5 = new Key();
    Key key6 = new Key();
    Key key7 = new Key();
    Key key8 = new Key();
    //Add a key after every level
    
    GreenfootImage img1 = new GreenfootImage("wombat.png");
    int height = img1.getHeight() + 75;
    int width = img1.getWidth() + 75;
    //used wombat's size as a reference
    
    int animateTime = 0;
    
    private boolean facingLeft=true;
    private boolean flipImage = false;
    
    
    GreenfootImage sage1 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_001.png");
    GreenfootImage sage2 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_002.png");
    GreenfootImage sage3 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_003.png");
    GreenfootImage sage4 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_004.png");
    GreenfootImage sage5 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_005.png");
    GreenfootImage sage6 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_006.png");
    GreenfootImage sage7 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_007.png");
    GreenfootImage sage8 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_008.png");
    GreenfootImage sage9 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_009.png");
    GreenfootImage sage10 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_010.png");
    GreenfootImage sage11 = new GreenfootImage("RunSlashing/0_Reaper_Man_Run Slashing_011.png");
    
    /**
     * Act - do whatever the Sage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        checkCollision();
        animateTime++;
        animate();
        
        
        
            
            if (orbTimer > 0) {
                xSpeed = 11;
                ySpeed =  12;
                orbTimer--;
            }
            
            else {
                xSpeed = 7;
                ySpeed = 8;
            }
        // Add your action code here.
    }
    
     private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-ySpeed);
            
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+ySpeed);
            
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-xSpeed, getY());
            facingLeft = true;
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+xSpeed, getY());
            facingLeft = false;
        }
    }
    
    private void animate()
    {
        if (animateTime == 0) {
            sage1.scale(width, height);
            setImage(sage1);
        }
        if (animateTime == 4) {
            sage2.scale(width, height);
            setImage(sage2);
        }
        if (animateTime == 8) {
            sage3.scale(width, height);
            setImage(sage3);
        }
        if (animateTime == 12) {
            sage4.scale(width, height);
            setImage(sage4);
        }
        if (animateTime == 16) {
            sage5.scale(width, height);
            setImage(sage5);
        }
        if (animateTime == 20) {
            sage6.scale(width, height);
            setImage(sage6);
        }
        if (animateTime == 24) {
            sage7.scale(width, height);
            setImage(sage7);
        }
        if (animateTime == 28) {
            sage8.scale(width, height);
            setImage(sage8);
        }
        if (animateTime == 32) {
            sage9.scale(width, height);
            setImage(sage9);
        }
        if (animateTime == 36) {
            sage10.scale(width, height);
            setImage(sage10);
        }
        if (animateTime == 40) {
            sage11.scale(width, height);
            setImage(sage11);
            animateTime = 0;
        }
        
        if (facingLeft && !flipImage) {
            ImageFlipper();
        }
        
        else if (!facingLeft && flipImage) {
            ImageFlipper();
        }
        
        
    }
    
    
    public void checkCollision() 
    {
        
        Dragon dragonCheck = (Dragon) getOneIntersectingObject(Dragon.class);
        if (dragonCheck != null){
            dragonCheck.setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()) , Greenfoot.getRandomNumber(getWorld().getWidth()));
            MagicWorld magicWorld = (MagicWorld)getWorld();
            magicWorld.addScore();
            Greenfoot.playSound("dragon.mp3");
        }
        
        if (isTouching(Key.class)) {
            removeTouching(Key.class);
            
            getWorld().addObject(portal , 98, 405);
            
            Greenfoot.playSound("Key.wav");
        }
        
        if (isTouching(Orb.class)) {
            orbTimer = 100;
            
            Greenfoot.playSound("Orb.wav");
            
            removeTouching(Orb.class);
        }
        
        if (isTouching(PowerOrb.class)) {
            removeTouching(PowerOrb.class);
            
            World world = getWorld();
            List<Dragon> dragons = world.getObjects(Dragon.class);
            
            for (Dragon dragon : dragons) {
                dragon.setMoveAway(true);
                dragon.counter = 150;
            }
            
            Greenfoot.playSound("PowerOrb.wav");
        }
        
        if (isTouching(Portal.class)) {
            
            Greenfoot.playSound("LevelUp.wav");
            
            if (worldCount == 1) {
               getWorld().setBackground("game_background_2new.jpg");
               worldCount = 2;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key2, 1202, 371);
            }
            
            else if (worldCount == 2) {
               getWorld().setBackground("game_background_3new.jpg");
               worldCount = 3;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key3, 1202, 371);
            }
            
            else if (worldCount == 3) {
               getWorld().setBackground("game_background_4new.jpg");
               worldCount = 4;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key4, 1202, 371);
            }
            
            else if (worldCount == 4) {
               getWorld().setBackground("Battleground5new.jpg");
               worldCount = 5;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key5, 1202, 371);
            }
            
            else if (worldCount == 5) {
               getWorld().setBackground("Battleground6new.jpg");
               worldCount = 6;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key6, 1202, 371);
            }
            
            else if (worldCount == 6) {
               getWorld().setBackground("Battleground7new.jpg");
               worldCount = 7;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().removeObject(portal);
               getWorld().addObject(key7, 1202, 371);
            }
            
            else if (worldCount == 7) {
               getWorld().setBackground("Battleground8new.jpg");
               worldCount = 8;
               MagicWorld magicWorld = (MagicWorld)getWorld();
               magicWorld.resetLife();
               getWorld().addObject(youwin, 630, 362);
               Greenfoot.playSound("win.wav");
               Greenfoot.stop();
               
            }
            
            
           
            
        }
        
        
        
    }
    
    private void ImageFlipper()
    {
        sage1.mirrorHorizontally();
        sage2.mirrorHorizontally();
        sage3.mirrorHorizontally();
        sage4.mirrorHorizontally();
        sage5.mirrorHorizontally();
        sage6.mirrorHorizontally();
        sage7.mirrorHorizontally();
        sage8.mirrorHorizontally();
        sage9.mirrorHorizontally();
        sage10.mirrorHorizontally();
        sage11.mirrorHorizontally();
        if (flipImage) {
            flipImage = false;
        }
        else{
            flipImage = true;
        }
    }
    
}
    
    
    

