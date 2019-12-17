package RPG;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * Catégorie de personnage se caractérisant par ses dégats/coups importants mais n'étant très robuste.
 *
 */
public class Assassin extends Personnage {

    public Assassin(String username){
        super(username, 0,0,"clear",30,0,15, 5,30, 100, 30,30,0,0,new Arme("dague",0), new Armure("cape",0), 10,5,5,2 );
    }

    /**
     * Méthode se basant sur la méthode "attaque" de la classe Personnage, pour effectuer un double coup.
     * 
     * @param cible ennemi subissant les dégats
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
     * augmente l'attaque d'une valeur passée en paramètre
     * @param i valeur ajoutée Ã  l'attaque
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
