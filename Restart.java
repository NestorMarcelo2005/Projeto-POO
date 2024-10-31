import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Actor
{
    private int inicial=0;
    private GreenfootImage imagem; 
    
    public Restart(){
        imagem = new GreenfootImage("Restart.png");
        setImage(imagem);
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            rato();
        }
    }
    /**
     * Método que deteta se o rato clicou no restart
     */
    public void rato(){
        if (getImage() == imagem) {
            Greenfoot.setWorld(new Nivel1(inicial));
        }
    }
}
