import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fim extends World
{

    /**
     * Constructor for objects of class Fim.
     * 
     */
    public Fim()
    {    
        super(1200, 700, 1);
        Back botaoBack = new Back();
        addObject(botaoBack,getWidth()/2, 500);
    }
}
