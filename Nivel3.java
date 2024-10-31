import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends World
{
    private VidaBoss vidaBoss;
    private Boss boss;
    private int contador;
    private boolean control;
    private GreenfootImage mensagemNivel; 
    private int contadorTempo; 
    private static final int TEMPO_VISIVEL = 200;
    private Score score;
    private Player1 P1;
    private Player2 P2;
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3(int scoretotal)
    {
        super(1200, 700, 1); 
        setBackground("Backgroundfim.png");
        mensagemNivel = new GreenfootImage("Nível Final", 100, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(mensagemNivel, getWidth() / 2 - mensagemNivel.getWidth() / 2, getHeight()/2-200);
        
        addObject(new Plataforma1(),getWidth()/2,getHeight()-30);
        addObject(new Plataformafim(),getWidth()/2,getHeight()-45);
        addObject(new Player2(),10,getHeight()-100);
        addObject(new Player1(),30,getHeight()-100);
        boss = new Boss();
        boss.setBarraDeVida(vidaBoss);
        vidaBoss = new VidaBoss(boss);
        addObject(boss, 1000,570);
        addObject(vidaBoss,getWidth()/2,40);
        addObject(new Vida_Player1(), 285/2, 125);
        addObject(new Vida_Player2(), getWidth()-285/2, 125);
        
        score = new Score(scoretotal);
        addObject(score, getWidth()/2, 10);
    }
    /**
     * Método que dá a tela de gameover quando um dos players morre
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
     * Método que dá reset no numero de vidas de cada personagem
     */
    public void resetGame()
    {
        Player1.resetNumVidas();
        Player2.resetNumVidas();
    }
    /**
     * Método que verifica que o boss morreu e chama o helicoptero
     */
    public void bossMorreu(){
        if (getObjects(Heli.class).isEmpty()) { 
            Heli helicoptero = new Heli();
            addObject(helicoptero, 1300, 100);
            helicoptero.ativarResgate();
        }
    }
    public Score getScore()
    {
        return score;
    }
    public void act() {
        
        gameOver(P1.getNumeroVidas(),P2.getNumeroVidas()); 
    
    }
}
