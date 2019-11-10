package RPG;

public class Aventurier extends Personnage {



    public Aventurier(String username){
        super(username,0,0,"clear", 100,0,10,10,50,50, 100,50, 50);
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
