import java.awt.*;
import java.util.ArrayList;

// Used to handle the various bullets being shot by both the player and the aliens
// Also does collision detection
public class BulletMan {

    private ArrayList<Bullet> playerShots = new ArrayList<>(); // list of player bullets
    private ArrayList<Bullet> enemyShots = new ArrayList<Bullet>(); // list of alien bullets

    private Cannon player;
    private AlienMan enemies;
    private Shield shield;

    private boolean canShoot = true;

    public BulletMan(Cannon getPlayer, AlienMan getEnemies, Shield getShield) {
        player = getPlayer;
        enemies = getEnemies;
        shield = getShield;
    }

    public void addPlayerShot(Bullet getPlayerShot) {
        playerShots.add(getPlayerShot);
    }

    public boolean playerCanShoot() {
        return canShoot;
    }

    public void setAlienShots(ArrayList<Bullet> getAlienShots) {
        enemyShots = getAlienShots;
    }

    public void trackBullets() { // tracks bullets in the game

        // checks if player bullet has hit anything
        for (int i = 0; i < playerShots.size(); i++) {
            Bullet playerShot = playerShots.get(i);
            if (playerShot != null) {
                playerShot.move(); // move player bullet

                //
                if (shield.collide(playerShot.getRect()) || playerShot.getY() <= 40
                        || enemies.collide(playerShot.getRect())) { // check if bullet hits enemy or goes out of bounds
                    playerShots.set(i, null);
                }
            }
        }

        // move enemy shots
        for (int i = 0; i < enemyShots.size(); i++) {
            if (enemyShots.get(i) != null) {
                enemyShots.get(i).move();
                boolean hitTest = false; // sees if alien bullets have hit shield
                hitTest = shield.collide(enemyShots.get(i).getRect());
                if (hitTest) {
                    enemyShots.set(i, null);
                }
            }
        }

        // gets rid of bullets outside of screen
        // this implementation prevents a ConcurrentModificationException
        for (int k = 0; k < enemyShots.size(); k++) {
            if (enemyShots.get(k) != null && enemyShots.get(k).getY() > 770) {
                enemyShots.set(k, null);
            }
        }

        // clears out non-existent bullets
        while (enemyShots.contains(null)) {
            enemyShots.remove(null);
        }
        player.collide(enemyShots); // check if player got hit
        while (playerShots.contains(null)) {
            playerShots.remove(null);
        }
        while (enemyShots.contains(null)) {
            enemyShots.remove(null);
        }

    }

    public ArrayList<Bullet> getPlayerShots() {
        return playerShots;
    }

    public ArrayList<Bullet> getEnemyShots() {
        return enemyShots;
    }

    public void draw(Graphics g) { // draw bullets
        for (Bullet shot : playerShots) {
            shot.draw(g);
        }

        for (Bullet shot : enemyShots) {
            shot.draw(g);
        }

    }

}
