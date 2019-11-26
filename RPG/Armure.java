package RPG;

public class Armure {
    private String type;//cape, armure ou robe
    private int niveau;// tier de l'armure(base, améliorée ou meilleure)
    private int defense;

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
    
    public String toString() {
    	return "type: "+ type + ", lvl:  "+ niveau;
    }

}
