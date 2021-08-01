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
 * Write a description of class Fast_Thief here.
 * Clase del ladrón rápido (enemigo)
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 29/07/2021)
 *          (Primera modificación: 29/07/2021)
 */
public class Fast_Thief extends Actor
{
    //-----------------------------VARIABLES-----------------------------
    private int x;
    private int y;
    private Death death = new Death();
    Background thisGame;
    
    //-----------------------------FUNCIONES-----------------------------
    //-----Función de acción-----
    public void act() 
    {
        x = getX();
        y = getY();
        
        move(4);
        
        //Giro del personaje usando números randoms
        if (Greenfoot.getRandomNumber(100) < 10)
            turn(Greenfoot.getRandomNumber(20));
        
        //Si se topa con un límite girará para que no se quede atorado
        if (x <= 25 || y <= 200 || x >= getWorld().getWidth()-25 || y >= getWorld().getHeight()-25)
            turn(7);
        
        //Si toca a Henry Avery lo mata, y tiene que iniciar un nuevo juego
        Actor henry_Avery = getOneIntersectingObject(Henry_Avery.class);
        if (henry_Avery != null) {
            //Animación de muerte
            getWorld().addObject(new Death(), 350, 350);
            //Parar el mundo
            Greenfoot.stop();
            //Colocar la puntuación en 0
            thisGame.setChest(0);
        }
        
        //Si el ladrón encuentra el tesoro, tiene que iniciar un nuevo juego
        Actor chest = getOneIntersectingObject(Chest.class);
        if (chest != null) { 
            //Animación de muerte
            getWorld().addObject(new Death(), 350, 350);
            //Parar el mundo
            Greenfoot.stop();
            //Colocar la puntuación en 0
            thisGame.setChest(0);
        }

    }    
}
