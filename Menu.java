import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private static GreenfootSound musica;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public Menu()
    {    
        super(1200, 700, 1); 
        setBackground ("background1.jpg");
        
        musica = new GreenfootSound("MusicaFundo.mp3");
        colocaOpcoes();
        mostrarTitulo();
        playFundo();
        
    }
    /**
     * Método que dá play à música de fundo
     */
    public void playFundo()
    {
        musica.play();
        musica.setVolume(20);
    }
    /**
     * Método que coloca as opções para poder jogar
     */
    private void colocaOpcoes() 
    {
        Play opcaoPlay = new Play("Play",70);
        Play opcaoOpcoes = new Play("Instruções",70);
        Play opcaoInstrucoes = new Play("Exit",70);
        
        addObject(opcaoPlay, 1000, getHeight()/2-120);
        addObject(opcaoOpcoes, 1000,  getHeight()/2-40);
        addObject(opcaoInstrucoes, 1000, getHeight()/2+40);
        
    }
    /**
     * Método que coloca o titulo do jogo
     */
    private void mostrarTitulo() 
    {
        Color preto = Color.WHITE;
        
        int tamanhoFonte = 150;
        int posicaoY = 100; 
        int posicaoX = 50;     
        GreenfootImage titulo1 = new GreenfootImage("THE", tamanhoFonte, preto, new Color(0, 0, 0, 0));
        getBackground().drawImage(titulo1, posicaoX, posicaoY);
    
        GreenfootImage titulo2 = new GreenfootImage("LAST", tamanhoFonte, preto, new Color(0, 0, 0, 0));
        getBackground().drawImage(titulo2, posicaoX, posicaoY + titulo1.getHeight()); 
    
        GreenfootImage titulo3 = new GreenfootImage("OF US", tamanhoFonte, preto, new Color(0, 0, 0, 0));
        getBackground().drawImage(titulo3, posicaoX, posicaoY + titulo1.getHeight() + titulo2.getHeight()); 
        
    }
    /**
     * Método para fazer loop da musica de fundo
     */
    public void started()
    {
        musica.playLoop();
    }
    
    public static GreenfootSound getMusica(){
        return musica;
    }
    
    public void stopped()
    {
        musica.stop();
    }
    
}
