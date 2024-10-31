import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caixa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caixa extends Actor
{
    /**
     * Act - do whatever the Caixa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Boolean flag;
    private Boolean prepara;
    private int player;
    private int controlo;
    private GreenfootImage image;
    /**
     * Função que coloca as imagens das teclas no World Instruções
     */
    public Caixa(int player, int controlo, String nomeImagem) {
        this.flag = true;
        this.prepara = true;
        this.player = player;
        this.controlo = controlo;
    
        this.image = new GreenfootImage(nomeImagem);
        setImage(image);
    }
}