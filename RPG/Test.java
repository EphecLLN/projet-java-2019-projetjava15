
package RPG;

import java.io.IOException;

public class Test {
	Personnage model;
	
	public Test() throws IOException {
		model = new Mage("toto");
		Mob e = new Mob(80, 10, "feu", 30, 20);
        
		PersonnageController consoleC = new PersonnageController(model,e);
		PersonnageController guiC = new PersonnageController(model,e);
		
		PersonnageConsole pc = new PersonnageConsole(model,e,consoleC);
		PersonnageGUI pg = new PersonnageGUI(model,e,guiC);
		
		consoleC.addView(pc);	
		guiC.addView(pg);
	}

	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Test();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
