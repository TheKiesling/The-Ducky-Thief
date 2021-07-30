import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public int amountDucky = 0;
    private int amountChest = 0;
    private int x = 0;
    private int y = 0;
    private static int chest = 0;
    
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 700x700 cells with a cell size of 1x1 pixels.
        super(700, 700, 1); 
        prepare();
       
    }
    
    public static void setChest(int points){
        chest = points;
    }
    
    public static int getChest(){
        return chest;
    }
    
    public static void addChest(){
        chest++;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Henry_Avery henry_Avery = new Henry_Avery();
        addObject(henry_Avery,350,400);
        logo l = new logo();
        addObject(l, 60,40);
        Greenfoot.delay(250);        
    }
    
    private int getRandom(int begin, int end){
        int number = Greenfoot.getRandomNumber(end-begin+1) + begin;
        return number;
    }
    
    public void act(){ 
        
        showText(": " + chest, 120,30);
        
        while (amountDucky < 6){
            x = y = 0;
            x = getRandom(125,575);
            y = getRandom(200,600);
            DuckyChest duckyChest = new DuckyChest();
            addObject(duckyChest,x,y);
            amountDucky++;
        }
        
        while (amountChest < 1){
            x = y = 0;
            x = getRandom(125,575);
            y = getRandom(200,600);
            Chest chest = new Chest();
            addObject(chest,x,y);
            amountChest++;
        }
    }
    
}
