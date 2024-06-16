import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BulletManTest {

    Bullet bullet;
    BulletMan bulletMan;
    Shield shield;
    AlienMan alienMan;
    Cannon player;
    @BeforeEach
    void setUp() {
        shield=Mockito.mock(Shield.class);
        alienMan=Mockito.mock(AlienMan.class);
        player=Mockito.mock(Cannon.class);
        bulletMan = new BulletMan(player, alienMan, shield);
        bullet = Mockito.mock(Bullet.class);
    }

    @Test
    void addPlayerShot() {
        bulletMan.addPlayerShot(bullet);
        assertFalse(bulletMan.getPlayerShots().isEmpty());
    }

    @Test
    void setAlienShots() {
        ArrayList<Bullet> alienBullets = new ArrayList<>();
        alienBullets.add(bullet);
        bulletMan.setAlienShots(alienBullets);
        assertFalse(bulletMan.getEnemyShots().isEmpty());
    }

}