/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * Clase del mundo
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 20/07/2021)
 *          (Primera modificación: 20/07/2021)
 *          (Segunda modificación: 21/07/2021)
 *          (Tercera modificación: 28/07/2021)
 *          (Cuarta modificación: 29/07/2021)
 */
public class Background extends World
{
    //-----------------------------VARIABLES-----------------------------
    private int amountDucky = 0;
    private int amountChest = 0;
    private int x = 0;
    private int y = 0;
    private static int chest = 0;
    
    //-----------------------------FUNCIONES-----------------------------
    //-----Constructor-----
    public Background()
    {    
        super(700, 700, 1); 
        prepare();       
    }
    
    //-----Función de asignar puntuación-----
    public static void setChest(int points){
        chest = points;
    }
    
    //-----Función de obtener puntuación-----
    public static int getChest(){
        return chest;
    }
    
    //-----Función de aumentar puntuación-----
    public static void addChest(){
        chest++;
    }
    
    //-----Función de preparar el mundo-----
    private void prepare()
    {
        Henry_Avery henry_Avery = new Henry_Avery();
        addObject(henry_Avery,350,400);
        logo l = new logo();
        addObject(l, 60,40);
        Greenfoot.delay(250);        
    }
    
    //-----Función de número random-----
    private int getRandom(int begin, int end){
        int number = Greenfoot.getRandomNumber(end-begin+1) + begin;
        return number;
    }
    
    //-----Función de acción-----
    public void act(){
        //Agregar la puntuación
        showText(": " + chest, 120,30);
        
        //Agregar los montones de arena donde estarán los cofres.
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
