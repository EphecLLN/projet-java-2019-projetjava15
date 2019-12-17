package RPG;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MobTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAttaque() {
		
		Mob ennemi = new Mob(80, 10,"feu");
		Mob ennemi2 = new Mob(80, 100,"feu");
		Personnage player = new Personnage("Player",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,new Arme("épée", 2), new Armure("armure", 2), 2, 2, 2, 2);
	
		ennemi.attaque(player);
		assertEquals(74,player.getHp());
		ennemi2.attaque(player);
		assertEquals(39,player.getHp());
	}

	@Test
	void testStun() {
		Mob ennemi = new Mob(80, 10,"feu");
		Mob ennemi2 = new Mob(80, 100,"feu");
		
		Personnage player = new Personnage("Player",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,new Arme("épée", 2), new Armure("armure", 2), 2, 2, 2, 2);
		
		ennemi.stun(player);
		assertEquals("stun",player.getEtat());
	}

}
