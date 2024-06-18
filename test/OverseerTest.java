import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OverseerTest {

    Overseer overseer;
    Cannon ship;
    AlienMan enemies;
    Scorekeeper score;
    Shield shield;
    BulletMan shotsFired;
    Component component;

    @BeforeEach
    public void setUp() {
        try {
            ship = Mockito.mock(Cannon.class);
            enemies = Mockito.mock(AlienMan.class);
            score = Mockito.mock(Scorekeeper.class);
            shield = Mockito.mock(Shield.class);
            shotsFired = Mockito.mock(BulletMan.class);
            overseer = new Overseer(ship, enemies, score, shield, shotsFired);
            component = Mockito.mock(Component.class);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    void moveRightWhenRightArrowKeyPressed() {
        // Assuming component, when, modifiers are defined elsewhere in the code
        overseer.keyPressed(
                new KeyEvent(component, KeyEvent.KEY_PRESSED, 100, 100, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED));
        overseer.move();
        Mockito.verify(ship).right();
    }

    @Test
    void moveLeftWhenLeftArrowKeyPressed() {
        overseer.keyPressed(
                new KeyEvent(component, KeyEvent.KEY_PRESSED, 100, 100, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED));
        overseer.move();
        Mockito.verify(ship).left();
    }

    @Test
    void doesNotMoveWhenNoArrowKeyPressed() {
        overseer.move();
        verify(ship, never()).left();
        verify(ship, never()).right();
    }

    @Test
    void gameIsNotPlayingWhenShipHasNoLives() {
        when(ship.getLives()).thenReturn(0);
        assertFalse(overseer.stillPlaying());
    }

    @Test
    void gameIsNotPlayingWhenEnemiesReachedBottom() {
        when(enemies.reachedBottom()).thenReturn(true);
        assertFalse(overseer.stillPlaying());
    }

    @Test
    void gameIsPlayingWhenShipHasLivesAndEnemiesNotReachedBottom() {
        when(ship.getLives()).thenReturn(1);
        when(enemies.reachedBottom()).thenReturn(false);
        assertTrue(overseer.stillPlaying());
    }

    @Test
    void gameIsPausedWhenPKeyPressed() {
        overseer.keyPressed(
                new KeyEvent(component, KeyEvent.KEY_PRESSED, 100, 100, KeyEvent.VK_P, KeyEvent.CHAR_UNDEFINED));
        overseer.keyReleased(
                new KeyEvent(component, KeyEvent.KEY_PRESSED, 100, 100, KeyEvent.VK_P, KeyEvent.CHAR_UNDEFINED));
        assertTrue(overseer.isPaused());
    }

    @Test
    void gameIsNotPausedInitially() {
        assertFalse(overseer.isPaused());
    }

}