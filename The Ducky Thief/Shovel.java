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
 * Write a description of class Shovel here.
 * Clase de la pala (controla el actor principal)
 * 
 * @author (José Pablo Kiesling Lange) 
 * @version 
 *          (Creación: 21/07/2021)
 *          (Primera modificación: 21/07/2021)
 *          (Segunda modificación: 28/07/2021)
 *          (Tercera modificación: 29/07/2021)
 */
public class Shovel extends Actor
{
    //-----------------------------VARIABLES-----------------------------
    private int amountDucky = 0;
    private int amount = 0;
    private int x = 0;
    private int y = 0;
    private Thief thief = new Thief();
    private Fast_Thief fastThief = new Fast_Thief();
    private Win win = new Win();
    private GreenfootSound backgroundMusic = new GreenfootSound("soundtrack.wav");
    Background thisGame;
    
    //-----------------------------FUNCIONES-----------------------------
    //-----Función de acción-----
    public void act() 
    {
        //Suena la música
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(25);
        
        //Asignar una varible que detecte si se intersecta con el objeto de "DuckyChest"
        Actor duckyChest = getOneIntersectingObject(DuckyChest.class);
        
        //Si el tesoro no está ahí:
        if (duckyChest != null) {
            x = y = 0;
            if(thisGame.getChest() < 5){
                //Genera un enemigo en la izquierda (1) o derecha (2)
                if (Greenfoot.getRandomNumber(2) == 1)
                    x = getRandom(50,75);
                else
                    x = getRandom(600,675);
                y = getRandom(200,550);
                getWorld().removeObject(duckyChest);
                getWorld().addObject(new Thief(), x, y);
            }
            else{
                if (Greenfoot.getRandomNumber(4) == 1){
                    if (Greenfoot.getRandomNumber(2) == 1)
                        x = getRandom(50,75);
                    else
                        x = getRandom(600,675);
                    y = getRandom(200,550);
                    getWorld().removeObject(duckyChest);
                    getWorld().addObject(new Thief(), x, y);
                }
                else
                    if (Greenfoot.getRandomNumber(2) == 1)
                        x = getRandom(50,75);
                    else
                        x = getRandom(600,675);
                    y = getRandom(200,550);
                    getWorld().removeObject(duckyChest);
                    getWorld().addObject(new Fast_Thief(), x, y);
                    
            }
            
        }
        //Asignar una varible que detecte si se intersecta con el objeto de "DuckyChest"
        Actor chest = getOneIntersectingObject(Chest.class);
        
        //Si el tesoro está ahí:
        if (chest != null) {
            //Animación de victoria
            getWorld().addObject(new Win(), 350, 450);
            //Aumenta la puntuación
            thisGame.addChest(); 
            //Genera un nuevo mundo (nuevo nivel)
            Greenfoot.setWorld(new Background());
            
            //Cuando se pase de nivel, se pausa la música
            if (backgroundMusic.isPlaying()) {
                backgroundMusic.pause();
            }
            
        }
    }
    
    //-----Función de número random-----
    private int getRandom(int begin, int end){
        int number = Greenfoot.getRandomNumber(end-begin+1) + begin;
        return number;
    }
}
