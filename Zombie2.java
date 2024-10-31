import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombie2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie2 extends Actor
{
    /**
     * Act - do whatever the zombie2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int indice;
    private GreenfootImage[] zombie;
    private GreenfootImage[] zombieesquerda;
    private int counter;
    private boolean direita = false;
    private int vida;
    public Zombie2(){
        imagens();
        vida = 2;
    }
    public void act()
    {   
        if (vida <= 0){
            morre();
            return;
        }
        if (verificaPlataforma1()) {
            moveZombiePlataforma1();
        } else if (verificaPlataforma2()) {
            moveZombiePlataforma2();
        }else if(verificaPlataforma3()){
            moveZombiePlataforma3();
        }
        
    }
    /**
     * Função que carrega as imagens do zombie
     */
    public void imagens(){
        zombie= new GreenfootImage[8];
        
        zombie[0]= new GreenfootImage("zombie21.png");
        zombie[1]= new GreenfootImage("zombie22.png");
        zombie[2]= new GreenfootImage("zombie23.png");
        zombie[3]= new GreenfootImage("zombie24.png");
        zombie[4]= new GreenfootImage("zombie25.png");
        zombie[5]= new GreenfootImage("zombie26.png");
        zombie[6]= new GreenfootImage("zombie27.png");
        zombie[7]= new GreenfootImage("zombie28.png");
        
        zombieesquerda= new GreenfootImage[8];
        
        zombieesquerda[0]= new GreenfootImage("zombie21esquerda.png");
        zombieesquerda[1]= new GreenfootImage("zombie22esquerda.png");
        zombieesquerda[2]= new GreenfootImage("zombie23esquerda.png");
        zombieesquerda[3]= new GreenfootImage("zombie24esquerda.png");
        zombieesquerda[4]= new GreenfootImage("zombie25esquerda.png");
        zombieesquerda[5]= new GreenfootImage("zombie26esquerda.png");
        zombieesquerda[6]= new GreenfootImage("zombie27esquerda.png");
        zombieesquerda[7]= new GreenfootImage("zombie28esquerda.png");
    }
    /**
     * Funnção que move o zombie em cima da plataforma
     */
    public void moveZombiePlataforma1() {
        if (atBordaDireita() && direita) {
            direita = false; 
        } else if (atBordaEsquerda() && !direita) {
            direita = true;  
        }

        if (direita) {
            setLocation(getX() + 5, getY());  
            zombieanima(); 
        } else {
            setLocation(getX() - 5, getY());  
            zombieanimaesquerda(); 
        }
    }
    public void moveZombiePlataforma2() {
        if (atBordaDireita2() && direita) {
            direita = false;  
        } else if (atBordaEsquerda2() && !direita) {
            direita = true;   
        }

        if (direita) {
            setLocation(getX() + 5, getY());  
            zombieanima(); 
        } else {
            setLocation(getX() - 5, getY());  
            zombieanimaesquerda(); 
        }
    }
    public void moveZombiePlataforma3() {
        if (atBordaDireita3() && direita) {
            direita = false;  
        } else if (atBordaEsquerda3() && !direita) {
            direita = true;   
        }

        if (direita) {
            setLocation(getX() + 5, getY());  
            zombieanima(); 
        } else {
            setLocation(getX() - 5, getY());  
            zombieanimaesquerda(); 
        }
    }
    /**
     * Função que percorre o array de imagens do zombie e anima-o 
     */
    public void zombieanima() {
        counter++;
        if (counter > 10) {
            indice++;
            if (indice >= zombie.length) {
                indice = 0;
            }
            counter = 0;
        }
        setImage(zombie[indice]);
    }
    /**
     * Função que percorre o array de imagens do zombie e anima-o mas para o lado esquerdo
     */
    public void zombieanimaesquerda() {
        counter++;
        if (counter > 10) {
            indice++;
            if (indice >= zombieesquerda.length) {
                indice = 0;
            }
            counter = 0;
        }
        setImage(zombieesquerda[indice]);
    }
    /**
     * Função que verifica se o zombie esta em cima da plataforma
     */
    public boolean verificaPlataforma1() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma1.class);
        return emCima != null;
    }
    public boolean verificaPlataforma2() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma2.class);
        return emCima != null;
    }
    public boolean verificaPlataforma3() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma3.class);
        return emCima != null;
    }
    /**
     * Função que verifica se o zombie está na borda direita da plataforma
     */
    public boolean atBordaDireita() {
        Actor bordaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma1.class);
        return bordaDireita == null;
    }
    public boolean atBordaDireita2() {
        Actor bordaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma2.class);
        return bordaDireita == null;
    }
    public boolean atBordaDireita3() {
        Actor bordaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma3.class);
        return bordaDireita == null;
    }
    
    /**
     * Função que verifica se o zombie está na borda esquerda da plataforma
     */
    public boolean atBordaEsquerda() {
        Actor bordaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma1.class);
        return bordaEsquerda == null;
    }
    public boolean atBordaEsquerda2() {
        Actor bordaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma2.class);
        return bordaEsquerda == null;
    }
    public boolean atBordaEsquerda3() {
        Actor bordaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Plataforma3.class);
        return bordaEsquerda == null;
    }
    
    public int getVida()
    {
        return vida;
    }   

    public void tiraVida(int valor)
    {
        vida-=valor;
    }
    /**
     * Função que remove o zombie do mundo quando morre
     */
    public void morre(){
        if (vida <= 0){
            getWorld().removeObject(this);
        }
    }
}
