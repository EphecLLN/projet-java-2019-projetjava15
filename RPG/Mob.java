package RPG;

public class Mob {
    private int hp;
    private int attaque;
    private String faiblesse;

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

    public Mob(int hp, int attaque, String faiblesse){
        this.setAttaque(attaque);
        this.setHp(hp);
        this.setFaiblesse(faiblesse);
    }

    public void attaque(Personnage cible, int attaque){
        cible.setHp(cible.getHp() - (attaque - cible.getDefense()) );

    }
}
