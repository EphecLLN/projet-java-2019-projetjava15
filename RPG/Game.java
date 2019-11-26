package RPG;

import java.util.Scanner;

public class Game {
    public static void main(String[] args)throws InterruptedException{
    	Game g = new Game();
    	
    	Assassin p = new Assassin("Joueur");
    	Mob e = new Mob();
    	
    	g.fight(p,e);
    }
    	
    
    
    public void fight(Personnage p, Mob e) throws InterruptedException{
    	System.out.println("Battle Started !\n");
    	
    	while(e.getHp() > 0 && p.getHp() > 0) {
    	
    		Scanner sc = new Scanner(System.in);
        	System.out.println("Veuillez entrer une action ( atk | heal):");
        	String action = sc.next();   	
        	
        	switch (action){
            case "atk":
            	p.attaque(e);
        		System.out.println(p.getUsername() + " attaque");
        		System.out.println("Hp restants mob: "+ e.getHp() + "\n");
        		Thread.sleep(2000);	
        		break;
            case "heal":
            	p.soin(5);
            	System.out.println("player1 se soigne ! Hp "+ p.getUsername() +": "+  p.getHp() + "\n");
        		break;
        	}
        	
        	if(e.getHp() <= 0) {
        		System.out.println("Mob a été vaincu !");
        		break;
        	}
        	else {
        	e.attaque(p);
    		System.out.println("l'enemmi attaque");
    		System.out.println("Hp restants "+ p.getUsername() + " :" + p.getHp() + "\n");
    		Thread.sleep(1000);
        	}
        	
        }
    	
    	
    	 if(p.getHp() <= 0) {
    		System.out.println("\nYou lost !");
    	}
    	else {
    		e = null; // Mob éliminé
    		System.out.println("\nYou won !");
    		System.out.println("You gain 60 exp\n");
    		p.expUp(60);
    		System.out.println("Niveau: "+p.getNiveau()+ ", "+ p.getExp()+"/"+p.getExpLvlUp());
    	}
    }
		
    	
}

    
    