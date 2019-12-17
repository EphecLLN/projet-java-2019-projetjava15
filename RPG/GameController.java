package RPG;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public class GameController {
	private Personnage model;
	private GameVue vue;
	private Mob e;
	
	public GameController(Personnage model,Mob e) {
		this.model = model;
		this.e = e;
	}
	
	public void attaquer(Personnage p, Mob cible) throws InterruptedException {
		
		p.attaque(cible);
		System.out.println(p.getUsername() + " attaque");
		System.out.println("Hp restants mob: "+ e.getHp() + "\n");
		
		Thread.sleep(500);
		
		e.attaque(p);
		System.out.println("l'enemmi attaque");
		System.out.println("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
		
	}
	
	public void cast(Personnage p ,Mob cible) throws InterruptedException {
		if(p.getClass().equals(Mage.class)) {
			Mage m = (Mage)p;
			m.sort(cible);
			System.out.println(p.getUsername() + " lance un sort");
			System.out.println("Hp restants mob: "+ e.getHp() + "\n");
		}
		
		if(p.getClass().equals(Assassin.class)) {
			Assassin a = (Assassin)p;
			a.doubleAttaque(cible);
			System.out.println("Hp restants mob: "+ e.getHp() + "\n");
		}
		
		
		Thread.sleep(500);
		
		e.attaque(p);
		System.out.println("l'enemmi attaque");
		System.out.println("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
	}
	
	
	public void soin(Personnage p, int i) throws InterruptedException {
		if(p.getMana() <= 0) {
			p.setHp(p.getHp());
		}
		else {
		p.soin(i);
		System.out.println(p.getUsername() + " se soigne");
		}
		
		Thread.sleep(500);
		
		e.attaque(p);
		System.out.println("l'enemmi attaque");
		System.out.println("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
		
	}
	
	public void expUp(int i) {
		model.expUp(i);
		System.out.println(model.getUsername() + " a gagné "+ i +" point(s) d'exp");
		System.out.println("Niveau: "+model.getNiveau()+ ", "+ model.getExp()+"/"+model.getExpLvlUp());
	}
		
	public void addView(GameVue vue) {
		this.vue = vue;
	}
}
