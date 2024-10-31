import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nemesis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nemesis extends Actor {
    private GreenfootImage[] imagensNemesis;
    private int currentImagem = 0;
    private int contadorFrames = 0;
    private int ciclosCompletos = 0;
    private final int CICLOS_PARA_PARAR = 1;
    private int velocidadeX = 1;
    private boolean parou = false;
    private int contadorAtraso = 0;
    private final int ATRASO_FIM = 150;
    private GreenfootSound somNemesis;
    public Nemesis() {
        imagensNemesis = new GreenfootImage[4];
        carregarImagens(); 
        setImage(imagensNemesis[currentImagem]);
        somNemesis = new GreenfootSound("somNemesis.mp3");
        somNemesis.play();
    }
    /**
     * Função que carrega as Imagens do Nemesis
     */
    private void carregarImagens() {
        for (int i = 0; i < 4; i++) {
            imagensNemesis[i] = new GreenfootImage("nemesis" + i + ".png");
            imagensNemesis[i].scale(150, 200);
        }
    }

    public void act() {
        if (!parou) {
            mover();
            animar();
        } else {
            contadorAtraso++;
            if(contadorAtraso >= ATRASO_FIM){
                mostrarTelaDeFim();
            }
        }
    }
    /**
     * Função que move o Nemesis
     */
    private void mover() {

        if (getX() > getWorld().getWidth()/2) {
            setLocation(getX() - velocidadeX, getY());
        } 
    }
    /**
     * Função que percorre o array e anima o Nemesis
     */ 
    private void animar() {
        contadorFrames++;
        if (contadorFrames >= 40) { 
            currentImagem++;
            if (currentImagem >= imagensNemesis.length) {
                currentImagem = 0;
                ciclosCompletos++;
            }
            setImage(imagensNemesis[currentImagem]);
            contadorFrames = 0;
            if (ciclosCompletos >= CICLOS_PARA_PARAR && currentImagem == imagensNemesis.length -1) {
                parou = true;
            }
        }
    }
    /**
     * Função que mostra o ecrã final
     */
    private void mostrarTelaDeFim(){
        Greenfoot.setWorld(new Fim());
    }
}

