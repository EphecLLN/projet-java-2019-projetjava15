
package RPG;

import java.io.IOException;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public class Main {
	
	public Main() throws IOException {
		Personnage model = new Mage("toto");
		Mob e = new Mob(80, 10, "feu");
		
		GameController consoleC = new GameController(model,e);
		GameController guiC = new GameController(model,e);
		
		GameConsole gc = new GameConsole(model,e,consoleC);
		GameGUI gg = new GameGUI(model,e,guiC);

		consoleC.addView(gc);
		guiC.addView(gg);
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
