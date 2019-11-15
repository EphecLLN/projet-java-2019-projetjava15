package model;

public class Personnage {

    private String username;
    private int niveau;
    private int exp;
    private int expLvlUp; //exp � atteindre pour le prochain niveau
    private int croissanceExp; //quantit� d'exp qui s'ajoute � expLvlUp par niveau
    private String etat;
    private int hp;
    private int hpMax;
    private int croissanceHp;//quantit� de hpMax gagn�e par niveau
    private int nbPieces;
    private int attaque;
    private int croissanceAttaque;//quantit� d'attaque gagn�e par niveau
    private int defense;
    private int croissanceDefense;//quantit� de defense gagn�e par niveau
    private int mana;
    private int maxMana;
    private int croissanceMana;//quantit� de mana gagn�e par niveau
    private int posX;
    private int posY;
    private Armure armure;
    private Arme arme;
    
  //constructeur
    public Personnage(String username, int niveau, int exp, String etat, int hp, int nbPieces, int attaque, int defense, int mana, int expLvlUp, int hpMax, int maxMana, int posX, int posY, Arme arme, Armure armure, int croissanceHp, int croissanceMana,int croissanceAttaque, int croissanceDefense){
        this.setUsername(username);
        this.setNiveau(niveau);
        this.setExp(exp);
        this.setExpLvlUp(expLvlUp);
        this.setCroissanceExp(50); // Croissance d'exp�rience d�fini par d�faut � 50.
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


    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
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
    public int getHpMax() {
        return hpMax;
    }
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
    public Armure getArmure() {
        return armure;
    }
    public int getCroissanceAttaque() {
        return croissanceAttaque;
    }
    public int getCroissanceDefense() {
        return croissanceDefense;
    }
    public int getCroissanceHp() {
        return croissanceHp;
    }
    public int getCroissanceMana() {
        return croissanceMana;
    }

    /**
     * Augmente l'exp�rience du personnage par une quantit� pass�e en param�tre.
     * Si le total d'exp�rience d�passe la quantit� pour passer un niveau sup�rieur(expLvlUp), le personnage passe au niveau suivant et l'exp�rience en trop y est ajout�e. 
     * 
     * @param expGagnee quantit� d'exp�rience ajout�e au total d'exp�rience acquise du personnage
     */
    public void expUp(int expGagnee){
        int newExp = this.getExp() + expGagnee;
        while (newExp >= this.getExpLvlUp()) {
            newExp -= this.getExpLvlUp();
            this.lvlUp();
        }
        this.setExp(newExp);
    }

    /**
     * Incr�mente le niveau du personnage et ses stats qui ont une croissance par niveau et remet ses hp et son mana au max.
     */
    public void lvlUp(){
    	
    	if(getNiveau() > 50) {
    		System.out.println("Vous avez atteint le niveau d'exp�rience maximale");
    	}
    	else {
    		this.setNiveau(this.getNiveau() + 1);
    		this.setExpLvlUp( this.getExpLvlUp() + this.getCroissanceExp());
    		this.setDefense(this.getDefense() + this.getCroissanceDefense());
    		this.setAttaque(this.getAttaque() + this.getCroissanceAttaque());
    		this.setMaxMana(this.getMaxMana() + this.getCroissanceMana());
    		this.setMana(this.getMaxMana());
    		this.setHpMax(this.getHpMax() + this.getCroissanceHp());
    		this.setHp(this.getHpMax());
    	}
    }


    /**
     * Restaure les hp du personnage par la quantit� pass�e en param�tre sans d�passer les hpMax.
     * 
     * @param hpRestored quantit� de hp ajout�es au total des hp restants du personnage.
     */
    public void soin(int hpRestored){
        this.setMana(this.getMana() - 10);
        int newHp = this.getHp() + hpRestored;
        if (newHp > hpMax){
            this.setHp(hpMax);
        }
        else if(getHp() <= 0) {
        	this.setHp(0);
        }
        else{
            this.setHp(newHp);
        }
    }

    /**
     * Retire des hp �la cible pass�e en param�tre.
     * Le retrait d'hp correspondant au coup port� par le personnage bas� sur sa statistique d'attaque et celle de son arme.
     *
     * @param cible Ennemi subissant les d�gats.
     *
     */
    public void attaque(Mob cible){
    	
    	int coup = (this.getAttaque()+this.getArme().getAttaque());
    	
    	if(cible.getHp() == 0 || coup > cible.getHp()) {
    		cible.setHp(0);
    	}
    	else {
    		cible.setHp(cible.getHp() - coup);
    	}
    }

    @Override
    public String toString() {
    	return "Personnage: \n "+ username + "\n niveau: "
                + niveau + "\n exp: "
                + exp + "\n Etat: "
                + etat + "\n hp: "
                + hp + "\n nombre de pieces: "
                + nbPieces + "\n attaque: "
                + attaque + "\n defense: "
                + defense + "\n mana: "
                + mana + "\n expLvlUp: "
                + expLvlUp + "\n hpMax: "
                + hpMax + "\n maxMana: "
                + maxMana + "\n Arme: "
                + arme.toString()+ "\n Armure: "
                + armure.toString();
    }
    
}
