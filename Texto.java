import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Actor
{
    /**
     * Act - do whatever the Texto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Color corTexto;
    private Color corFundo;
    
    public Texto(String text, int size, Color corTexto, Color corFundo) {
        this.corTexto = corTexto;
        this.corFundo = corFundo;
        atualizarImagem(text, size);
    }
    /**
     * O método serve para atualizar a imagem exibida pelo objeto
     */
    private void atualizarImagem(String text, int size) {
        GreenfootImage image = new GreenfootImage(text.toUpperCase(), size, corTexto, corFundo);
        setImage(image);
    }
}

