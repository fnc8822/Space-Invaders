
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CannonTest {
    Cannon ship;
    @BeforeEach
    void setUp() {
        ship = new Cannon();
    }

    @Test
    void TestMoveRightFromRight() {

        ship.setSpeed(10);
        ship.setPos(730);
        ship.right();
        assertEquals(ship.getX(), 730);
    }
    @Test
    void TestMoveRightFromRightWithEdge() {

        ship.setSpeed(10);
        ship.setPos(725);
        ship.right();
        assertEquals(ship.getX(), 730);
    }

    @Test
    void RestMoveRightFromMiddle() {

        ship.setSpeed(10);
        ship.setPos(500);
        ship.right();
        assertEquals(ship.getX(), 510);
    }
    @Test
    void TestMoveRightFromLeft() {

        ship.setSpeed(10);
        ship.setPos(12);
        ship.right();
        assertEquals(ship.getX(), 22);
    }
    @Test
    void TestMoveLeftFromLeft() {

        ship.setSpeed(10);
        ship.setPos(12);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromLeftWithEdge() {

        ship.setSpeed(10);
        ship.setPos(17);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromMiddle() {

        ship.setSpeed(10);
        ship.setPos(500);
        ship.left();
        assertEquals(ship.getX(), 490);
    }
    @Test
    void TestMoveLeftFromRight() {

        ship.setSpeed(10);
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