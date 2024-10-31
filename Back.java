import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Actor
{
    
    
    private GreenfootImage imagem;
    
    public Back(){
        imagem = new GreenfootImage("back_button.png");
        setImage(imagem);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            rato();
        } 
    }
    /**
     * Método que verifica se o rato clicou numa imagem
     */
    public void rato(){
        if (getImage() == imagem) {
            Greenfoot.setWorld(new Menu());
        }
    }

}

