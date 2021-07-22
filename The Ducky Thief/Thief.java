import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thief here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thief extends Actor
{

    
    private int x;
    private int y;
    

    public void act() 
    {
        x = getX();
        y = getY();
        
        move(2);
        if (Greenfoot.getRandomNumber(100) < 10)
            
            turn(Greenfoot.getRandomNumber(20));
        
        if (x <= 25 || y <= 200 || x >= getWorld().getWidth()-25 || y >= getWorld().getHeight()-25)
            turn(7);
            
        Actor henry_Avery = getOneIntersectingObject(Henry_Avery.class);
        if (henry_Avery != null) {
            Greenfoot.setWorld(new Background());
        }
        
        Actor chest = getOneIntersectingObject(Chest.class);
        if (chest != null) {
            Greenfoot.setWorld(new Background());
        }

    }    
}
