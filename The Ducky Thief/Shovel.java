import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shovel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shovel extends Actor
{
    private int amountDucky = 0;
    private int x = 0;
    private int y = 0;
    private Thief thief = new Thief();
    
    public void act() 
    {
        Actor duckyChest = getOneIntersectingObject(DuckyChest.class);
        if (duckyChest != null) {
            x = y = 0;
            if (Greenfoot.getRandomNumber(2) == 1)
                x = getRandom(50,75);
            else
                x = getRandom(600,675);
            y = getRandom(200,550);
            getWorld().removeObject(duckyChest);
            getWorld().addObject(new Thief(), x, y);
        }
        
        Actor chest = getOneIntersectingObject(Chest.class);
        if (chest != null) {
            Greenfoot.setWorld(new Background());
        }
    }  
    private int getRandom(int begin, int end){
        int number = Greenfoot.getRandomNumber(end-begin+1) + begin;
        return number;
    }
}
