
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CannonTest {

    @Test
    void TestMoveRightFromRight() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(730);
        ship.right();
        assertEquals(ship.getX(), 730);
    }
    @Test
    void TestMoveRightFromRightWithEdge() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(725);
        ship.right();
        assertEquals(ship.getX(), 730);
    }

    @Test
    void RestMoveRightFromMiddle() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(500);
        ship.right();
        assertEquals(ship.getX(), 510);
    }
    @Test
    void TestMoveRightFromLeft() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(12);
        ship.right();
        assertEquals(ship.getX(), 22);
    }
    @Test
    void TestMoveLeftFromLeft() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(12);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromLeftWithEdge() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(17);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromMiddle() {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(500);
        ship.left();
        assertEquals(ship.getX(), 490);
    }
    @Test
    void TestMoveLeftFromRight() {
        Cannon ship = new Cannon();
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