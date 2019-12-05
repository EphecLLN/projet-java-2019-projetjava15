package RPG;


public class Personnage{

    //attributs
    private String username;
    private int niveau;
    private int exp;
    private int expLvlUp; //exp à atteindre pour le prochain niveau
    private int croissanceExp; //quantité d'exp qui s'ajoute à expLvlUp par niveau
    private String etat;
    private int hp;
    private int hpMax;
    private int croissanceHp;//quantité de hpMax gagnée par niveau
    private int nbPieces;
    private int attaque;
    private int croissanceAttaque;//quantité d'attaque gagnée par niveau
    private int defense;
    private int croissanceDefense;//quantité de defense gagnée par niveau
    private int mana;
    private int maxMana;
    private int croissanceMana;//quantité de mana gagnée par niveau
    private int posX;
    private int posY;
    private Armure armure;
    private Arme arme;


    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public void setDefense(int defense) { this.defense = defense; }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    public void setExpLvlUp(int expLvlUp) {
        this.expLvlUp = expLvlUp;
    }
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }
    public void setCroissanceExp(int croissanceExp) {
        this.croissanceExp = croissanceExp;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setArmure(Armure armure) {
        this.armure = armure;
    }
    public void setArme(Arme arme) { 
    	this.arme = arme;
    }
    public void setCroissanceAttaque(int croissanceAttaque) {
        this.croissanceAttaque = croissanceAttaque;
    }
    public void setCroissanceDefense(int croissanceDefense) {
        this.croissanceDefense = croissanceDefense;
    }
    public void setCroissanceHp(int croissanceHp) {
        this.croissanceHp = croissanceHp;
    }
    public void setCroissanceMana(int croissanceMana) {
        this.croissanceMana = croissanceMana;
    }


    //getters
    public String getUsername() {
        return username;
    }
    public int getAttaque() {
        return attaque;
    }
    public int getDefense() {
        return defense;
    }
    public int getExp() {
        return exp;
    }
    public int getHp() {
        return hp;
    }
    public int getNiveau() {
        return niveau;
    }
    public int getMana() {
        return mana;
    }
    public int getNbPieces() {
        return nbPieces;
    }
    public String getEtat() {
        return etat;
    }
    public int getExpLvlUp() {
        return expLvlUp;
    }
    public int getHpMax() { return hpMax; }
    public int getCroissanceExp() {
        return croissanceExp;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public Arme getArme() {
        return arme;
    }
    public Armure getArmure() { return armure; }
    public int getCroissanceAttaque() {
        return croissanceAttaque;
    }
    public int getCroissanceDefense() { return croissanceDefense; }
    public int getCroissanceHp() {
        return croissanceHp;
    }
    public int getCroissanceMana() {
        return croissanceMana;
    }


    //constructeur
    public Personnage(String username, int niveau, int exp, String etat, int hp, int nbPieces, int attaque, int defense, int mana, int expLvlUp, int hpMax, int maxMana, int posX, int posY, Arme arme, Armure armure, int croissanceHp, int croissanceMana,int croissanceAttaque, int croissanceDefense){
        this.setUsername(username);
        this.setNiveau(niveau);
        this.setExp(exp);
        this.setExpLvlUp(expLvlUp);
        this.setCroissanceExp(50);
        this.setEtat(etat);
        this.setHp(hp);
        this.setHpMax(hpMax);
        this.setNbPieces(nbPieces);
        this.setAttaque(attaque);
        this.setMana(mana);
        this.setDefense(defense);
        this.setMaxMana(maxMana);
        this.setArme(arme);
        this.setArmure(armure);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setCroissanceHp(croissanceHp);
        this.setCroissanceMana(croissanceMana);
        this.setCroissanceAttaque(croissanceAttaque);
        this.setCroissanceDefense(croissanceDefense);
    }


    //methodes
    /**
     * augmente l'expérience du personnage d'une quantité passée en paramètre
     * et si le total d'expérience dépasse la quantité pour passer un niveau, fait passer ce niveau
     * @param i quantité d'expérience ajoutée au total du personnage
     */
    public void expUp(int i){
        int newExp = this.getExp() + i;
        while (newExp > this.getExpLvlUp()) {
            newExp -= this.getExpLvlUp();
            this.lvlUp();
        }
        this.setExp(newExp);
    }

    /**
     * incrémente le niveau du personnage et ses stats qui ont une croissance par niveau et remet ses hp et son mana au max
     */
    public void lvlUp(){
        this.setNiveau(this.getNiveau() + 1);
        this.setExpLvlUp( this.getExpLvlUp() + this.getCroissanceExp());
        this.setDefense(this.getDefense() + this.getCroissanceDefense());
        this.setAttaque(this.getAttaque() + this.getCroissanceAttaque());
        this.setMaxMana(this.getMaxMana() + this.getCroissanceMana());
        this.setMana(this.getMaxMana());
        this.setHpMax(this.getHpMax() + this.getCroissanceHp());
        this.setHp(this.getHpMax());
    }


    /**
     * augmente les hp du personnage de la quantité pasée en paramètre sans dépasser les hpMax
     * @param i quantité de hp ajoutée au total du personnage
     */
    public void soin(int i){
        this.setMana(this.getMana() - 10);
        int newHp = this.getHp() +i;
        if (newHp > hpMax){
            this.setHp(hpMax);
        }
        else{
            this.setHp(newHp);
        }
    }

    /**
     * retire des hp égaux à la quantité passée en paramètre à la cible passée en paramètre
     * @param cible ennemi subissant les dégats
     *
     */
    public void attaque(Mob cible){
        cible.setHp(cible.getHp() - (this.getAttaque()+this.getArme().getAttaque()));
    }
    
    /**
     * M�thode permettant l'achat d'armes.
     * 
     * @param sh R�f�rence � la boutique
     * @param i indice de l'arme choisi
     */
    public void acheterArme(Shop sh, int i){
    	if(getNbPieces() >= sh.getArmesDispo().get(i).getPrix()) {
    		setArme(sh.getArmesDispo().get(i));
    		setNbPieces(getNbPieces() - sh.getArmesDispo().get(i).getPrix());
    		System.out.println("Vous avez obtenu une nouvelle arme!");
    	}
    	else {
    		System.out.println("nombre de pi�ce insuffisants");
    	}
    }
    
    /**
     * M�thode permettant l'achat d'armures
     * 
     * @param sh R�f�rence � la boutique
     * @param i indice de l'armure choisi
     */
    public void acheterArmure(Shop sh, int i){
    	if(getNbPieces() >= sh.getArmuresDispo().get(i).getPrix()) {
    		setArmure(sh.getArmuresDispo().get(i));
    		setNbPieces(getNbPieces() - sh.getArmuresDispo().get(i).getPrix());
    		System.out.println("Vous avez obtenu une nouvelle armure!");
    	}
    	else {
    		System.out.println("nombre de pi�ce insuffisants");
    	}
    }
    
    
    /**
     * déplace le personnage sur un axe et d'un nombre de cases passés en paramètre
     * @param axe axe du déplacement
     * @param speed nombre de cases du déplacement
     */
    public void move(char axe, int speed){
        switch (axe){
            case 'x':
                this.setPosX(this.getPosX()+speed);
                break;
            case 'y':
                this.setPosY(this.getPosY()+speed);
                break;
        }
    }
}
