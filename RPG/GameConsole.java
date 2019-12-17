package RPG;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public class GameConsole extends GameVue implements Observer{
	protected Scanner scan;
	
	public GameConsole(Personnage model,Mob e, GameController controller) {
		super(model,e,controller);
		update(null, null);
		 scan = new Scanner(System.in);
		 new Thread (new ReadInput()).start();	
	}
	
	@Override
	public void update(Observable o, Object arg) {
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
					
					if(model.getHp() <= 0) {
						System.out.println("\nYou lost !");
						break;
					}
					
					else if(e.getHp() <= 0){
						System.out.println("Combat terminé");
						controller.expUp(60);
						model.setNbPieces(model.getNbPieces() + 10);
						e.setHp(80);
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
