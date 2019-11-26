/**
 * 
 */
package RPG;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rody
 *
 */
public class Quete {
	
	private int exp;
	private int pieces;
	private Mob [] enemmis;

	
	public Quete() {
		this.setExp(randomNumber(50,30));
		this.setPieces(randomNumber(40,10));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quete q = new Quete();
		
		System.out.println(q);

	}
	
	public int randomNumber(int max,int min) {
    	Random random = new Random();
    	int randomNumber = random.nextInt(max - min) + min;
    	return randomNumber;
    }
	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}
	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	/**
	 * @return the pieces
	 */
	public int getPieces() {
		return pieces;
	}
	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	/**
	 * @return the enemmis
	 */
	public Mob[] getEnemmis() {
		return enemmis;
	}
	/**
	 * @param enemmis the enemmis to set
	 */
	public void setEnemmis(Mob[] enemmis) {
		this.enemmis = enemmis;
	}
	
	public String toString() {
		return "exp à gagner: "+ exp + ", nb de pièces à gagner: "+ pieces;
	}
	

}
