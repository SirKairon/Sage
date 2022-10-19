import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * The key to the portal
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Key extends Actor
{
    int timer = 0;
    int counter = 0;
    int spawnX;
    int spawnY;
    
    
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage img1 = new GreenfootImage("5-new.png");
   
    
    
    public void act() 
    {
       timer++;
       counter++;
       levitate();// Add your action code here.
    }
    
    private void levitate()
    {
        if (isAtEdge()) {
            if (counter < 50){
            setLocation(getX() , getY() + 1);
         }
            else if (counter < 51){
            setLocation(getX(), getY());
         }
            else if (counter < 130) {
            setLocation(getX() , getY() -1);
         }
            else if (counter < 160) {
            setLocation(getX(), getY());
            counter = 0;
         }
    }
    
        else {
           if (counter < 50){
            setLocation(getX() , getY() - 1);
         }
            else if (counter < 51){
            setLocation(getX(), getY());
         }
            else if (counter < 130) {
            setLocation(getX() , getY() +1);
         }
            else if (counter < 160) {
            setLocation(getX(), getY());
            counter = 0;
         } 
        }
    }
    
    
}
