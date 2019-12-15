package RPG;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PersonnageConsole extends PersonnageVue implements Observer{
	protected Scanner scan;
	//Mob e = new Mob(20, 10, "feu", 30, 20);
	
	public PersonnageConsole(Personnage model,Mob e, PersonnageController controller) {
		super(model,e,controller);
		update(null, null);
		 scan = new Scanner(System.in);
		 new Thread (new ReadInput()).start();	
	}
	/*
	public void fight(Personnage model, Mob e, Scanner sc) throws InterruptedException{
		System.out.println("Battle Started !\n");

		while(e.getHp() > 0 && model.getHp() > 0) {
			System.out.println("Veuillez entrer une action ( atk | heal):");
			String action = sc.next();

			switch (action){
				case "atk":
					controller.attaquer(e);
					//System.out.println(model.getUsername() + " attaque");
					System.out.println("Hp restants mob: "+ e.getHp() + "\n");
					Thread.sleep(2000);
                	break;
				case "heal":
					controller.soin(5);
					//System.out.println(model.getUsername() + "player1 se soigne ! Hp "+ model.getUsername() +": "+  model.getHp() + "\n");
					break;
			}

			if(e.getHp() <= 0) {
				System.out.println("Mob a été vaincu !");
				e=null;
				break;
			}
			else {
				e.attaque(model);
				System.out.println("l'enemmi attaque");
				System.out.println("Hp restants "+ model.getUsername() + " :" + model.getHp() + "\n");
				Thread.sleep(1000);
			}

		}


		if(model.getHp() <= 0) {
			System.out.println("\nYou lost !");
		}
		else {
			e = null; // Mob éliminé
			System.out.println("\nYou won !");
			System.out.println("You gain 60 exp\n");
			controller.expUp(60);
		}
	}
*/
	public void clrscr(){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	@Override
	public void update(Observable o, Object arg) {

		//System.out.println("Veuillez entrer une action ( atk | heal | cast):");
		
	}
	
	public Personnage choixClasse() {
		System.out.println("#### RPG GAME ####");
        System.out.println("start or continue ?");
        String choixDebut = scan.nextLine().toLowerCase();
        while(!"start".equals(choixDebut) && !"continue".equals(choixDebut)) {
        	 System.out.println("start or continue ?");
        	 choixDebut = scan.nextLine().toLowerCase();
        }
        
        System.out.println("Quel type de personnage voulez-vous créer? (assassin, mage ou aventurier)");
        String choixPerso = scan.nextLine().toLowerCase();
        while( !"assassin".equals(choixPerso) && !"mage".equals(choixPerso) && !"aventurier".equals(choixPerso) ){
            System.out.println("choix incorrect, choissez parmis assassin, mage ou aventurier");
            choixPerso = scan.nextLine().toLowerCase();
        }

        String choixUserName ="";
        String confirm ="";
        while(!"oui".equals(confirm)) {
            System.out.println("Choisissez un username");
            choixUserName = scan.nextLine();
            System.out.println("Votre username est " + choixUserName + ", Cela vous convient-il?(oui ou non)");
            confirm = scan.nextLine().toLowerCase();
        }

        switch (choixPerso){
            case "assassin":
                model =new Assassin(choixUserName);
                break;
            case "mage":
                model=new Mage(choixUserName);
                break;
            case"aventurier":
                model = new Aventurier(choixUserName);
                break;
        }
        return model;
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			try {

				while(e.getHp() > 0 && model.getHp() > 0) {
					System.out.println("Veuillez entrer une action ( atk | heal | cast):");
					String action = scan.next();

					switch (action){
						case "atk":
							controller.attaquer(model,e);
		                	break;
						case "heal":
							controller.soin(model,10);
							break;
						case "cast":
							controller.cast(model,e);
							break;
					}
					
				}
			}
			catch(Exception e) {
				System.out.println("Erreur");
			}
		}
	}
}
