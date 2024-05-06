import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class CannonTest {
    @Test
    void TestMoveRightFromRight() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(740);
        ship.right();
        assertEquals(ship.getX(), 740);
    }
    @Test
    void TestMoveRightFromRightWithEdge() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(735);
        ship.right();
        assertEquals(ship.getX(), 740);
    }

    @Test
    void RestMoveRightFromMiddle() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(500);
        ship.right();
        assertEquals(ship.getX(), 510);
    }
    @Test
    void TestMoveRightFromLeft() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(12);
        ship.right();
        assertEquals(ship.getX(), 22);
    }
    @Test
    void TestMoveLeftFromLeft() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(12);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromLeftWithEdge() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(17);
        ship.left();
        assertEquals(ship.getX(), 12);
    }
    @Test
    void TestMoveLeftFromMiddle() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(500);
        ship.left();
        assertEquals(ship.getX(), 490);
    }
    @Test
    void TestMoveLeftFromRight() throws Exception {
        Cannon ship = new Cannon();
        ship.setSpeed(10);
        ship.setPos(740);
        ship.left();
        assertEquals(ship.getX(), 730);
    }
    @Test
    void getLives() {
    }

    @Test
    void addLife() {
    }
}