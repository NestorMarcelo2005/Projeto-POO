import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VidaBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VidaBoss extends Boss
{
    private int Largurahealthbar = 800;
    private int Alturahealthbar = 40;
    private int vida = Boss.getVida();
    private int Vidapercentagem = (int)Largurahealthbar/vida; 
    public VidaBoss(Boss boss)
    {
        boss.setBarraDeVida(this);
        update();
    }
    
    public void act()
    {
        update();
    }
    
    public void update()
    { 
        setImage(new GreenfootImage(Largurahealthbar + 2, Alturahealthbar + 2));
        GreenfootImage myImage = getImage();
        vida = Boss.getVida();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, Largurahealthbar + 1, Alturahealthbar + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, vida * Vidapercentagem, Alturahealthbar);
    }
}
