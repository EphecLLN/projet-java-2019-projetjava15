package RPG;

import java.util.Observable;

/**
 * @authors Lebas Ya�l & Mugisha Rodrigue
 * 
 * Classe repr�santant un personnage pouvant effectuer plusieurs actions tels que attaquer, se soigner, acheter de l'�quipement via des pi�ces.
 * Il �volue par l'exp�rience qu'il gagne � chaque fin de chaque combat, le niveau maximum �tant le niveau 100.
 *
 */
public class Personnage extends Observable{

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
        setChanged();
        notifyObservers();
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
        setChanged();
        notifyObservers();
    }
    public void setDefense(int defense) { 
    	this.defense = defense; 
    	setChanged();
    	notifyObservers();
    }
    public void setEtat(String etat) {
        this.etat = etat;
        setChanged();
        notifyObservers();
    }
    public void setExp(int exp) {
        this.exp = exp;
        setChanged();
        notifyObservers();
    }
    public void setHp(int hp) {
        this.hp = hp;
        setChanged();
        notifyObservers();
    }
    public void setMana(int mana) {
        this.mana = mana;
        setChanged();
        notifyObservers();
    }
    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
        setChanged();
        notifyObservers();
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
        setChanged();
        notifyObservers();
    }
    public void setExpLvlUp(int expLvlUp) {
        this.expLvlUp = expLvlUp;
        setChanged();
        notifyObservers();
    }
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
        setChanged();
        notifyObservers();
    }
    public void setCroissanceExp(int croissanceExp) {
        this.croissanceExp = croissanceExp;
        setChanged();
        notifyObservers();
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
        setChanged();
        notifyObservers();
    }
    public void setPosX(int posX) {
        this.posX = posX;
        setChanged();
        notifyObservers();
    }
    public void setPosY(int posY) {
        this.posY = posY;
        setChanged();
        notifyObservers();
    }
    public void setArmure(Armure armure) {
        this.armure = armure;
        setChanged();
        notifyObservers();
    }
    public void setArme(Arme arme) { 
    	this.arme = arme;
    	setChanged();
        notifyObservers();
    }
    public void setCroissanceAttaque(int croissanceAttaque) {
        this.croissanceAttaque = croissanceAttaque;
        setChanged();
        notifyObservers();
    }
    public void setCroissanceDefense(int croissanceDefense) {
        this.croissanceDefense = croissanceDefense;
        setChanged();
        notifyObservers();
    }
    public void setCroissanceHp(int croissanceHp) {
        this.croissanceHp = croissanceHp;
        setChanged();
        notifyObservers();
    }
    public void setCroissanceMana(int croissanceMana) {
        this.croissanceMana = croissanceMana;
        setChanged();
        notifyObservers();
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


    /*
     * Constructeur initialisant le personnage avec tout ses attributs
     */
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
     * augmente l'exp�rience du personnage d'une quantit� pass�e en param�tre
     * et si le total d'exp�rience d�passe la quantit� pour passer un niveau, fait passer ce niveau
     * @param i quantit� d'exp�rience ajout�e au total du personnage
     */
    public void expUp(int i){
        int newExp = this.getExp() + i;
        while (newExp >= this.getExpLvlUp()) {
            newExp -= this.getExpLvlUp();
            this.lvlUp();
        }
        this.setExp(newExp);
    }

    /**
     * incr�mente le niveau du personnage et ses stats qui ont une croissance par niveau et remet ses hp et son mana au max
     */
    public void lvlUp(){
    	if(getNiveau() >= 100) {
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
     * augmente les hp du personnage de la quantit� pas�e en param�tre sans d�passer les hpMax
     * @param i quantit� de hp ajout�e au total du personnage
     */
    public void soin(int i){
    	this.setMana(this.getMana() - 10);
        int newHp = this.getHp() + i;
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
     * Retire des hp �gaux à la quantit� pass�e en param�tre à la cible pass�e en param�tre
     * @param cible ennemi subissant les d�gats
     *
     */
    public void attaque(Mob cible){
    	if(cible.getHp() <= 0 || this.getAttaque()+this.getArme().getAttaque() > cible.getHp()) {
    		cible.setHp(0);
    	}
    	else {
        cible.setHp(cible.getHp() - (this.getAttaque()+this.getArme().getAttaque()));
    	}
    }
    
    /**
     * M�thode permettant l'achat d'armes.
     * 
     * @param sh R�f�rence � la boutique
     * @param i indice de l'arme choisi
     */
    public void acheterArme(Shop sh, int i){
    	try {
    		if(getNbPieces() >= sh.getArmesDispo().get(i).getPrix() || i > sh.getArmesDispo().size() || i > sh.getArmesDispo().size() || i < 0) {
    			setArme(sh.getArmesDispo().get(i));
    			setNbPieces(getNbPieces() - sh.getArmesDispo().get(i).getPrix());
    			System.out.println("Vous avez obtenu une nouvelle arme!");
    		}
    		else {
    			System.out.println("nombre de pi�ce insuffisants pour une nouvelle arme");
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Erreur, indice hors intervalle");
    		}
    }
    
    /**
     * M�thode permettant l'achat d'armures
     * 
     * @param sh R�f�rence � la boutique
     * @param i indice de l'armure choisi
     */
    public void acheterArmure(Shop sh, int i){
    	try {
    		if(getNbPieces() >= sh.getArmuresDispo().get(i).getPrix()) {
    			setArmure(sh.getArmuresDispo().get(i));
    			setNbPieces(getNbPieces() - sh.getArmuresDispo().get(i).getPrix());
    			System.out.println("Vous avez obtenu une nouvelle armure!");
    		}
    		else {
    		System.out.println("nombre de pi�ce insuffisants pour une nouvelle armure");
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Erreur, indice hors intervalle");
    		}
    	}
    
    public String toString() {
    	return "Personnage: \n "+ username + "\n niveau: "
                + niveau + "\n exp: "
                + exp + "\n Etat: "
                + etat + "\n hp: "
                + hp + "\n nb de pieces: "
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
