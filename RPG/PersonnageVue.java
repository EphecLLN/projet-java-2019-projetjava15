 package RPG;


import java.util.Observer;


public abstract class PersonnageVue implements Observer {
	
	protected Personnage model;
	protected PersonnageController controller;
	protected Mob e;
	
	public PersonnageVue(Personnage model, Mob e, PersonnageController controller) {
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

