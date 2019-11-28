package RPG;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class AventurierTest {

    @org.junit.jupiter.api.Test
    void testBoostAttaque() {
        Aventurier a =new Aventurier("moi");
        a.boostAttaque(5);
        Assertions.assertEquals(a.getAttaque(), 15);
        a.boostAttaque(-5);
        Assertions.assertEquals(a.getAttaque(), 10);
        a.boostAttaque(0);
        Assertions.assertEquals(a.getAttaque(), 10);

    }

    @org.junit.jupiter.api.Test
    void testBoostDefense() {
        Aventurier a =new Aventurier("moi");
        a.boostDefense(5);
        Assertions.assertEquals(a.getDefense(), 15);
        a.boostDefense(-5);
        Assertions.assertEquals(a.getDefense(), 10);
        a.boostDefense(0);
        Assertions.assertEquals(a.getDefense(), 10);
    }

    @org.junit.jupiter.api.Test
    void testClearStatus() {
        Aventurier a =new Aventurier("moi");
        a.clearStatus(a);
        Assertions.assertEquals(a.getEtat(), "clear");
        a.setEtat("stun");
        a.clearStatus(a);
        Assertions.assertEquals(a.getEtat(),"clear");

    }

}