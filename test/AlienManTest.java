import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class AlienManTest {
    private AlienMan alienMan;
    private Cannon cannon;
    private Shield shield;
    private Scorekeeper scorekeeper;

    @BeforeEach
    void setUp() {
        cannon = Mockito.mock(Cannon.class);
        scorekeeper = Mockito.mock(Scorekeeper.class);
        shield = Mockito.mock(Shield.class);
        alienMan = new AlienMan(1, scorekeeper, cannon, shield);
    }

    @Test
    void aliensMovementHorizontal() {
        int initialPosition=alienMan.getAliens()[0][0].getX();
        alienMan.move();
        int newPosition = alienMan.getAliens()[0][0].getX();
        assertNotEquals(initialPosition, newPosition);
    }

    @Test
    void aliensMovementVertical() {
        int initialPosition=alienMan.getAliens()[0][0].getY();
        alienMan.move();
        int newPosition = alienMan.getAliens()[0][0].getY();
        assertEquals(initialPosition, newPosition);
    }

    @Test
    void aliensMovementVerticalAfterBounce() {
        int initialPosition=alienMan.getAliens()[0][0].getY();
        for (int i = 0; i < 10; i++) {
            alienMan.move();
        }
        int newPosition = alienMan.getAliens()[0][0].getY();
        assertNotEquals(initialPosition, newPosition);
    }


    @Test
    void aliensGoneWhenAllCollide() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                Rectangle bullet = new Rectangle(alienMan.getAliens()[i][j].getX(), alienMan.getAliens()[i][j].getY(), 10, 10);
                alienMan.collide(bullet);
            }
        }
        assertTrue(alienMan.aliensGone());
    }

    @Test
    void aliensAtStart() {
        assertFalse(alienMan.aliensGone());
    }

    @Test
    void gameNotLostInitially() {
        assertFalse(alienMan.reachedBottom());
    }

    @Test
    void bulletCollidesWithAlien() {
        Rectangle bullet = new Rectangle(alienMan.getAliens()[0][0].getX(), alienMan.getAliens()[0][0].getY(), 10, 10);
        assertTrue(alienMan.collide(bullet));
    }

    @Test
    void bulletDoesNotCollideWithAlien() {
        Rectangle bullet = new Rectangle(0, 0, 10, 10);
        assertFalse(alienMan.collide(bullet));
    }
}