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
 * Write a description of class Bullet here.
 * Clase de la bala que será disparada cada vez que se requiera
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 20/07/2021)
 *          (Primera modificación: 20/07/2021)
 */
public class Bullet extends Mover
{
    //-----------------------------FUNCIONES-----------------------------
    //-----Función de acción-----
    public void act() 
    {
        //Se obtiene la posición en X y en Y
        int ypos = getY();
        int xpos = getX();
        
        //Se evalúa si la bala sigue en el mundo
        if (ypos < 699 && ypos > 0 && getX() > 0 && getX() < 699){
            move(10);
            Actor thief = getOneIntersectingObject(Thief.class);
                if (thief != null) 
                    getWorld().removeObject(thief);
        }
            
        //De no hacerlo, eliminar la bala
        else
            getWorld().removeObject(this);
    }    
}
