import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    Enemy enemy;
    @BeforeEach
    public void setUp() {
        enemy = new Enemy(1,50,50);
    }



    @Test
    void movesLeft() {
        int initialposition=enemy.getX();
        int initialvertical=enemy.getY();
        enemy.left();
        assertEquals(initialposition-18, enemy.getX());
        assertEquals(initialvertical, enemy.getY());
    }

    @Test
    void movesSmoothLeft() {
        int initialposition=enemy.getX();
        int initialvertical=enemy.getY();
        enemy.smoothLeft();
        assertEquals(initialposition-6, enemy.getX());
        assertEquals(initialvertical, enemy.getY());
    }

    @Test
    void movesRight() {
        int initialposition=enemy.getX();
        int initialvertical=enemy.getY();
        enemy.right();
        assertEquals(initialposition+18, enemy.getX());
        assertEquals(initialvertical, enemy.getY());
    }

    @Test
    void movesDown() {
        int initialvertical=enemy.getY();
        int initialposition=enemy.getX();
        enemy.down();
        assertEquals(initialvertical+24, enemy.getY());
        assertEquals(initialposition, enemy.getX());
    }

    @Test
    void getSizeXType1() {
        enemy=new Enemy(1,50,50);
        assertEquals(24,enemy.getSizeX());
    }
    @Test
    void getSizeXType2() {
        enemy=new Enemy(2,50,50);
        assertEquals(33,enemy.getSizeX());
    }
    @Test
    void getSizeXType3() {
        enemy=new Enemy(3,50,50);
        assertEquals(37,enemy.getSizeX());
    }
    @Test
    void getSizeXType4() {
        enemy=new Enemy(4,50,50);
        assertEquals(51,enemy.getSizeX());
    }


}