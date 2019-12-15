package RPG;

public class Armure {
    private String type;//cape, armure ou robe
    private int niveau;// tier de l'armure(base, améliorée ou meilleure)
    private int defense;
    private int prix = 40;

    //setters
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    //getters
    public String getType() {
        return type;
    }
    public int getNiveau() {
        return niveau;
    }
    public int getDefense() {
        return defense;
    }
    
    public int getPrix() {
    	return prix;
    }



    public Armure(String type, int niveau){
        this.setNiveau(niveau);
        this.setType(type);
        switch (type){
            case "armure":
                this.setDefense((int) (10* Math.pow(2, niveau)));
                break;
            case "robe":
                this.setDefense((int) (2* Math.pow(2, niveau)));
                break;
            case "cape":
                this.setDefense((int) (5* Math.pow(2, niveau)));
                break;
        }

    }
	@Override
	public String toString() {
		return "type:" + type + ", niveau:" + niveau + ", defense:" + defense + ", prix: "+ prix + "\n";
	}
}
