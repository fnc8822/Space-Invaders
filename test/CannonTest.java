import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CannonTest {
    Cannon ship;
    @BeforeEach
    public void setUp() {
        ship = new Cannon();
        ship.setSpeed(10);
    }

    @Test
    void TestMoveRightFromRight() {
        ship.setPos(730);
        ship.right();
        assertEquals(ship.getX(), 730);
    }
    @Test
    void TestMoveRightFromRightWithEdge() {
        ship.setPos(725);
        ship.right();
        assertEquals(ship.getX(), 730);
    }

    @Test
    void RestMoveRightFromMiddle() {
        ship.setPos(500);
        ship.right();
        assertEquals(ship.getX(), 510);
    }
    @Test
    void TestMoveRightFromLeft() {
        ship.setPos(12);
        ship.right();
        assertEquals(ship.getX(), 22);
    }
    @Test
    void TestMoveLeftFromLeft() {
        ship.setPos(12);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromLeftWithEdge() {
        ship.setPos(17);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromMiddle() {
        ship.setPos(500);
        ship.left();
        assertEquals(ship.getX(), 490);
    }
    @Test
    void TestMoveLeftFromRight() {
        ship.setPos(730);
        ship.left();
        assertEquals(ship.getX(), 720);
    }
    @Test
    void getLives() {
    }

    @Test
    void addLife() {
    }
}