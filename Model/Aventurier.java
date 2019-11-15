package Model;

import RPG.Arme;
import RPG.Armure;
import RPG.Personnage;

public class Aventurier extends Personnage {



    public Aventurier(String username){
        super(username,0,0,"clear", 100,0,10,10,50,50, 100, 50,0,0,new Arme("épée", 0 ),new Armure("armure", 0),20,5,5,5);
    }

    /**
     * augmente l'attaque d'une valeur passée en paramètre
     * @param i valeur ajoutée à l'attaque
     */
    public void boostAttaque(int i){
        this.setAttaque(this.getAttaque() + i);
    }

    /**
     * augmente la défense d'une valeur passée en paramètre
     * @param i valeur ajoutée à la défense
     */
    public void boostDefense(int i){
        this.setDefense(this.getDefense() + i);
    }


    /**
     * si le statut du personnage est différent de "clear", le set à "clear"
     * @param cible personnage dont on change le statut
     */
    public void clearStatus(Personnage cible){
        if(cible.getEtat() != "clear"){
            cible.setEtat("clear");
        }
    }
}
