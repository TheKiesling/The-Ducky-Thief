import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Mover is an actor that also has 'move' and 'turn' ability. Both moving and turning 
 * are relative to its current position. When moving, the Mover will move in the direction 
 * it is currently facing.
 * 
 * Both 'move' and 'turn' methods are available with or without parameters.
 * 
 * The 'Mover' class is a subclass of Actor. It can be used by creating subclasses, or
 * copied into scenarios and edited inline.
 * 
 * The initial direction is to the right. Thus, this class works best with images that
 * face right when not rotated.
 * 
 * This class can also check whether we are close to the edge of the world.
 * 
 * @author Michael Kolling
 * @version 1.0 (July 2007)
 */
public class Mover extends Actor
{
    private static final double WALKING_SPEED = 5.0;
    
    /**
     * Turn 90 degrees to the right (clockwise).
     */
    public void turn()
    {
        turn(90);
    }
    

    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    

    /**
     * Move a bit forward in the current direction.
     */
    public void move()
    {
        move(WALKING_SPEED);
    }

    
    /**
     * Move a specified distance forward in the current direction.
     */
    public void move(double distance)
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
}
