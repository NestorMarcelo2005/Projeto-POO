import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fumo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fumo extends Actor
{
    /**
     * Act - do whatever the Fumo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] fumo;
    private int indice;
    private int counter; 
    public Fumo()
    {
        imagens();
            
    }
    public void act()
    {
        
        fumoanima();
    }
    /**
     * Função que prepara as imagens de fumo
     */
    public void imagens(){
        fumo= new GreenfootImage[5];
        
        fumo[0]= new GreenfootImage("fumo.png");
        fumo[1]= new GreenfootImage("fumo2.png");
        fumo[2]= new GreenfootImage("fumo3.png");
        fumo[3]= new GreenfootImage("fumo4.png");
        fumo[4]= new GreenfootImage("fumo5.png");
    }
    /**
     * Função que percorre o array de imagens, em que anima o fundo e depois desaparece
     */
    public void fumoanima(){
        indice++;
        counter++;
            if (indice >=fumo.length)
            {
                indice =0;
            }
        setImage(fumo[indice]);
        if(counter>10){
            getWorld().removeObject(this);
        }
    }
}
