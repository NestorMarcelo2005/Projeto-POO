import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trapdoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trapdoor extends Actor
{
    /**
     * Act - do whatever the Trapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean passardenivel=false;
    public void act()
    {
        porta();
    }
    /**
     * Função que verifica se ambos os players estão em cima da trapdoor e passa do Nivel 1 para o 2
     */
    public void porta(){
        
        if(isTouching(Player1.class) && isTouching(Player2.class)){
            passardenivel=true;
            Trapdooraberta trapdooraberta = new Trapdooraberta();
            getWorld().addObject(trapdooraberta, 1103, 238);
            
            Nivel1 nivel=(Nivel1) getWorld();
            int totalScore = nivel.getScore().getPontos();
            Greenfoot.setWorld(new Nivel2(totalScore));
        }
        
    }
    
}
