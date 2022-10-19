import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orb here.
 * Speed PowerUp
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orb extends Actor
{
    /**
     * Act - do whatever the Orb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       if (getY() >= getWorld().getHeight() - 1) {
          getWorld().removeObject(this); 
        }// Add your action code here.
    }    
}
