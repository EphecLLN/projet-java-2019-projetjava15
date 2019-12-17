package RPG;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * Catégorie de personnage se caractérisant par ses sorts lançant des attaques puissantes.
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
     * inflige des dégats, égaux à  la puissance magique, de type spécifié en paramètre à  la cible passée en paramètre.
     *  Si le type de dégats correspond à une faiblesse de l'ennemi, les dégats seront doublés, triplés voire quadruplés.
     *  
     * @param cible ennemi auquel on inflige les dégats
     * @param type type des dégats ("feu", "foudre" ou "glace")
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
