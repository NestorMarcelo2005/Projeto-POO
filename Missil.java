import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missil extends Actor
{
    /**
     * Act - do whatever the missil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] imagensExplosao;
    private int contadorExplosao = 0;
    private int currentExplosao = 0;
    private boolean emExplosao = false;
    private int posicaoXExplosao;
    private int posicaoYExplosao;
    private boolean explosaoIniciada = false;
    private GreenfootSound somExplosao;
    
    public Missil(){
        setImage("missil.png");
        imagensExplosao = new GreenfootImage[48];
        for (int i = 0; i < 48; i++) {
            imagensExplosao[i] = new GreenfootImage("explosao" + i + ".png");
            imagensExplosao[i].scale(imagensExplosao[i].getWidth() * 5, imagensExplosao[i].getHeight() * 5);
        }
        somExplosao = new GreenfootSound("explosao.mp3");
    }

    public void act()
    {
        if(emExplosao) {
            animarExplosao();
        }else{
            mover();
        }
    }
    /**
     * Função que anima a explosão do missil
     */
    private void animarExplosao() {
        contadorExplosao++;
        if (contadorExplosao >= 5) {
            contadorExplosao = 0;
            currentExplosao++;
            if (currentExplosao < imagensExplosao.length) {
                setImage(imagensExplosao[currentExplosao]);
                setLocation(posicaoXExplosao, posicaoYExplosao);
            } else {
                adicionarNemesis();
                getWorld().removeObject(this);
            }
        }
    }
    /**
     * Função que faz o missil mover-se e quando tocar no helicóptero fazer a animação e som de explosão
     */
    private void mover() {
        setLocation(getX() - 10, getY());

        if (isTouching(Heli.class)) {
            Heli helicoptero = (Heli) getOneIntersectingObject(Heli.class);
            if (helicoptero != null) {
                posicaoXExplosao = helicoptero.getX();
                posicaoYExplosao = helicoptero.getY();
                helicoptero.explodir(); 
                emExplosao = true;
                somExplosao.play();
            }
            emExplosao = true;
        }
    }
    /**
     * Função que spawna o Nemesis
     */
    private void adicionarNemesis() {
        if (getWorld() != null) {
            Nemesis nemesis = new Nemesis();
            getWorld().addObject(nemesis, getWorld().getWidth(), getWorld().getHeight() - 150);
        }
    }

    
}

