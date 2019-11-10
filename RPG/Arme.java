package RPG;

public class Arme {

    private String type; // épée, baton ou dague
    private int niveau; // tier de l'équipement(base, amélioré ou meilleur)

    //setters
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    //getters
    public int getNiveau() {
        return niveau;
    }
    public String getType() {
        return type;
    }
}
