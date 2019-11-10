package RPG;

public class Mage extends Personnage {

    private int puissanceMagique;

    public void setPuissanceMagique(int puissanceMagique) {
        this.puissanceMagique = puissanceMagique;
    }

    public int getPuissanceMagique() {
        return puissanceMagique;
    }

    public Mage(String username){
        super(username, 0, 0, "clear",75,0,5, 5,150,50,75,50,150,0,0,new Arme("baton",0), new Armure("robe",0));
        this.setPuissanceMagique(10);
    }

    /**
     * inflige des dégats, égaux à la puissance magique, de type spécifié en paramètre à la cible passée en paramètre,
     *  et si le type de dégats correspond à la faiblesse de l'ennemi, les dégats sont doublés
     * @param cible ennemi auquel on inflige les dégats
     * @param type type des dégats ("feu", "foudre" ou "glace")
     */
    public void sort(Mob cible, String type){
        int degats = this.getPuissanceMagique()+this.getArme().getPuissanceMagique();
        if (cible.getFaiblesse() == type){
            degats *=2;
        }
        cible.setHp(cible.getHp() - degats);
    }

}
