package RPG;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * L'arme se présentant sous plusieurs formes: epée, baton ou dague et ayant un niveau correspondant son niveau de puissance.
 *
 */
public class Arme {

    //attributs
    private String type; // epée, baton ou dague
    private int niveau; // tier de l'arme(0=base, 1= amélioré ou 2= meilleur)
    private int puissanceMagique;
    private int attaque;
    private int prix = 50;


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
    
    public int getPrix() {
    	return prix;
    }

    //constructeur
    public Arme(String type, int niveau){
        this.setNiveau(niveau);
        this.setType(type);
        switch (type){
            case "épée":
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
	@Override
	public String toString() {
		return "type:" + type + ", niveau:" + niveau + ", puissanceMagique:" + puissanceMagique + " attaque:"
				+ attaque + ", prix: "+ prix + "\n";
	}
    
    

}
