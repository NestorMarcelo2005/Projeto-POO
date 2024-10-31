import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruções here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrucoes extends World
{

    /**
     * Constructor for objects of class Instruções.
     * 
     */
    private GreenfootImage mensagemNivel;
    private GreenfootImage background = new GreenfootImage("background1.jpg");
    private final int TamanhoTexto=50;
    private int contadorTempo; 
    private static final int TEMPO_VISIVEL = 200; 
    public Instrucoes()
    {    
        super(1200, 700, 1); 
        setBackground("Instrucoes1.png");
        ColocaInstruções();
    }
    /**
     * Função que coloca as instruções, teclas e indicações
     */
    private void ColocaInstruções()
    {
        Color cinzento = new Color(128, 128, 128); 

        addObject(new Texto("Player 1", TamanhoTexto, Color.WHITE, cinzento), getWidth() / 3+50, getHeight() / 6);
        addObject(new Texto("Player 2", TamanhoTexto, Color.WHITE, cinzento), (2 * getWidth()) / 3, getHeight() / 6);
        addObject(new Texto("Saltar", TamanhoTexto, Color.WHITE, cinzento), getWidth() / 8, (2 * getHeight()) / 6);
        addObject(new Texto("Esquerda", TamanhoTexto, Color.WHITE, cinzento), getWidth() / 8, (3 * getHeight()) / 6);
        addObject(new Texto("Direita", TamanhoTexto, Color.WHITE, cinzento), getWidth() / 8, (4 * getHeight()) / 6);
        addObject(new Texto("Atirar", TamanhoTexto, Color.WHITE, cinzento), getWidth() / 8, (5 * getHeight()) / 6);
        
        addObject(new Caixa(1,0,"Salta1.png"), getWidth()/3+50, (2*getHeight())/6);
        addObject(new Caixa(1,1,"Esquerda1.png"), getWidth()/3+50, (3*getHeight())/6);
        addObject(new Caixa(1,2,"Direita1.png"), getWidth()/3+50, (4*getHeight())/6);
        addObject(new Caixa(1,3,"Atirar1.png"), getWidth()/3+50, (5*getHeight())/6);
        addObject(new Caixa(2,0,"Salta2.png"), (2*getWidth())/3, (2*getHeight())/6);
        addObject(new Caixa(2,1,"Esquerda2.png"), (2*getWidth())/3, (3*getHeight())/6);
        addObject(new Caixa(2,2,"Direita2.png"), (2*getWidth())/3, (4*getHeight())/6);
        addObject(new Caixa(2,3,"Atirar2.png"), (2*getWidth())/3, (5*getHeight())/6);
          
        Back botaoBack = new Back();
        addObject(botaoBack,55,50);
    }
    public void act(){
        contadorTempo++;
        if (contadorTempo == TEMPO_VISIVEL) {
            setBackground("Instrucoes2.png"); 
        }
    }
}
    

