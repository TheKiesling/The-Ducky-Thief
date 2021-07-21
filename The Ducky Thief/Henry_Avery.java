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
 * Write a description of class Henry_Avery here.
 * Clase del actor principal (controlará el usuario)
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 20/07/2021)
 *          (Primera modificación: 20/07/2021)
 */
public class Henry_Avery extends Actor
{
    //-----------------------------VARIABLES-----------------------------
    private Gun gun = new Gun();
    
    
    //-----------------------------FUNCIONES-----------------------------
    //-----Función de acción-----
    public void act(){  
        
        //------Movimiento del personaje-----
            //Sintaxis: Evaluar el botón presionado y obtener la componente según sea el caso y sumar o restar dicha componente para que se mueva
        
        //---Derecha---   
        if(Greenfoot.isKeyDown("right")){
            if(getX() < 575)
                setLocation(getX() + 4, getY());
        }
        
        //---Izquierda---
        if(Greenfoot.isKeyDown("left")){
            if(getX() > 125)
                setLocation(getX() - 4, getY());
        }
        
        //---Arriba---
        if(Greenfoot.isKeyDown("up")){
            if(getY() > 200 )
                setLocation(getX() , getY() - 4); 
        }
        
        //---Abajo---
        if(Greenfoot.isKeyDown("down")){
            if(getY() < 600)
                setLocation(getX() , getY() + 4);
        }
        
        //-----Sacar la pistola----
            //Sintaxis: Eliminar la pistola, y llamar a la función que crea la pistola cada vez que se quiera disparar si se mantiene el botón
            
        getWorld().removeObject(gun);
        
        if(Greenfoot.isKeyDown("shift")) {
            shot();
        }
    }
       
    //-----Función de sacar la pistola-----
    public void shot() {
        //Crea una pistola en la posición del brazo del pirata
        getWorld().addObject(gun, getX(), getY()-15);
    }
}
