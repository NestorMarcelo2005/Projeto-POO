import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
/**
 * Write a description of class Heli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heli extends Actor
{
    private GreenfootSound somHelicoptero;
    private boolean jaTocou = false;
    private int velocidadeX = 2;
    private int velocidadeY = 1;
    private boolean resgateAtivo = false;
    private boolean parado = false;
    private GreenfootImage[] imagensHeli;
    private int currentImagem = 0;
    private int contadorFrames = 0;

    public Heli() {
        imagensHeli = new GreenfootImage[4];
        carregarImagens();
        setImage(imagensHeli[currentImagem]);
        somHelicoptero = new GreenfootSound("helicoptero.mp3");
    }
    
    /**
     * Função que carrega as imagens do helicóptero
     */
    private void carregarImagens(){
        imagensHeli[0] = new GreenfootImage("helicoptero2.png");
        imagensHeli[1] = new GreenfootImage("helicoptero3.png");
        imagensHeli[2] = new GreenfootImage("helicoptero4.png");
        imagensHeli[3] = new GreenfootImage("helicoptero5.png");
    }

    public void act() {
        if (!jaTocou){
            somHelicoptero.playLoop();
            jaTocou = true;
        }
        if (resgateAtivo) {
            mover();
            animarDescida();
        }
    }
    /**
     * Função que percorre o array de imagens e anima o helicóptero
     */
    private void animarDescida() {
        contadorFrames++;
        if (contadorFrames >= 5) {
            currentImagem = (currentImagem + 1) % imagensHeli.length;
            setImage(imagensHeli[currentImagem]);
            contadorFrames = 0;
        }
    }
    /**
     *  Função que atualiza a variável resgate
     */
    public void ativarResgate() {
        resgateAtivo = true;
    }
    /**
     * Função que move o helicóptero pelo mundo até chegar ao centro e depois chama o missil
     */
    public void mover() {
        int centroX = getWorld().getWidth() / 2;
        int centroY = getWorld().getHeight() / 2;
        if (!parado) {
            if (getX() > centroX) {
                setLocation(getX() - velocidadeX, getY() + velocidadeY);
            } else if (getX() < centroX) {
                setLocation(getX() + velocidadeX, getY() + velocidadeY);
            }
            if (getX() <= centroX + 10 && getX() >= centroX - 10) {
                parado = true;
                setLocation(centroX, centroY);
                criarMissil();
            }
        }
    }
    /**
     * Função que remove o helicóptero do mundo e para o som do mesmo
     */
    public void explodir(){
        somHelicoptero.stop();
        getWorld().removeObject(this);  
    }
    /**
     * Função que cria o missil no mundo
     */
    private void criarMissil(){
        Missil missil = new Missil();
        getWorld().addObject(missil,getWorld().getWidth() + 50, getY());
    }
}
