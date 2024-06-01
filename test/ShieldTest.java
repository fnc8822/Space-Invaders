import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {
    Shield shield;
    Rectangle bulletRect;

    @BeforeEach
    void setUp() {
        shield = new Shield();
    }
    @Test
    void collideFirstSector() {
        bulletRect = new Rectangle(120, 460, 2,14);
        assertTrue(shield.collide(bulletRect));
    }

    @Test
    void collideSecondSector() {
        bulletRect = new Rectangle(260, 460, 2,14);
        assertTrue(shield.collide(bulletRect));
    }

    @Test
    void collideThirdSector() {
        bulletRect = new Rectangle(430, 460, 2,14);
        assertTrue(shield.collide(bulletRect));
    }

    @Test
    void collideFourthSector() {
        bulletRect = new Rectangle(580, 460,2,14);
        assertTrue(shield.collide(bulletRect));
    }
}