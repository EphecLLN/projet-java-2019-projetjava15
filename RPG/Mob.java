package RPG;

import java.util.Observable;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public class Mob extends Observable{

    //attributs
    private int hp;
    private int attaque;
    private String faiblesse;

    //setters
    public void setHp(int hp) {
        this.hp = hp;
        setChanged();
        notifyObservers();
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public void setFaiblesse(String faiblesse) {
        this.faiblesse = faiblesse;
    }

    //getters
    public int getHp() {
        return hp;
    }
    public int getAttaque() {
        return attaque;
    }
    public String getFaiblesse() {
        return faiblesse;
    }

    //constructeurs
    public Mob(int hp, int attaque, String faiblesse) {
        this.setAttaque(attaque);
        this.setHp(hp);
        this.setFaiblesse(faiblesse);
    }


    //méthodes
    
    /**
     * Méthode permettant au mob d'infliger des dégats au personnage.
     * 
     * @param cible personnage subissant les dégats
     *
     */ 
    public void attaque(Personnage cible) {
        int degats = (this.getAttaque() - (cible.getDefense() + cible.getArmure().getDefense()));
        
        if(cible.getHp() > 0 && degats > 0) {
        		cible.setHp(cible.getHp() - degats);
        }
        else if (cible.getHp() > 0 && degats <= 0) {
            degats = 1;
            cible.setHp(cible.getHp() - degats);
        }
        else if(cible.getHp() <= 0) {
        	cible.setHp(0);
        }
    }

    /**
     * Méthode permettant au mob d'infliger l'état "stun" au personnage lui donnant des malus.
     * 
     * @param cible personnage subissant le stun.
     *
     */ 
    public void stun(Personnage cible) {
    	if(cible.equals(null)) {
    		System.out.println("Aucune cible pour le stun !");
    	}
    	else {
    		cible.setEtat("stun");
    	}
    }
}
