/**
 * 
 */
package RPG;

import java.util.ArrayList;

/**
 * @authors Lebas Ya�l & Mugisha Rodrigue
 * 
 * Classe repr�sentant la boutique o� le personnage peut d�penser ses pi�ces pour acqu�rir des nouveaux �quipements.
 *
 */
public class Shop {
	
	ArrayList <Arme> armesDispo;
	ArrayList <Armure> armuresDispo;

	public Shop() {
		//Armes pr�d�finies � acheter
		armesDispo = new ArrayList <Arme>();
		armesDispo.add(new Arme("baton",2));
		//Armures pr�d�finies � acheter
		armuresDispo = new ArrayList <Armure>();
		armuresDispo.add(new Armure("cape",1));
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
