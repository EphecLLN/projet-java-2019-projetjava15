package RPG;

public class Armure {
    private String type;//cape, armure ou robe
    private int niveau;// tier de l'armure(base, améliorée ou meilleure)

    //setters
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    //getters
    public String getType() {
        return type;
    }
    public int getNiveau() {
        return niveau;
    }
}
