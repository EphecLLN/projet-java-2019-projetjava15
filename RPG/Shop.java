/**
 * 
 */
package RPG;

import java.util.ArrayList;

/**
 * @author Rody
 *
 */
public class Shop {
	
	ArrayList <Arme> armesDispo;
	ArrayList <Armure> armuresDispo;

	public Shop() {
		//Armes prédéfinies à acheter
		armesDispo = new ArrayList <Arme>();
		armesDispo.add(new Arme("épée",0));
		armesDispo.add(new Arme("baton",1));
		armesDispo.add(new Arme("dague",1));
		armesDispo.add(new Arme("dague",2));
		
		//Armures prédéfinies à acheter
		armuresDispo = new ArrayList <Armure>();
		armuresDispo.add(new Armure("robe",1));
		armuresDispo.add(new Armure("cape",2));
		armuresDispo.add(new Armure("armure",0));
		armuresDispo.add(new Armure("robe",2));
	} 

	/**
	 * @return the armesDispo
	 */
	public ArrayList<Arme> getArmesDispo() {
		return armesDispo;
	}

	/**
	 * @return the armuresDispo
	 */
	public ArrayList<Armure> getArmuresDispo() {
		return armuresDispo;
	}

	
	public String toString() {
		String s = "Bienvenue en boutique \n\nArme:\n";
		for(Arme a: armesDispo) {
			s += a.toString();
		}
		
		s += "\n\nArmures:\n";
		
		for(Armure arm: armuresDispo) {
			s += arm.toString();
		}
		
		return s;
	}
		
	
}
