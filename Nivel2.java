import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends World
{
    private GreenfootImage mensagemNivel; 
    private int contadorTempo; 
    private static final int TEMPO_VISIVEL = 200;
    private Player1 P1;
    private Player2 P2;
    private boolean control;
    private Score score;
    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2(int scoretotal)
    {    
        super(1200, 700, 1); 
        setBackground("Background2.png");
        mensagemNivel = new GreenfootImage("Nível 2", 30, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(mensagemNivel, getWidth() / 2 - mensagemNivel.getWidth() / 2, 30);
        addObject(new Armario(),390,660);
        addObject(new Ladder(),1180,130);
        addObject(new Prateleira(),850,385);
        addObject(new Prateleira(),810,462);
        addObject(new Prateleira(),763,538);
        addObject(new Bookshelf(),1020,500);
        
        Player2 player2 = new Player2();
        Player1 player1 = new Player1();
        
        addObject(player2, 92, 565);
        addObject(player1, 139, 565);
        Lenhador lenhador1= new Lenhador();
        Lenhador lenhador2 = new Lenhador();
        addObject(lenhador1,548,591);
        addObject(lenhador2,945,270);
        addObject(new Vida_Player1(), 285/2, 125);
        addObject(new Vida_Player2(), getWidth()-285/2, 125);
        
        score = new Score(scoretotal);
        addObject(score, getWidth()/2, 10);
    }
    public void act() {
        contadorTempo++;
        if (contadorTempo == TEMPO_VISIVEL) {
            setBackground("Background2.png"); 
        }
        gameOver(P1.getNumeroVidas(),P2.getNumeroVidas()); 
    
    }
    /**
     * Método que dá game over quando um dos players morre
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
     * Método que dá reset no número de vidas do player quando volta o jogo
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
