import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lenhador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lenhador extends Actor
{
    /**
     * Act - do whatever the Lenhador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] andarImagens;
    private GreenfootImage[] melee;
    private GreenfootImage[] crit;
    private GreenfootImage[] morte;
    private GreenfootImage[] andarImagensesquerda;
    private GreenfootImage[] meleeesquerda;
    private GreenfootImage[] critesquerda;
    private GreenfootImage[] morteesquerda;
    private int indice;
    private int vida;
    private boolean direita = true;
    public Lenhador (){
        prepararImagens();
        vida = 10;
    }
    public void act()
    {
        if (vida <= 0){
            morre();
            return;
        }
        if (verificaLenhador()) {
            moveLenhador();
        }
        if(verificaLenhadorb())
        {
            moveLenhadorb();
        }
            Actor player1 = getPlayerProximo(Player1.class);
            Actor player2 = getPlayerProximo(Player2.class);

        if (player1 != null || player2 != null) {
            atacar();
        }
    }
    /**
     * Função que carrega as imagens do lenhador
     */
    public void prepararImagens() {
        
        andarImagens = new GreenfootImage[8];
        melee = new GreenfootImage[10];
        crit = new GreenfootImage[14];
        morte = new GreenfootImage[15];
        
        andarImagensesquerda = new GreenfootImage[8];
        meleeesquerda = new GreenfootImage[10];
        critesquerda = new GreenfootImage[14];
        morteesquerda = new GreenfootImage[15];

        andarImagens[0] = new GreenfootImage("andar.png");
        andarImagens[1] = new GreenfootImage("andar2.png");
        andarImagens[2] = new GreenfootImage("andar3.png");
        andarImagens[3] = new GreenfootImage("andar4.png");
        andarImagens[4] = new GreenfootImage("andar5.png");
        andarImagens[5] = new GreenfootImage("andar6.png");
        andarImagens[6] = new GreenfootImage("andar7.png");
        andarImagens[7] = new GreenfootImage("andar8.png");
        
        melee[0] = new GreenfootImage("crit1.png");
        melee[1] = new GreenfootImage("crit2.png");
        melee[2] = new GreenfootImage("crit3.png");
        melee[3] = new GreenfootImage("crit4.png");
        melee[4] = new GreenfootImage("crit5.png");
        melee[5] = new GreenfootImage("crit6.png");
        melee[6] = new GreenfootImage("crit7.png");
        melee[7] = new GreenfootImage("crit8.png");
        melee[8] = new GreenfootImage("crit9.png");
        melee[9] = new GreenfootImage("crit10.png");
        
        crit[0] = new GreenfootImage("melee.png");
        crit[1] = new GreenfootImage("melee2.png");
        crit[2] = new GreenfootImage("melee3.png");
        crit[3] = new GreenfootImage("melee4.png");
        crit[4] = new GreenfootImage("melee5.png");
        crit[5] = new GreenfootImage("melee6.png");
        crit[6] = new GreenfootImage("melee7.png");
        crit[7] = new GreenfootImage("melee8.png");
        crit[8] = new GreenfootImage("melee9.png");
        crit[9] = new GreenfootImage("melee10.png");
        crit[10] = new GreenfootImage("melee11.png");
        crit[11] = new GreenfootImage("melee12.png");
        crit[12] = new GreenfootImage("melee13.png");
        crit[13] = new GreenfootImage("melee14.png");
        
        morte[0]= new GreenfootImage("morte1.png");
        morte[1]= new GreenfootImage("morte2.png");
        morte[2]= new GreenfootImage("morte3.png");
        morte[3]= new GreenfootImage("morte4.png");
        morte[4]= new GreenfootImage("morte5.png");
        morte[5]= new GreenfootImage("morte6.png");
        morte[6]= new GreenfootImage("morte7.png");
        morte[7]= new GreenfootImage("morte8.png");
        morte[8]= new GreenfootImage("morte9.png");
        morte[9]= new GreenfootImage("morte10.png");
        morte[10]= new GreenfootImage("morte11.png");
        morte[11]= new GreenfootImage("morte12.png");
        morte[12]= new GreenfootImage("morte13.png");
        morte[13]= new GreenfootImage("morte14.png");
        morte[14]= new GreenfootImage("morte15.png"); 
        
        andarImagensesquerda[0] = new GreenfootImage("andaresquerda1.png");
        andarImagensesquerda[1] = new GreenfootImage("andaresquerda2.png");
        andarImagensesquerda[2] = new GreenfootImage("andaresquerda3.png");
        andarImagensesquerda[3] = new GreenfootImage("andaresquerda4.png");
        andarImagensesquerda[4] = new GreenfootImage("andaresquerda5.png");
        andarImagensesquerda[5] = new GreenfootImage("andaresquerda6.png");
        andarImagensesquerda[6] = new GreenfootImage("andaresquerda7.png");
        andarImagensesquerda[7] = new GreenfootImage("andaresquerda8.png");
        
        meleeesquerda[0] = new GreenfootImage("meleeesquerda1.png");
        meleeesquerda[1] = new GreenfootImage("meleeesquerda2.png");
        meleeesquerda[2] = new GreenfootImage("meleeesquerda3.png");
        meleeesquerda[3] = new GreenfootImage("meleeesquerda4.png");
        meleeesquerda[4] = new GreenfootImage("meleeesquerda5.png");
        meleeesquerda[5] = new GreenfootImage("meleeesquerda6.png");
        meleeesquerda[6] = new GreenfootImage("meleeesquerda7.png");
        meleeesquerda[7] = new GreenfootImage("meleeesquerda8.png");
        meleeesquerda[8] = new GreenfootImage("meleeesquerda9.png");
        meleeesquerda[9] = new GreenfootImage("meleeesquerda10.png");
        
        critesquerda[0] = new GreenfootImage("critesquerda1.png");
        critesquerda[1] = new GreenfootImage("critesquerda2.png");
        critesquerda[2] = new GreenfootImage("critesquerda3.png");
        critesquerda[3] = new GreenfootImage("critesquerda4.png");
        critesquerda[4] = new GreenfootImage("critesquerda5.png");
        critesquerda[5] = new GreenfootImage("critesquerda6.png");
        critesquerda[6] = new GreenfootImage("critesquerda7.png");
        critesquerda[7] = new GreenfootImage("critesquerda8.png");
        critesquerda[8] = new GreenfootImage("critesquerda9.png");
        critesquerda[9] = new GreenfootImage("critesquerda10.png");
        critesquerda[10] = new GreenfootImage("critesquerda11.png");
        critesquerda[11] = new GreenfootImage("critesquerda12.png");
        critesquerda[12] = new GreenfootImage("critesquerda13.png");
        critesquerda[13] = new GreenfootImage("critesquerda14.png");
        
        morteesquerda[0]= new GreenfootImage("morteesquerda1.png");
        morteesquerda[1]= new GreenfootImage("morteesquerda2.png");
        morteesquerda[2]= new GreenfootImage("morteesquerda3.png");
        morteesquerda[3]= new GreenfootImage("morteesquerda4.png");
        morteesquerda[4]= new GreenfootImage("morteesquerda5.png");
        morteesquerda[5]= new GreenfootImage("morteesquerda6.png");
        morteesquerda[6]= new GreenfootImage("morteesquerda7.png");
        morteesquerda[7]= new GreenfootImage("morteesquerda8.png");
        morteesquerda[8]= new GreenfootImage("morteesquerda9.png");
        morteesquerda[9]= new GreenfootImage("morteesquerda10.png");
        morteesquerda[10]= new GreenfootImage("morteesquerda11.png");
        morteesquerda[11]= new GreenfootImage("morteesquerda12.png");
        morteesquerda[12]= new GreenfootImage("morteesquerda13.png");
        morteesquerda[13]= new GreenfootImage("morteesquerda14.png");
        morteesquerda[14]= new GreenfootImage("morteesquerda15.png"); 
    }
    /**
     * Função que percorre o array de imagens e anima o lenhador
     */
    public void animaandar()
    {
        indice++;
            if (indice >=andarImagens.length)
            {
                indice =0;
            }
        setImage(andarImagens[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima o ataque critico
     */
    public void animacrit()
    {
        indice++;
            if (indice >=crit.length)
            {
                indice =0;
            }
        setImage(crit[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima o ataque melee
     */
    public void animamelee()
    {
        indice++;
            if (indice >=melee.length)
            {
                indice =0;
            }
        setImage(melee[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima a morte
     */
    public void animamorte()
    {
        indice++;
            if (indice >=morte.length)
            {
                indice =0;
            }
        setImage(morte[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima o andar para o lado esquerdo
     */
    public void animaandaresquerda()
    {
        indice++;
            if (indice >=andarImagensesquerda.length)
            {
                indice =0;
            }
        setImage(andarImagensesquerda[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima a morte para o lado esquerdo
     */
    public void animamorteesquerda()
    {
        indice++;
            if (indice >=morteesquerda.length)
            {
                indice =0;
            }
        setImage(morteesquerda[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima o ataque critico para a esquerda
     */
    public void animacritesquerda()
    {
        indice++;
            if (indice >=critesquerda.length)
            {
                indice =0;
            }
        setImage(critesquerda[indice]);
        
    }
    /**
     * Função que percorre o array de imagens e anima o ataque melee para a esquerda
     */
    public void animameleeesquerda()
    {
        indice++;
            if (indice >=meleeesquerda.length)
            {
                indice =0;
            }
        setImage(meleeesquerda[indice]);
        
    }
    /**
     * Função que verifica se o lenhador esta em cima do armario
     */
    public boolean verificaLenhador() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Armario.class);
        return emCima != null;
    }
    /**
     * Função que verifica se o lenhador chegou à borda direita do armario
     */
    public boolean atBordaDireita() {
        Actor bordaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Armario.class);
        return bordaDireita == null;
    }
    /**
     * Função que verifica se o lenhador chegou à borda esquerda do armario
     */
    public boolean atBordaEsquerda() {
        Actor bordaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Armario.class);
        return bordaEsquerda == null;
    }
    public boolean verificaLenhadorb() {
        Actor emCima = getOneObjectAtOffset(0, getImage().getHeight() / 2, Bookshelf.class);
        return emCima != null;
    }
    public boolean atBordaDireitab() {
        Actor bordaDireita = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Bookshelf.class);
        return bordaDireita == null;
    }

    public boolean atBordaEsquerdab() {
        Actor bordaEsquerda = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Bookshelf.class);
        return bordaEsquerda == null;
    }
    /**
     * Função que move o lenhador em cima do armario
     */
    public void moveLenhador() {
        if (atBordaDireita() && direita) {
            direita = false; 
        } else if (atBordaEsquerda() && !direita) {
            direita = true;  
        }

        if (direita) {
            setLocation(getX() + 10, getY());  
            animaandar(); 
        } else {
            setLocation(getX() - 10, getY());  
            animaandaresquerda(); 
        }
    }
    /**
     * Função que move o lenhador em cima da bookshelf
     */
    public void moveLenhadorb() {
        if (atBordaDireitab() && direita) {
            direita = false; 
        } else if (atBordaEsquerdab() && !direita) {
            direita = true;  
        }

        if (direita) {
            setLocation(getX() + 10, getY());  
            animaandar(); 
        } else {
            setLocation(getX() - 10, getY());  
            animaandaresquerda(); 
        }
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
     * Função que retira o lenhador do mundo
     */
    public void morre(){
        if (vida <= 0){
            if (direita) {
                
                getWorld().removeObject(this);
            }else{
                
                getWorld().removeObject(this);
            }
                
        }
    }
    /**
     * Método que vefica se tem um jogador próximo
     */
    public Actor getPlayerProximo(Class jogadorClass) {
        return getOneObjectAtOffset(100, 0, jogadorClass); 
    }
    /**
     * Método que faz com que o lenhador tenha a aniamção de ataque
     */
    public void atacar() {
        int escolhaAtaque = Greenfoot.getRandomNumber(2);
        if (direita) {
            if (escolhaAtaque == 0) {
                animamelee(); 
            } else {
                animacrit();  
            }
        } else {
            if (escolhaAtaque == 0) {
                animameleeesquerda(); 
            } else {
                animacritesquerda();  
            }
        }
    }
    
}
