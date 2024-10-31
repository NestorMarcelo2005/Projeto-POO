import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage pisca1, pisca2;
    private int contador;
    
    public GameOver(){
        pisca1 = new GreenfootImage("Game_Over1.png");
        pisca2 = new GreenfootImage("Game_Over2.png");
        setImage(pisca1);
        contador = 0;
    }

    public void act() 
    {
        
    }
    
    
}
