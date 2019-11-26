package RPG;

import java.util.Random;

public class Mob {
    private int hp;
    private int attaque;
    private String faiblesse;

    //setters
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public void setFaiblesse(String faiblesse) {
        this.faiblesse = faiblesse;
    }

    //getters
    public int getHp() {
        return hp;
    }
    public int getAttaque() {
        return attaque;
    }
    public String getFaiblesse() {
        return faiblesse;
    }

    public Mob(int hp, int attaque, String faiblesse){
        this.setAttaque(attaque); 
        this.setHp(hp);
        this.setFaiblesse(faiblesse);
    }
    
    public Mob() {
    	this.setAttaque(randomNumber(40,20));
    	this.setHp(randomNumber(70,25));
    	this.setFaiblesse(randomString());
    	
    }
    
    public int randomNumber(int max,int min) {
    	Random random = new Random();
    	int randomNumber = random.nextInt(max - min) + min;
    	return randomNumber;
    }
    
    public String randomString() {
    	Random random = new Random();
    	int randomNumber = random.nextInt(4 - 1) + 1;
    	
    	String s = "";
    	
    	switch(randomNumber) {
    	case 1:
    		s = "feu";
            break;
        case 2:
        	s =  "glace";
            break;
        case 3:
            s = "foudre";
            break;
    	}
    	
    	return s;
    }
    
    public static void main(String [] args) {
    	
    		Mob m = new Mob();
    	
    	System.out.println(m);
    }

    public void attaque(Personnage cible){
        int degats = (this.getAttaque() - (cible.getDefense() + cible.getArmure().getDefense()));
        if (degats <= 0){
            degats =1;
        }
        cible.setHp(cible.getHp()-degats);
    }
    public void stun(Personnage cible){
        cible.setEtat("stun");
    }
    
    public String toString() {
    	return "HP: "+ hp + ", atk: "+ attaque + ", faiblesse: "+ faiblesse;
    	
    }
}
