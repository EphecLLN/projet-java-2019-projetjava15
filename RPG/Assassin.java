package RPG;

public class Assassin extends Personnage {

    public Assassin(String username){
        super(username, 0,0,"clear",75,0,15, 5,30, 60, 75,30,0,0,new Arme("dague",0), new Armure("cape",0), 10,5,5,2 );
    }

    public void coupCritique(Mob cible){
    		 attaque(cible);
    		 attaque(cible);
    }

    public void boostAttaque(){

    }
    
    public String toString() {
    	return super.toString();
    }
}
