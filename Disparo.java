import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class municao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disparo extends Actor
{
    /**
     * Act - do whatever the municao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    


    public void act() {
        
        atirar();
        
        if (isAtEdge() || atingiuBoss()||atingiuzombie1()||atingiuzombie2()||atingiulenhador()||isTouching(Predio.class)||isTouching(Bookshelf.class)||isTouching(Prateleira.class)) {
            getWorld().removeObject(this); 
        }
    }
    /**
     * Função que faz com que a bala se mova
     */
    public void atirar() {
        move(15); 
        
    }
    /**
     * Função que faz com que o disparo dê dano ao Boss
     */
    private boolean atingiuBoss()
    {
        if (isTouching(Boss.class) && getWorld().getObjects(Boss.class).get(0).getVida() > 0)
        {
            getWorld().getObjects(Boss.class).get(0).tiraVida(1);
            Nivel3 Nivel3 = (Nivel3) getWorld();
            Nivel3.getScore().adicionarPontos(3000);
            return true;
        }
        return false;
    }
    /**
     * Função que faz com que o disparo dê dano ao Zombie1
     */
    private boolean atingiuzombie1()
    {
        if (isTouching(Zombie.class) && getWorld().getObjects(Zombie.class).get(0).getVida() > 0)
        {
            getWorld().getObjects(Zombie.class).get(0).tiraVida(1);
            Nivel1 Nivel1 = (Nivel1) getWorld();
            Nivel1.getScore().adicionarPontos(300);
            return true;
        }
        return false;
    }
    /**
     * Função que faz com que o disparo dê dano ao Zombie2
     */
    private boolean atingiuzombie2()
    {
        if (isTouching(Zombie2.class) && getWorld().getObjects(Zombie2.class).get(0).getVida() > 0)
        {
            getWorld().getObjects(Zombie2.class).get(0).tiraVida(1);
            Nivel1 Nivel1 = (Nivel1) getWorld();
            Nivel1.getScore().adicionarPontos(300);
            return true;
        }
        return false;
    }
    /**
     * Função que faz com que o disparo dê dano ao Lenhador
     */
    private boolean atingiulenhador()
    {
        if (isTouching(Lenhador.class) && getWorld().getObjects(Lenhador.class).get(0).getVida() > 0)
        {
            getWorld().getObjects(Lenhador.class).get(0).tiraVida(1);
            Nivel2 Nivel2 = (Nivel2) getWorld();
            Nivel2.getScore().adicionarPontos(500);
            return true;
        }
        return false;
    }
    
}
