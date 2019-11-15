package model;

public class Arme {

    private String type; // épée, baton ou dague
    private int niveau; // tier de l'équipement(0=base, 1=amélioré ou 2=meilleur)
    private int puissanceMagique;
    private int attaque;


    //setters
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    public void setPuissanceMagique(int puissanceMagique) {
        this.puissanceMagique = puissanceMagique;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    //getters
    public int getNiveau() {
        return niveau;
    }
    public String getType() {
        return type;
    }
    public int getAttaque() {
        return attaque;
    }
    public int getPuissanceMagique() {
        return puissanceMagique;
    }

    //constructeur
    public Arme(String type, int niveau){
        this.setNiveau(niveau);
        this.setType(type);
        switch (type){
            case "�p�e":
                this.setAttaque((int) (5* Math.pow(2, niveau)));
                this.setPuissanceMagique(0);
                break;
            case "baton":
                this.setAttaque(0);
                this.setPuissanceMagique((int) (5* Math.pow(2, niveau)));
                break;
            case "dague":
                this.setAttaque((int) (10* Math.pow(2, niveau)));
                this.setPuissanceMagique(0);
                break;
        }
    }
    
    public String toString() {
    	return "type: "+ type + ", lvl:  "+ niveau;
    }

}
