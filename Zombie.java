import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int indice;
    private GreenfootImage[] zombie;
    private GreenfootImage[] zombieesquerda;
    private int counter;
    private boolean direita = false;
    private int vida;
    public Zombie(){
        imagens();
        vida = 2;
    }
    public void act()
    {   if (vida <= 0){
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
        
        zombie[0]= new GreenfootImage("zombie1.png");
        zombie[1]= new GreenfootImage("zombie2.png");
        zombie[2]= new GreenfootImage("zombie3.png");
        zombie[3]= new GreenfootImage("zombie4.png");
        zombie[4]= new GreenfootImage("zombie5.png");
        zombie[5]= new GreenfootImage("zombie6.png");
        zombie[6]= new GreenfootImage("zombie7.png");
        zombie[7]= new GreenfootImage("zombie8.png");
        
        zombieesquerda= new GreenfootImage[8];
        
        zombieesquerda[0]= new GreenfootImage("zombie1esquerda.png");
        zombieesquerda[1]= new GreenfootImage("zombie2esquerda.png");
        zombieesquerda[2]= new GreenfootImage("zombie3esquerda.png");
        zombieesquerda[3]= new GreenfootImage("zombie4esquerda.png");
        zombieesquerda[4]= new GreenfootImage("zombie5esquerda.png");
        zombieesquerda[5]= new GreenfootImage("zombie6esquerda.png");
        zombieesquerda[6]= new GreenfootImage("zombie7esquerda.png");
        zombieesquerda[7]= new GreenfootImage("zombie8esquerda.png");
    }
    /**
     * Função que verifica se o zombie está em contacto com a Plataforma1
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
    /**
     * Função que verifica se o zombie está em contacto com a Plataforma2
     */
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
    /**
     * Função que verifica se o zombie está em contacto com a Plataforma3
     */
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
     * Função que percorre o array de imagens e anima o zombie
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
     * Função que percorre o array de imagens e anima o zombie mas do lado esquerdo
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
     * Função que verifica se o zombie chegou à borda esquerd da plataforma
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
     * Função que verifica se o zombie chegou à borda esquerda da plataforma
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
     * Função que retira o zombie do mundo quando ele morre
     */
    public void morre(){
        if (vida <= 0){
            getWorld().removeObject(this);
        }
    }
}
