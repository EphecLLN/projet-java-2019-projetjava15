package RPG;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
class AssassinTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testDoubleAttaque() {
		Assassin ninja = new Assassin("Naruto");
		Mob m1 = new Mob(50, 10, "feu");
		Mob m2 = new Mob(0, 10, "foudre");
		Mob m3 = new Mob(150, 10, "glace");
		
		ninja.doubleAttaque(m1);
		ninja.doubleAttaque(m2);
		ninja.doubleAttaque(m3);
		
		assertEquals(0,m1.getHp());
		assertEquals(0,m2.getHp());
		assertEquals(150,m3.getHp());// Aucun dégats effectués car plus de mana disponible pour utiliser cette compétence
	}
	
	@Test
	void testBoostAttaque() {
		Assassin ninja = new Assassin("Naruto");
		ninja.boostAttaque(30);
        assertEquals(45, ninja.getAttaque());
        ninja.boostAttaque(-5);
        assertEquals(45, ninja.getAttaque());
        ninja.boostAttaque(0);
        assertEquals(45, ninja.getAttaque());

    }

}
