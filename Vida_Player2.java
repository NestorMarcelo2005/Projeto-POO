import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_Player2 extends Player2
{
    /**
     * Act - do whatever the Vida_player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] vidas;
    
    public Vida_Player2()
    {
        vidas = new GreenfootImage[6];
        for (int i=0; i < vidas.length; i++)
        {
            vidas[i] = new GreenfootImage("Vida/"+(i+1)+".png");
        }
    }

    public void act() 
    {
        vidaPlayer2();
    }   
    /**
     *  Método que atualiza a imagem das vidas
     */
    public void vidaPlayer2()
    {
        if (Player2.getNumeroVidas() >0)
        {
            setImage(vidas[Player2.getNumeroVidas()-1]);
        }
        else {
            getWorld().removeObject(this);
        }    
    }  
}
