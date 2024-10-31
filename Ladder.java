import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ladder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ladder extends Actor
{
    /**
     * Act - do whatever the Ladder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tocar();
    }
    /**
     * Função que muda de mundo quando ambos os players chegam ao fim do mesmo
     */
    public void tocar(){
        if(isTouching(Player1.class) && isTouching(Player2.class)){
            
            Nivel2 nivel=(Nivel2) getWorld();
            int totalScore = nivel.getScore().getPontos();
            Greenfoot.setWorld(new Nivel3(totalScore));
            
        }
    }
}
