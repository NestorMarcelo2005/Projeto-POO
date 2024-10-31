import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Player
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
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
    private int delay=0;
    private int delayimg=0;
    private int delayatirar=0;  
    private String tecla="W";
    private int tempoJump=20;
    private int tempoQueda;
    private boolean saltou=false;
    private boolean podeSaltar=false;
    private static int numeroVidas=6;
    private Player2 P2;
    private static int score;
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
            perdeVidas(P2);
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
        andarImagens = new GreenfootImage[5];
        image3 = new GreenfootImage("Ellie3.png");
        image3esquerda = new GreenfootImage("Ellie3esquerda.png");
        andarImagens[0] = new GreenfootImage("Elliecorrer.png");
        andarImagens[1] = new GreenfootImage("Elliecorrer2.png");
        andarImagens[2] = new GreenfootImage("Elliecorrer3.png");
        andarImagens[3] = new GreenfootImage("Elliecorrer4.png");
        andarImagens[4] = new GreenfootImage("Elliecorrer5.png");
        
        andarImagensesquerda = new GreenfootImage[5];
        
        andarImagensesquerda[0] = new GreenfootImage("Elliecorreresquerda.png");
        andarImagensesquerda[1] = new GreenfootImage("Elliecorrer2esquerda.png");
        andarImagensesquerda[2] = new GreenfootImage("Elliecorrer3esquerda.png");
        andarImagensesquerda[3] = new GreenfootImage("Elliecorrer4esquerda.png");
        andarImagensesquerda[4] = new GreenfootImage("Elliecorrer5esquerda.png");
        
        atirar = new GreenfootImage[7];
        
        atirar[0]= new GreenfootImage("Ellie1.png");
        atirar[1] = new GreenfootImage("Ellie2.png");
        atirar[2] = new GreenfootImage("Ellie3.png");
        atirar[3] = new GreenfootImage("Ellie3.png");
        atirar[4] = new GreenfootImage("Ellie3.png");
        atirar[5] = new GreenfootImage("Ellie3.png");
        atirar[6] = new GreenfootImage("Ellie3.png");
        
        atiraresquerda = new GreenfootImage[8];
        
        atiraresquerda[0]= new GreenfootImage("Ellie1.png");
        atiraresquerda[1] = new GreenfootImage("Ellie2esquerda.png");
        atiraresquerda[2] = new GreenfootImage("Ellie3esquerda.png");
        atiraresquerda[3] = new GreenfootImage("Ellie3esquerda.png");
        atiraresquerda[4] = new GreenfootImage("Ellie3esquerda.png");
        atiraresquerda[5] = new GreenfootImage("Ellie3esquerda.png");
        atiraresquerda[6] = new GreenfootImage("Ellie3esquerda.png");
        atiraresquerda[7] = new GreenfootImage("Ellie3esquerda.png");

    }
    /**
     * Função que faz com que o player ande e salte no Nivel 1 e 3
     */
    public void andar()
    {   
        if(verificaplat1()||verificaplat2()||verificaplat3()||verificapredio()){
            podeSaltar=true;
            saltou = false;
        }
        if (Greenfoot.isKeyDown("W") && podeSaltar){
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
        
        if(Greenfoot.isKeyDown("A")&&(colisaoComParteVerticalesquerda()||colisaoComParteVerticalplat2esquerda()||colisaoComParteVerticalplat3esquerda()||colisaoComParteVerticalpredioesquerda())){
            andaranimaesquerda();
            setLocation(getX()+5, getY());
            direita=false;
        }
        if(Greenfoot.isKeyDown("D")&&(colisaoComParteVertical()||colisaoComParteVerticalplat2()||colisaoComParteVerticalplat3()||colisaoComParteVerticalpredio())){    
            andaranima();
            setLocation(getX()-5, getY());
            direita=true;
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-5, getY());
            andaranimaesquerda();
            direita=false;
        }
        else if (Greenfoot.isKeyDown("D") ){
            setLocation(getX()+5, getY());
            andaranima();
            direita=true;
        }else{
            setImage("Ellie1.png");
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
     * Função que faz com que o player ande e salte no Nivel 2
     */
    public void andar2()
    {   
        if(verificaprateleira()||verificaarmario()||verificabookshelf()){
            podeSaltar=true;
            saltou = false;
        }
        if (Greenfoot.isKeyDown("W") && podeSaltar){
            saltou=true;
            podeSaltar=false;
        }
        if(saltou){
            jump();
            verificarColisaoCimaprateleira();
            verificarColisaoCimabookshelf();
            verificarColisaoCimaarmario();
        }
        
        if(Greenfoot.isKeyDown("A")&&(colisaoComParteVerticalplat2esquerda()||colisaoComParteVerticalplat3esquerda()||colisaoComParteVerticalpredioesquerda())){
            andaranimaesquerda();
            setLocation(getX()+5, getY());
            direita=false;
        }
        if(Greenfoot.isKeyDown("D")&&(colisaoComParteVerticalprateleira()||colisaoComParteVerticalarmario()||colisaoComParteVerticalbookshelf())){
            andaranima();
            setLocation(getX()-5, getY());
            direita=true;
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-5, getY());
            andaranimaesquerda();
            direita=false;
        }
        else if (Greenfoot.isKeyDown("D") ){
            setLocation(getX()+5, getY());
            andaranima();
            direita=true;
        }else{
            setImage("Ellie1.png");
        }
        quedaprateleira();
        quedaarmario();
        quedabookshelf();
        onGround5();
        onGround6();
        onGround7();
    }
    /**
     * Função que percorre array de imagens e anima o personagem
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
     * Método que faz com que o player atire para ambos os lados, incluindo o disparo
     */
    public void atirar() {
        delay++;
        if (Greenfoot.isKeyDown("E")) {
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
     * Método que verifica se o player esta em cima de uma plataforma
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
     * Método que verifica a queda do player dentro de uma plataforma
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
    /**
     * Método que verifica a colisão do player com a parede direita do objeto
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
     * Método que verifica a colisão com a parede vertical esquerda
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
    public boolean colisaoComParteVerticalpredioesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Predio.class);
        return actorNaEsquerda != null ;
    }
    public boolean colisaoComParteVerticalprateleiraesquerda() {
        Actor actorNaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Prateleira.class);
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
     * Método que verifica quando o player bate com a cabeça numa plataforma
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
     * método que verifica se um player entrou dentro de uma plataforma
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
     * Método que retira o player de dentro de uma plataforma, quando o mesmo entra dentro
     */
    public void moveToGround(Actor under)
    {
        int underHeight = under.getImage().getHeight();
        int newY = under.getY() - (underHeight + getImage().getHeight()) / 2+1;
        setLocation(getX(), newY);
        podeSaltar = true;
    }
    /**
     * Método que faz com que o player salte 
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
