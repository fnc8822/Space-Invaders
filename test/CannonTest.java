
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CannonTest {
    private Cannon ship;
    @Mock
    private MovingBehavior movingBehavior;
    private ShootingBehavior shootingBehavior;
    private Bullet bullet;

    @BeforeEach
    void setUp() {
        movingBehavior = Mockito.mock(MoveNormal.class);
        shootingBehavior = Mockito.mock(ShootingNormal.class);
        ship = new Cannon();
        ship.setMovingBehavior(movingBehavior);
        ship.setShootingBehavior(shootingBehavior);
        bullet = Mockito.mock(Bullet.class);
    }

    @Test
    void TestMoveRight() {
        ship.right();
        verify(movingBehavior, times(1)).right();
        verify(movingBehavior, times(0)).left();
    }

    @Test
    void TestMoveLeft() {
        ship.left();
        verify(movingBehavior, times(1)).left();
        verify(movingBehavior, times(0)).right();
    }

    @Test
    void addLife() {
        int currentlives = ship.getLives();
        ship.addLife();
        assertEquals(ship.getLives(), currentlives + 1);
    }

    @Test
    void testGotHit() {
        int expectedLives = ship.getLives() - 1;
        Rectangle bulletRect = new Rectangle(ship.getX(), ship.getY(), 10, 10);
        Bullet bullet = Mockito.mock(Bullet.class);
        when(bullet.getRect()).thenReturn(bulletRect);
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.add(bullet);
        ship.collide(bullets);
        assertEquals(ship.getLives(), expectedLives);
    }
}