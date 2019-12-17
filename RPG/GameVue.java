 package RPG;


import java.util.Observer;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public abstract class GameVue implements Observer {
	
	protected Personnage model;
	protected GameController controller;
	protected Mob e;
	
	public GameVue(Personnage model, Mob e, GameController controller) {
		this.model = model;
		this.e = e;
		this.controller = controller;
		model.addObserver(this);
		e.addObserver(this);
	}

	public void affiche(String string) {
		System.out.println(string);
	}

}

