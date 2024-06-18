import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BulletTest {
    Bullet bulletUp;
    Bullet bulletDown;

    @BeforeEach
    void setUp() {
        bulletUp = new Bullet(100, 100, -1);
        bulletDown = new Bullet(100, 100, 1);
    }

    @Test
    void testMovement() {
        bulletUp.move();
        bulletDown.move();
        assertEquals(90, bulletUp.getY());
        assertEquals(105, bulletDown.getY());
    }

    @Test
    void testPosition() {
        assertEquals(106, bulletUp.getX());
        assertEquals(100, bulletUp.getY());
        assertEquals(100, bulletDown.getX());
        assertEquals(100, bulletDown.getY());
    }
}