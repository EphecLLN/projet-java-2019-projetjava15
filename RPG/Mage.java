package RPG;

/**
 * @authors Lebas Ya�l & Mugisha Rodrigue
 * 
 * Cat�gorie de personnage se caract�risant par ses sorts lan�ant des attaques puissantes.
 *
 */
public class Mage extends Personnage {

    private int puissanceMagique;

    public void setPuissanceMagique(int puissanceMagique) {
        this.puissanceMagique = puissanceMagique;
    }

    public int getPuissanceMagique() {
        return puissanceMagique;
    }

    public Mage(String username){
        super(username, 0, 0, "clear",75,0,5, 5,150,50,75,150,0,0,new Arme("baton",0), new Armure("robe",0),2,15,1,1);
        this.setPuissanceMagique(10);
    }

    /**
     * inflige des d�gats, �gaux � la puissance magique, de type sp�cifi� en param�tre � la cible pass�e en param�tre.
     *  Si le type de d�gats correspond �une faiblesse de l'ennemi, les d�gats seront doubl�s, tripl�s voire quadrupl�s.
     *  
     * @param cible ennemi auquel on inflige les d�gats
     * @param type type des d�gats ("feu", "foudre" ou "glace")
     */
    public void sort(Mob cible){
    	this.setMana(this.getMana() - 40);
        int degats = this.getPuissanceMagique()+this.getArme().getPuissanceMagique();
        
        if(this.getMana() <= 0){
        	this.setMana(0);
        }
        else if(cible.getHp() <= 0 || degats > cible.getHp()) {
    		cible.setHp(0);
    	}
        else if (cible.getFaiblesse() == "feu" && cible.getHp() > 0 && this.getMana() > 0){
            degats *= 2;
            cible.setHp(cible.getHp() - degats);
        }
        else if (cible.getFaiblesse() == "glace" && cible.getHp() > 0 && this.getMana() > 0){
            degats *= 3;
            cible.setHp(cible.getHp() - degats);
        }
        else if (cible.getFaiblesse() == "foudre" && cible.getHp() > 0 && this.getMana() > 0){
            degats *= 4;
            cible.setHp(cible.getHp() - degats);
        }
    }

}
