package RPG;

/*
 * Cat�gorie de personnage se caract�risant par ses stats offensives et d�fensives �quilibr�es.
 * 
 */
public class Aventurier extends Personnage {



    public Aventurier(String username){
        super(username,0,0,"clear", 100,100,10,10,50,50, 100, 50,0,0,new Arme("épée", 0 ),new Armure("armure", 0),20,5,5,5);
    }

    /**
     * augmente l'attaque d'une valeur pass�e en param�tre
     * @param i valeur ajout�e � l'attaque
     */
    public void boostAttaque(int i){
    	if(i <= 0 ) {
    		this.setAttaque(this.getAttaque());
    	}
    	else {
    		this.setAttaque(this.getAttaque() + i);
    	}
    }

    /**
     * augmente la d�fense d'une valeur pass�e en param�tre
     * @param i valeur ajout�e à la d�fense
     */
    public void boostDefense(int i){
        this.setDefense(this.getDefense() + i);
    }


    /**
     * si le statut du personnage est diff�rent de "clear", le set � "clear"
     * @param cible personnage dont on change le statut
     */
    public void clearStatus(Personnage cible){
        if(cible.getEtat() != "clear"){
            cible.setEtat("clear");
        }
    }
    
}

