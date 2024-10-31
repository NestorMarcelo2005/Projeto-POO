import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] andarImagens;
    private GreenfootImage[] andarImagensesquerda;
    private GreenfootImage[] atirar;
    private GreenfootImage[] atiraresquerda;
    private GreenfootImage image3;
    private GreenfootImage image3esquerda;
    private int velocidadeVertical = 0;
    private boolean noAr = true;    
    private int currentImage = 0;
    private boolean direita =true;
    private int indice;
    private int indiceAndar = 0;
    private int indiceAtirar = 0;
    private int delay =0;
    private String tecla="up";
    private boolean podeSaltar=false;
    private boolean saltou; 
    private int tempoQueda;
    private int tempoJump=15;
    private List<Actor> listaDeAtores;
    private int velocidade;
    private int aceleracao;
    private static int numeroVidas=6;
    private static int score=0;
    private Player1 P1;
    private int delay2;
    public void act()
    {
        prepararImagens();
        if (getWorld() instanceof Nivel1) {
            andar();
        }
        else if(getWorld() instanceof Nivel2){
            andar2();
        }
        else if(getWorld() instanceof Nivel3){
            andar();
        }
        atirar();
        delay2++;
        if(delay2>15){
            perdeVidas(P1);
            delay2=0;
        }
    }
    public static int getNumeroVidas()
    {
        return numeroVidas;
    }

    public static void resetNumVidas()
    {
        numeroVidas=6;
    }
    /**
     * Função que adiciona vidas ao player
     */
    public static void adicionaNumeroVidas(int valor)
    {
        if (valor<0 || (valor > 0 && numeroVidas<5))
        {
            numeroVidas += valor;
        }
        else
        {
            if(numeroVidas<6)
            {
                numeroVidas++;
            }
        }
    }
    public static int getScore()
    {
        return score;
    }

    public static void resetScore()
    {
        score=0;
    }

    public static void adicionaScore(int valor)
    {
        score+=valor;
        if(score<0)
        {
            score-=valor;
        }
    }
    /**
     * Função que carrega as imagens do player
     */
    public void prepararImagens() {
        andarImagens = new GreenfootImage[3];
        image3 = new GreenfootImage("Joel.png");
        image3esquerda = new GreenfootImage("Joel.png");
        
        andarImagens[0] = new GreenfootImage("Joelandar.png");
        andarImagens[1] = new GreenfootImage("Joelandar2.png");
        andarImagens[2] = new GreenfootImage("Joelandar3.png");

        
        andarImagensesquerda = new GreenfootImage[3];
        
        andarImagensesquerda[0] = new GreenfootImage("Joelandaresquerda.png");
        andarImagensesquerda[1] = new GreenfootImage("Joelandar2esquerda.png");
        andarImagensesquerda[2] = new GreenfootImage("Joelandar3esquerda.png");
              
        atirar = new GreenfootImage[6];
        
        atirar[0]= new GreenfootImage("Joelatirar.png");
        atirar[1] = new GreenfootImage("Joelatirar1.png");
        atirar[2] = new GreenfootImage("Joelatirar2.png");
        atirar[3] = new GreenfootImage("Joelatirar2.png");
        atirar[4] = new GreenfootImage("Joelatirar2.png");
        atirar[5] = new GreenfootImage("Joelatirar2.png");
        
        atiraresquerda = new GreenfootImage[6];
        
        atiraresquerda[0]= new GreenfootImage("Joelatiraresquerda.png");
        atiraresquerda[1] = new GreenfootImage("Joelatirar1esquerda.png");
        atiraresquerda[2] = new GreenfootImage("Joelatirar2esquerda.png");
        atiraresquerda[3] = new GreenfootImage("Joelatirar2esquerda.png");
        atiraresquerda[4] = new GreenfootImage("Joelatirar2esquerda.png");
        atiraresquerda[5] = new GreenfootImage("Joelatirar2esquerda.png");
    }
    /**
     * Função que faz com que o player ande, salte... no nivel 1 e 3
     */
    public void andar()
    {   
        if(verificaplat1()||verificaplat2()||verificaplat3()||verificapredio()){
            podeSaltar=true;
            saltou = false;
        }
        if (Greenfoot.isKeyDown("up") && podeSaltar){
            saltou=true;
            podeSaltar=false;
        }
        if(saltou){
            jump();
            verificarColisaoCima(); 
            verificarColisaoCimaplat2();
            verificarColisaoCimaplat3();
            verificarColisaoCimapredio();
            
        }
        
        if(Greenfoot.isKeyDown("left")&&(colisaoComParteVerticalesquerda()||colisaoComParteVerticalplat2esquerda()||colisaoComParteVerticalplat3esquerda()||colisaoComParteVerticalpredioesquerda())){
            andaranimaesquerda();
            setLocation(getX()+5, getY());
            direita=false;
        }
        if(Greenfoot.isKeyDown("right")&&(colisaoComParteVertical()||colisaoComParteVerticalplat2()||colisaoComParteVerticalplat3()||colisaoComParteVerticalpredio())){
            andaranima();
            setLocation(getX()-5, getY());
            direita=true;
        }
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-5, getY());
            andaranimaesquerda();
            direita=false;
        }
        else if (Greenfoot.isKeyDown("right") ){
            setLocation(getX()+5, getY());
            andaranima();
            direita=true;
        }else{
            setImage("Joel.png");
        }
        quedaplat1();
        quedaplat2();
        quedaplat3(); 
        quedapredio();
        onGround();
        onGround2();
        onGround3();
        onGround4();
        reposicionarSeNaBordaInferior();
    }
    /**
     * Função que faz com que o player ande, salte... no nivel 2
     */
    public void andar2()
    {   
        if(verificaprateleira()||verificaarmario()||verificabookshelf()){
            podeSaltar=true;
            saltou = false;
        }
        if (Greenfoot.isKeyDown("up") && podeSaltar){
            saltou=true;
            podeSaltar=false;
        }
        if(saltou){
            jump();

            verificarColisaoCimaprateleira();
            verificarColisaoCimabookshelf();
            verificarColisaoCimaarmario();
        }
        
        if(Greenfoot.isKeyDown("left")&&(colisaoComParteVerticalprateleiraesquerda()||colisaoComParteVerticalarmarioesquerda()||colisaoComParteVerticalbookshelfesquerda())){
            andaranimaesquerda();
            setLocation(getX()+5, getY());
            direita=false;
        }
        if(Greenfoot.isKeyDown("right")&&(colisaoComParteVerticalprateleira()||colisaoComParteVerticalarmario()||colisaoComParteVerticalbookshelf())){
            andaranima();
            setLocation(getX()-5, getY());
            direita=true;
        }
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-5, getY());
            andaranimaesquerda();
            direita=false;
        }
        else if (Greenfoot.isKeyDown("right") ){
            setLocation(getX()+5, getY());
            andaranima();
            direita=true;
        }else{
            setImage("Joel.png");
        }
        quedaprateleira();
        quedaarmario();
        quedabookshelf();
        onGround5();
        onGround6();
        onGround7();
    }
    /**
     * Função que percorre o array de imagens que anima o player
     */
    public void animaatirar()
    {
        indice++;
            if (indice >=atirar.length)
            {
                indice =0;
            }
        setImage(atirar[indice]);
        
    }
    public void animaatiraresquerda()
    {
        indice++;
            if (indice >=atiraresquerda.length)
            {
                indice =0;
            }
        setImage(atiraresquerda[indice]);
        
    }
    public void andaranima(){
        indice++;
            if (indice >=andarImagens.length)
            {
                indice =0;
            }
        setImage(andarImagens[indice]);
    }
    public void andaranimaesquerda(){
        indice++;
              if (indice >=andarImagensesquerda.length)
            {
                indice =0;
            }
        setImage(andarImagensesquerda[indice]);
    }
    /**
     * Função que faz com que o player dispare, desde a animação, ao disparo e ao efeito de fumo
     */
    public void atirar() {
        delay++;
        if (Greenfoot.isKeyDown("L")) {
            int posicaoX = getX();  
            int posicaoY;  
            if (direita == true && delay>25) {
                animaatirar();
                Greenfoot.playSound("bala.mp3");
                posicaoY = getY() - 10; 
                Disparo municao = new Disparo(); 
                Fumo fumo = new Fumo();
                getWorld().addObject(municao, posicaoX + 30, posicaoY); 
                getWorld().addObject(fumo, posicaoX + 30, posicaoY); 
                delay=0;
            } else if(direita ==false && delay>25){
                animaatiraresquerda();
                Greenfoot.playSound("bala.mp3");
                posicaoY = getY() - 10;  
                Disparo municao = new Disparo(); 
                Fumo fumo = new Fumo();
                getWorld().addObject(municao, posicaoX - 30, posicaoY);
                getWorld().addObject(fumo, posicaoX - 30, posicaoY);
                municao.setRotation(180);
                delay=0;
            }
        }
        
    }
    /**
     * Função que verifica se o player esta na platadorma 
     */
    public boolean verificaplat1() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma1.class);
        return emCima != null;
    }
    public boolean verificaplat2() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma2.class);
        return emCima != null;
    }
    public boolean verificaplat3() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma3.class);
        return emCima != null;
    }
    public boolean verificapredio() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Predio.class);
        return emCima != null;
    }
    public boolean verificabookshelf() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Bookshelf.class);
        return emCima != null;
    }
    public boolean verificaarmario() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Armario.class);
        return emCima != null;
    }
    public boolean verificaprateleira() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Prateleira.class);
        return emCima != null;
    }
    /**
     * Função que verifica a queda do player e que o puxa para cima quando este cai dentro da imagem
     */
    protected void quedaplat1(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Plataforma1.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }  
    protected void quedaplat2(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Plataforma2.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }
    protected void quedaprateleira(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Prateleira.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }
    protected void quedabookshelf(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Bookshelf.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }
    protected void quedaarmario(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Armario.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }    
    protected void quedaplat3(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Plataforma3.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }    
    protected void quedapredio(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, Predio.class); 
        if (plat==null && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }else if (plat != null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            
        }
        plat=null;
    }    
    /**
     * Função que verifica se o player colide com a parede vertical direita
     */
    public boolean colisaoComParteVertical() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Plataforma1.class);
       return actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalplat2() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Plataforma2.class);
        return  actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalplat3() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Plataforma3.class);
        return  actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalpredio() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Predio.class);
        return  actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalprateleira() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Prateleira.class);
        return  actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalbookshelf() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Bookshelf.class);
        return  actorNaDireita != null;
    }
    public boolean colisaoComParteVerticalarmario() {
        Actor actorNaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Armario.class);
        return  actorNaDireita != null;
    }
    
    /**
     * Função que verifica se o player colide com a parede vertical esquerda
     */
    public boolean colisaoComParteVerticalesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Plataforma1.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalplat2esquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Plataforma2.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalplat3esquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Plataforma3.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalprateleiraesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Prateleira.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalpredioesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Predio.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalbookshelfesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Bookshelf.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalarmarioesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Armario.class);
        return actorNaEsquerda != null ;
    }
    
    
    /**
     * Função que verifica se o personagem bate com a cabeça no teto, ou seja, em baixo de alguma plataforma
     */
    public boolean verificarColisaoCima() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Plataforma1.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimaplat2() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Plataforma2.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimaplat3() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Plataforma3.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimapredio() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Predio.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimaarmario() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Armario.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimaprateleira() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Prateleira.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    public boolean verificarColisaoCimabookshelf() {
        Actor colisaoCima = getOneObjectAtOffset(0, -getImage().getHeight() / 2, Bookshelf.class);
        if (colisaoCima != null) {
            setLocation(getX(), colisaoCima.getY() + colisaoCima.getImage().getHeight() / 2 + getImage().getHeight() / 2);
            return true; 
        }
        return false; 
    }
    /**
     * Função que verifica se o personagem está dentro do chão
     */
    public boolean onGround()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma1.class);
        if (platformUnder == null ) {
            return false;  
            
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder);  
                podeSaltar = true;
            } 
            return true;
        }
        
    }
    public boolean onGround2()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma2.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    public boolean onGround3()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Plataforma3.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    public boolean onGround4()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Predio.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    public boolean onGround5()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Prateleira.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    public boolean onGround6()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Bookshelf.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    public boolean onGround7()
    {
        Actor platformUnder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Armario.class);
        if (platformUnder == null ) {
            return false;  
        } else {
            if (platformUnder != null) {
                moveToGround(platformUnder); 
                podeSaltar = true;
            } 
            return true;
        }
    }
    /**
     * Função que puxa o personagem para cima, se o mesmo tiver dentro do chão
     */
    public void moveToGround(Actor under)
    {
        int underHeight = under.getImage().getHeight();
        int newY = under.getY() - (underHeight + getImage().getHeight()) / 2+1;
        setLocation(getX(), newY);
        podeSaltar = true;
    }
    /**
     * Função que faz com que o personagem salte
     */
    public void jump(){
        if (tempoJump>0){
            setLocation(getX(),getY()-tempoJump);
            tempoJump--;
        }else{
            tempoJump=20;
            saltou=false;
        }
    }
    /**
     * Método que tira o player de dentro da parte debaixo do mundo
     */
    public void reposicionarSeNaBordaInferior() {
        int limiteInferior = getWorld().getHeight();
        if (getY() >= limiteInferior - 1) {
            int alturaPlayer = getImage().getHeight();
            int novaPosicaoY = getY() - 63 - (alturaPlayer / 2);
            setLocation(getX(), novaPosicaoY);
        }
    }
}