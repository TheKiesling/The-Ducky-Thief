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
 * Write a description of class Gun here.
 * Clase de la pistola que se encarga de disparar
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 20/07/2021)
 *          (Primera modificación: 20/07/2021)
 */
public class Gun extends Actor
{
    //-----------------------------FUNCIONES-----------------------------
    //-----Función de acción-----
    public void act() 
    {
        //-----Rotar la pistola-----
            //Sintaxis: Obtiene la rotación y le aumenta/disminuye 5 grados a su rotación
            
        //---Girar a la derecha---
        if(Greenfoot.isKeyDown("d")){
            setRotation(getRotation()-5);
        }
        
        //---Girar a la izquierda---
        if(Greenfoot.isKeyDown("a")){
            setRotation(getRotation()+5);
        }
        
        //-----Disparar-----
            //Sintaxis: si se presiona espacio se llama a la función que crea la bala
            
        if("space".equals(Greenfoot.getKey())){
            fire();
        }
        
    }   
    
    //-----Función de disparar-----
    public void fire(){
        //Crea una bala y la posiciona en donde se encuentra la pistola y la dirección de esta
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY()+5);
        bullet.setRotation(getRotation());
    }
}
