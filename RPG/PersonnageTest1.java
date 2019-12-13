package RPG;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest1 {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testExpUp() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1", 5, 10, "Normal", 75, 24, 12, 25, 20, 20, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Personnage p2 = new Personnage("Player2",2 , 10, "Normal", 75, 24, 12, 25, 20, 40, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Personnage p3 = new Personnage("Player3",8 , 10, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Personnage p4 = new Personnage("Player4",4 ,0, "Normal", 75, 24, 12, 25, 20, 25, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);

		p.expUp(5);
		p2.expUp(30);
		p3.expUp(0);
		p4.expUp(120);

		assertEquals(15,p.getExp());
		assertEquals(20,p.getExpLvlUp());
		assertEquals(5,p.getNiveau());

		assertEquals(0,p2.getExp());
		assertEquals(90,p2.getExpLvlUp());
		assertEquals(3,p2.getNiveau());

		assertEquals(10,p3.getExp());
		assertEquals(30,p3.getExpLvlUp());
		assertEquals(8,p3.getNiveau());

		assertEquals(20,p4.getExp());
		assertEquals(125,p4.getExpLvlUp());
		assertEquals(6,p4.getNiveau());

	}

	@Test
	void testLvlUp() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1", 5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Personnage p2 = new Personnage("Player2", 100 , 17, "Normal", 0, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);

		p.lvlUp();
		p2.lvlUp();

		//V�rification de l'augmentation des statistiques.
		assertEquals(6, p.getNiveau());
		assertEquals(14, p.getAttaque());
		assertEquals(27, p.getDefense());
		assertEquals(77, p.getHpMax());
		assertEquals(22, p.getMaxMana());
		assertEquals(80, p.getExpLvlUp());

		assertEquals(100,p2.getNiveau());
	}

	@Test
	void testSoin() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Personnage p2 = new Personnage("Player2",5 , 17, "Normal", 0, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);

		p.soin(50);
		p2.soin(32);

		assertEquals(75,p.getHp());
		assertEquals(0, p2.getHp());

	}

	@Test
	void testAttaque() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 78, 33,weapon, armor, 2, 2, 2, 2);
		Mob ennemi = new Mob(80, 10,"feu",30,12);
		Mob ennemi2 = new Mob(0, 5,"feu",5,25);
		Mob ennemi3 = new Mob(15, 11,"feu",45,2);

		p.attaque(ennemi);
		p.attaque(ennemi2);
		p.attaque(ennemi3);

		assertEquals(48, ennemi.getHp());
		assertEquals(0, ennemi2.getHp());
		assertEquals(0, ennemi3.getHp());

	}

	@Test
	void testAcheterArme() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1",5 , 17, "Normal", 75, 50, 12, 25, 20, 30, 75, 20, 0, 0,weapon, armor, 2, 2, 2, 2);
		Shop sh = new Shop();
		
		p.acheterArme(sh,2);

		assertSame(sh.getArmesDispo().get(2),p.getArme());

	}

	@Test
	void testAcheterArmure() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 1);
		Personnage p1 = new Personnage("Player1",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 0, 0,weapon, armor, 2, 2, 2, 2);
		Personnage p2 = new Personnage("Player1",5 , 17, "Normal", 75,100, 12, 25, 20, 30, 75, 20, 0, 0,weapon, armor, 2, 2, 2, 2);
		
		Shop sh = new Shop();
		
		p1.acheterArmure(sh, 0);
		p2.acheterArmure(sh, 3);
		
		assertSame(armor,p1.getArmure()); // n'a rien achet� car pas assez de pi�ces.
		assertEquals(24,p1.getNbPieces());
		
		assertSame(sh.getArmuresDispo().get(3),p2.getArmure());
		assertEquals(60,p2.getNbPieces());
		
	}

	@Test
	void testMove() {
		Arme weapon = new Arme("�p�e", 2);
		Armure armor = new Armure("armure", 2);
		Personnage p = new Personnage("Player1",5 , 17, "Normal", 75, 24, 12, 25, 20, 30, 75, 20, 0, 0,weapon, armor, 2, 2, 2, 2);
		
		p.move('x',2);
		p.move('y', 5);
		
		assertEquals(2,p.getPosX());
		assertEquals(5,p.getPosY());
	}
}
