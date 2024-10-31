import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cabeca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cabeca extends Actor
{
    /**
     * Act - do whatever the Cabeca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int anguloRotacao = 0;
    public void act()
    {
        mover();
        colidir();
    }
    /**
     * Função que move a cabeça quando esta é inserida no mundo
     */
    public void mover()
    {
        setLocation(getX() - 10, getY());
        anguloRotacao += 10; 
        if (anguloRotacao >= 360) {
            anguloRotacao = 0;
        }
        setRotation(anguloRotacao);
    }
    /**
     * Função que faz com que a cabeça desapareça quando colidir com algo
     */
    public void colidir()
    {
        if (isAtEdge()){
            {
                getWorld().removeObject(this);
            }
        }
    }
    
}
