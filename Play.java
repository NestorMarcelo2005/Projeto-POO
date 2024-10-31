import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opcoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    /**
     * Act - do whatever the Opcoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String texto;
    private Color corPadrao = Color.WHITE;
    private Color corSecundaria = Color.YELLOW;
    private Color Cordefault = new Color(0, 0, 0, 0);
    private int tamanhoFonte;
    private int totalscore=0;
    public Play(String texto, int tamanhoFonte) {
        this.texto = texto;
        this.tamanhoFonte = tamanhoFonte;  
        atualizarImagem(corPadrao);
    }
    /**
     * Função que muda a cor da palavra quando passar o rato por cima
     */
    private void atualizarImagem(Color cor) {
        GreenfootImage imagem = new GreenfootImage(texto, tamanhoFonte, cor, Cordefault);
        setImage(imagem);
    }

    public void act() {
        if (Greenfoot.mouseMoved(this)) {
            atualizarImagem(corSecundaria); 
        } else if (Greenfoot.mouseMoved(null)) {
            atualizarImagem(corPadrao); 
        }
        if (Greenfoot.mouseClicked(this)) {
            rato();
        }
    }
    
    /**
     * Função que verifica em qual dos textos o rato clicou
     */
    public void rato() {
        if (texto.equals("Play")) {
            Greenfoot.setWorld(new Nivel1(totalscore));
        } else if (texto.equals("Instruções")) {
            Greenfoot.setWorld(new Instrucoes());
        } else if (texto.equals("Exit")) {
            Greenfoot.stop();
        }
    }
    
}
