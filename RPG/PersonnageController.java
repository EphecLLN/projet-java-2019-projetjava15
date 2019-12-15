package RPG;

public class PersonnageController {
	private Personnage model;
	private PersonnageVue vue;
	private Mob e;
	
	public PersonnageController(Personnage model,Mob e) {
		this.model = model;
		this.e = e;
	}
	
	public void attaquer(Personnage p, Mob cible) throws InterruptedException {
		p.attaque(cible);
		vue.affiche(p.getUsername() + " attaque");
		vue.affiche("Hp restants mob: "+ e.getHp() + "\n");
		
		Thread.sleep(500);
		
		e.attaque(p);
		vue.affiche("l'enemmi attaque");
		vue.affiche("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
		
		if(p.getHp() <= 0) {
			vue.affiche("\nYou lost !");
		}
		else if(e.getHp() <= 0){
			vue.affiche("Mob a été vaincu !");
			e = null; // Mob éliminé
			vue.affiche("\nYou won !");
			vue.affiche("You gain 60 exp\n");
			p.expUp(60);
		}
	}
	
	public void cast(Personnage p ,Mob cible) throws InterruptedException {
		if(p.getClass().equals(Mage.class)) {
			Mage m = (Mage)p;
			m.sort(cible, "feu");
			vue.affiche(p.getUsername() + " lance un sort");
			vue.affiche("Hp restants mob: "+ e.getHp() + "\n");
		}
		
		Thread.sleep(500);
		
		e.attaque(p);
		vue.affiche("l'enemmi attaque");
		vue.affiche("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
			
		if(p.getHp() <= 0) {
			vue.affiche("\nYou lost !");
		}
		else if(e.getHp() <= 0){
			vue.affiche("Mob a été vaincu !");
			e = null; // Mob éliminé
			vue.affiche("\nYou won !");
			vue.affiche("You gain 60 exp\n");
			p.expUp(60);
		}
	}
	
	
	public void soin(Personnage p, int i) throws InterruptedException {
		if(p.getMana() <= 0) {
			p.setHp(p.getHp());
		}
		else {
		p.soin(i);
		vue.affiche(p.getUsername() + " se soigne");
		
		Thread.sleep(500);
		
		e.attaque(p);
		vue.affiche("l'enemmi attaque");
		vue.affiche("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
		}
	}
	
	public void move(char axe, int speed) {
		model.move(axe, speed);
		vue.affiche(model.getUsername() + " a bougé");
	}
	
	public void lvlUp() {
		model.lvlUp();
		vue.affiche(model.getUsername() + " a gagné un niveau");
	}
	
	public void expUp(int i) {
		model.expUp(i);
		vue.affiche(model.getUsername() + " a gagné "+ i +" point(s) d'exp");
		vue.affiche("Niveau: "+model.getNiveau()+ ", "+ model.getExp()+"/"+model.getExpLvlUp());
	}
		
	public void addView(PersonnageVue vue) {
		this.vue = vue;
	}
}
