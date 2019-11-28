package RPG;

public class Mob {

    //attributs
    private int hp;
    private int attaque;
    private String faiblesse;
    private int posX;
    private int posY;

    //setters
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public void setFaiblesse(String faiblesse) {
        this.faiblesse = faiblesse;
    }
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }

    //getters
    public int getHp() {
        return hp;
    }
    public int getAttaque() {
        return attaque;
    }
    public String getFaiblesse() {
        return faiblesse;
    }
    public int getPosX() {return posX; }
    public int getPosY() { return posY; }

    //constructeurs
    public Mob(int hp, int attaque, String faiblesse, int posX, int posY) {
        this.setAttaque(attaque);
        this.setHp(hp);
        this.setFaiblesse(faiblesse);
        this.setPosX(posX);
        this.setPosY(posY);
    }


    //méthodes
    public void attaque(Personnage cible) {
        int degats = (this.getAttaque() - (cible.getDefense() + cible.getArmure().getDefense()));
        if (degats <= 0) {
            degats = 1;
        }
        cible.setHp(cible.getHp() - degats);
    }

    public void stun(Personnage cible) {
        cible.setEtat("stun");
    }
}
