import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boneco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the boneco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int tempoJump=15;
    private int tempoQueda=15;
    private boolean podeSaltar=false;
    private boolean saltou=false;
    private boolean direita =true;
    private static int vidaPlayer1 = 6; 
    private static int vidaPlayer2 = 6;
    private GreenfootSound atingido;
    
    public Player()
    {
        atingido = new GreenfootSound("PlayerAtingido.mp3");
    }
    /**
     * Função que faz com que o player1 perca vidas
     */
    protected void perdeVidas(Player1 P1)
    {
            if(isTouching(Zombie.class)||isTouching(Zombie2.class))
            {
                playAtingido();
                P1.adicionaNumeroVidas(-1); 
                
                
            }
            if(isTouching(Lenhador.class)){
                playAtingido();
                P1.adicionaNumeroVidas(-2); 
                
            }
            Cabeca cabeca = (Cabeca) getOneIntersectingObject(Cabeca.class);
            if (cabeca!= null) {
                playAtingido();
                P1.adicionaNumeroVidas(-3); 
                
                 getWorld().removeObject(cabeca);
            }
            if(isTouching(Boss.class)){
                playAtingido();
                P1.adicionaNumeroVidas(-6); 
                
            }
    }
    /**
     * Função que faz com que o player2 perca vidas
     */
    protected void perdeVidas(Player2 P2)
    {
        if(isTouching(Zombie.class)||isTouching(Zombie2.class))
        {
            playAtingido();
            P2.adicionaNumeroVidas(-1); 
            
                
        }
        if(isTouching(Lenhador.class)){
            playAtingido();
            P2.adicionaNumeroVidas(-2); 
        }
        Cabeca cabeca = (Cabeca) getOneIntersectingObject(Cabeca.class);
        if (cabeca != null) {
            playAtingido();
            P2.adicionaNumeroVidas(-3); 
            getWorld().removeObject(cabeca);
        }
        if(isTouching(Boss.class)){
            playAtingido();
            P2.adicionaNumeroVidas(-6); 
        }
    }
    public void act()
    {   
        
    }
    /**
     * Função que dá play ao som do player ao ser atingido
     */
    public void playAtingido()
    {
        atingido.play();
        atingido.setVolume(100);
    }
    public static void setVidaPlayer1(int vidas) {
        vidaPlayer1 = vidas;
    }

    public static void setVidaPlayer2(int vidas) {
        vidaPlayer2 = vidas;
    }
    
}
    
    


