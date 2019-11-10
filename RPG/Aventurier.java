package RPG;

public class Aventurier extends Personnage {



    public Aventurier(String username){
        super(username,0,0,"clear", 100,0,10,10,50,50, 100, 50,0,0,new Arme("épée", 0 ),new Armure("armure", 0),20,5,5,5);
    }

    public void boostAttaque(int i){
        this.setAttaque(this.getAttaque() + i);
    }
    public void boostDefense(int i){
        this.setDefense(this.getDefense() + i);
    }
    public void clearStatus(Personnage cible){
        if(cible.getEtat() != "clear"){
            cible.setEtat("clear");
        }
    }
}
