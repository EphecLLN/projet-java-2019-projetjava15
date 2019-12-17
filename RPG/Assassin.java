package RPG;

/**
 * @authors Lebas Ya�l & Mugisha Rodrigue
 * 
 * Cat�gorie de personnage se caract�risant par ses d�gats/coups importants mais n'�tant tr�s robuste.
 *
 */
public class Assassin extends Personnage {

    public Assassin(String username){
        super(username, 0,0,"clear",30,0,15, 5,30, 100, 30,30,0,0,new Arme("dague",0), new Armure("cape",0), 10,5,5,2 );
    }

    /**
     * M�thode se basant sur la m�thode "attaque" de la classe Personnage, pour effectuer un double coup.
     * 
     * @param cible ennemi subissant les d�gats
     *
     */
    public void doubleAttaque(Mob cible){
    	if(this.getMana() <= 0) {
    		System.out.println("Vous n'avez plus de mana");
    	}
    	else {
    	 attaque(cible);
		 attaque(cible);
		 System.out.println(this.getUsername() + " utilise double attack");
		 this.setMana(0);
    	}
    }

    /**
     * augmente l'attaque d'une valeur pass�e en param�tre
     * @param i valeur ajout�e à l'attaque
     */
    public void boostAttaque(int i){
    	if(i <= 0 ) {
    		this.setAttaque(this.getAttaque());
    	}
    	else {
    		this.setAttaque(this.getAttaque() + i);
    	}
    }
}
