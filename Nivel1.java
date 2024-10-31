import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{
    
    /**
     * Constructor for objects of class Nivel1.
     * 
     */

    private int contadorTempo; 
    private GreenfootImage mensagemNivel; 
    private static final int TEMPO_VISIVEL = 200; 
    private int imageCount = 0;
    private GreenfootImage background = new GreenfootImage("background1.jpg");
    private static final int SCROLL_SPEED = 1;
    private Player1 P1;
    private Player2 P2;
    private boolean control;
    private Score score;
    private Texto scoreP1, scoreP2;
    private int inicial=0;
    public Nivel1(int scoretotal) {    
        super(1200, 700, 1); 
        setBackground("background1.jpg");
        mensagemNivel = new GreenfootImage("Nível 1", 30, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(mensagemNivel, getWidth() / 2 - mensagemNivel.getWidth() / 2, 30);
        contadorTempo = 0;
        addObject(new Plataforma1(),getWidth()/2,getHeight()-30);
        Player2 player2 = new Player2();
        Player1 player1 = new Player1();
        addObject(player2, 10, getHeight() - 100);
        addObject(player1, 45, 591);
        
        addObject(new Plataforma3(),998, 578);
        addObject(new Predio(),getWidth(),getHeight()-260);
        addObject(new Plataforma2(),575, 509);
        addObject(new Plataforma2(),70, 445);
        addObject(new Plataforma2(),449,302);
        addObject(new Plataforma3(),836,124);
        
        
        addObject(new Zombie(), getWidth()/2+150,433);  
        addObject(new Zombie(), getWidth()/2-100,227);  
        addObject(new Zombie2(), 837,48);
        Trapdoor trapdoor = new Trapdoor();
        addObject(trapdoor,  1103, 238);
        
        addObject(new Vida_Player1(), 285/2, 125);
        addObject(new Vida_Player2(), getWidth()-285/2, 125);
        score = new Score(inicial);
        addObject(score, getWidth()/2, 10);
        
    }
    
    public void act() {
        contadorTempo++;
        if (contadorTempo == TEMPO_VISIVEL) {
            setBackground("background1.jpg"); 
        }
        gameOver(P1.getNumeroVidas(),P2.getNumeroVidas()); 
        
    }
    /**
     * Método para quando um dos players morrer
     */
    private void gameOver(int vidaJogador1, int vidaJogador2){
        if ((vidaJogador1 <=0 || vidaJogador2 <= 0) && !control ){
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            Greenfoot.playSound("GameOver.mp3");

            Restart botaoRestart = new Restart();
            addObject(botaoRestart, getWidth() / 2, getHeight() / 2 + 200);

            control =true;
            resetGame();
        }
    }
    /**
     * Método que dá reset no número de vidas
     */
    public void resetGame()
    {
        Player1.resetNumVidas();
        Player2.resetNumVidas();
    }
    public Score getScore()
    {
        return score;
    }
    
}
