package RPG;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MageTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSort() {
		Mage player = new Mage("Magicien");
		Mob m1 = new Mob(80, 10, "feu");
		Mob m2 = new Mob(100, 10, "foudre");
		Mob m3 = new Mob(10, 10, "glace");
		
		player.sort(m1);
		player.sort(m2);
		player.sort(m3);
		
		assertEquals(50,m1.getHp());
		assertEquals(40,m2.getHp());
		assertEquals(0,m3.getHp());
		
	}

}
