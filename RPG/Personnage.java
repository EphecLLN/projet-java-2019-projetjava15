package RPG;

public class Personnage {

    private String username;
    private int niveau;
    private int exp;
    private int expLvlUp; //exp à atteindre pour le prochain niveau
    private int croissanceExp; //quantité d'exp qui s'ajoute à expLvlUp par niveau
    private String etat;
    private int hp;
    private int hpMax;
    private int nbPieces;
    private int attaque;
    private int defense;
    private int mana;
    private int maxMana;
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

    //constructeur
    public Personnage(String username, int niveau, int exp, String etat, int hp, int nbPieces, int attaque, int defense, int mana, int expLvlUp, int hpMax, int croissanceExp, int maxMana){
        this.setUsername(username);
        this.setNiveau(niveau);
        this.setExp(exp);
        this.setEtat(etat);
        this.setHp(hp);
        this.setNbPieces(nbPieces);
        this.setAttaque(attaque);
        this.setMana(mana);
        this.setDefense(defense);
        this.setExpLvlUp(expLvlUp);
        this.setHpMax(hpMax);
        this.setCroissanceExp(croissanceExp);
        this.setMaxMana(maxMana);
    }

    /**
     * augmente l'expérience du personnage d'une quantité passée en paramètre
     * et si le total d'expérience dépasse la quantité pour passer un niveau, fait passer ce niveau
     * @param i quantité d'expérience ajoutée au total du personnage
     */
    public void expUp(int i){
        int newExp = this.getExp() + i;
        while (newExp > expLvlUp) {
            newExp -= expLvlUp;
            this.lvlUp();
            this.setExpLvlUp( expLvlUp + this.getCroissanceExp() );
        }
        this.setExp(newExp);
    }

    /**
     * incrémente le niveau du personnage
     */
    public void lvlUp(){
        this.setNiveau(this.getNiveau() + 1);
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
     * @param attaque quantité de dégats infligés
     */
    public void attaque(Mob cible,int attaque){
        cible.setHp(cible.getHp() - attaque);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
