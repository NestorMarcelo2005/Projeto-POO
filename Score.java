import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int pontos;  
    private GreenfootImage imagem;  
    private int score;
    public void act() {
        
    }
    public Score(int inicial) {
        this.score =inicial;
        atualizarImagem(); 
    }
    /**
     * Método que adiciona pontos ao score
     */
    public void adicionarPontos(int valor) {
        pontos += valor;  
        atualizarImagem();  
    }
    /**
     * Método que atualiza imagens
     */
    private void atualizarImagem() {
        imagem = new GreenfootImage("Score: " + pontos, 24, Color.WHITE, new Color(0, 0, 0, 0));  
        setImage(imagem); 
    }
    
    public int getPontos() {
        return pontos;  
    }
    
}
