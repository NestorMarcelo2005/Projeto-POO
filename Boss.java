import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class Bosss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Random randomGenerator; 
    private GreenfootImage[] ataque1esquerda;
    private GreenfootImage[] ataque2esquerda;
    private GreenfootImage[] fingir;
    private GreenfootImage andar;
    private GreenfootImage preataque;
    private GreenfootImage preataqueesquerda;
    private GreenfootImage parado;
    private int indice=0;
    private int contador;
    private int contadorAnimacao;
    private boolean atacarEsquerda = false; 
    private boolean emAtaque = false;
    private boolean ataque1Ativo;
    private Cabeca cabeca;
    private static int vida;
    private VidaBoss barraDeVida;
    private int ataqueAtivo;
    private int contadorTempoAtaque;
    private GreenfootSound somDano;
    private GreenfootSound gritoDeMorte;
    private boolean jaGritou = false;
    
    public Boss() {
        prepararImagens();
        cabeca = new Cabeca();
        vida = 40;
        randomGenerator = new Random();
        somDano = new GreenfootSound("somDano.mp3");
        gritoDeMorte = new GreenfootSound("BossMorte.mp3");
    }
    public void act() {
        if (vida <= 0) {
            morre();
        } else {
            if(vida <=2 && !jaGritou){
                    gritoDeMorte.play();
                    jaGritou = true;
            }
            if (emAtaque) {
                if (ataqueAtivo == 1) {
                    animaataque1();  
                } else {
                    animaataque2(); 
                }
            } else {
                verificarEAtacar();  
            }
            if (contadorTempoAtaque < 100) {
                contadorTempoAtaque++;
            }
        }  
    }
    /**
     * Método que carrega as imagens para os arrays das mesmas
     */
    public void prepararImagens() {

        ataque1esquerda = new GreenfootImage[7];
        ataque2esquerda = new GreenfootImage[8];
        fingir = new GreenfootImage[5];
        andar = new GreenfootImage("andaresquerda.png");
        parado = new GreenfootImage("paradoesquerda.png");
        preataqueesquerda = new GreenfootImage("preataqueesquerda.png");
    
        
        ataque1esquerda[0] = preataqueesquerda;
        ataque1esquerda[1] = new GreenfootImage("ataque1.1esquerda.png");
        ataque1esquerda[2] = new GreenfootImage("ataque1.2esquerda.png");
        ataque1esquerda[3] = new GreenfootImage("ataque1.3esquerda.png");
        ataque1esquerda[4] = new GreenfootImage("ataque1.4esquerda.png");
        ataque1esquerda[5] = new GreenfootImage("ataque1.5esquerda.png");
        ataque1esquerda[6] = new GreenfootImage("ataque1.6esquerda.png");
    
        ataque2esquerda[0] = preataqueesquerda;
        ataque2esquerda[1] = new GreenfootImage("ataque2.1esquerda.png");
        ataque2esquerda[2] = new GreenfootImage("ataque2.2esquerda.png");
        ataque2esquerda[3] = new GreenfootImage("ataque2.3esquerda.png");
        ataque2esquerda[4] = new GreenfootImage("ataque2.4esquerda.png");
        ataque2esquerda[5] = new GreenfootImage("ataque2.5esquerda.png");
        ataque2esquerda[6] = new GreenfootImage("ataque2.6esquerda.png");
        ataque2esquerda[7] = new GreenfootImage("ataque2.7esquerda.png");
        
    }
    /**
     * Função que percorre os arrays de imagens
     */
    public void animaataque1() {
        contadorAnimacao++;
        if (contadorAnimacao >= 20 && indice < ataque1esquerda.length) {
            indice++;
            setImage(ataque1esquerda[indice]); 
            contadorAnimacao = 0;  
        }

        if (indice == ataque1esquerda.length - 1) {
            emAtaque = false; 
            setImage(parado);  
        }
    }
    public void animaataque2()
    {
        contadorAnimacao++;
        if (contadorAnimacao >= 20 && indice < ataque2esquerda.length) {
            indice++;
            setImage(ataque2esquerda[indice]);  
            contadorAnimacao = 0;
            
        }

        if (indice == ataque2esquerda.length - 2) {
            int larguraImagem = ataque2esquerda[ataque2esquerda.length - 2].getWidth();
            int posicaoXCabeca = getX() - larguraImagem / 2;
            int posicaoYCabeca = getY();
            if (getWorld().getObjects(Cabeca.class).isEmpty()) {
                getWorld().addObject(cabeca, posicaoXCabeca, posicaoYCabeca);
            }
        }
        if (indice == ataque2esquerda.length - 1) {
            emAtaque = false; 
            setImage(parado); 
            indice = 0;
        }
    }
    /**
     * método que decide que o boss vai andar, com 1% de chance
     */
    public void andar() {
        contador++;
        int numero = Greenfoot.getRandomNumber(100);
        if (numero < 5) { 
            setLocation(getX() - 5, getY());
        }
        if (contador >= 10) {
            contador = 0; 
        }
    }
    /**
     * Metodo que decide qual dos ataques o boss vai usar, um com 10%, outro com 90%
     */
     public void verificarEAtacar() {
        int numeroAleatorio = randomGenerator.nextInt(100) + 1; 
            if (numeroAleatorio <= 10) { 
                Ataque(1);
            } else {
                Ataque(2); 
            }

        andar();        
    }
    /**
     * Função ajudante, reinicia as variaveis
     */
    public void Ataque(int tipoAtaque) {
        contador = 0;
        emAtaque = true; 
        indice = 0; 
        contadorAnimacao = 0;
        ataqueAtivo = tipoAtaque; 
        contadorTempoAtaque = 0;
    }
    
    /**
     * 
     */
    public static int getVida()
    {
        return vida;
    }   
    /**
     * Método que tira vida ao boss e dá o som de dano ao mesmo
     */
    public static void tiraVida(int valor)
    {
        vida-=valor;
        GreenfootSound somDano = new GreenfootSound("somDano.mp3");
        somDano.play();
    }

    public void setBarraDeVida(VidaBoss barraDeVida) {
        this.barraDeVida = barraDeVida;
    }
    /**
     * Função que faz com que o boss morra
     */
    public void morre(){
            if (barraDeVida != null){
                getWorld().removeObject(barraDeVida);
            }
            ((Nivel3) getWorld()).bossMorreu();
            getWorld().removeObject(this);
        }
}
