import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerOrb here.
 * PowerUp that makes the dragons go up
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerOrb extends Actor
{
    /**
     * Act - do whatever the PowerOrb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(); 
       
       if (getY() >= getWorld().getHeight() - 1) {
          getWorld().removeObject(this);
          
        }// Add your action code here.// Add your action code here.
    }
    
    
    
    public void move()
    {
        setLocation(getX(), getY() + 2);
    }
    
    
}
