import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

///// CANNON CLASS (CONTROLS AND DRAWS USER'S CANNON)
public class Cannon {
    private int pos = 366; // position on screen
    private int posY = 570;
    private int lives = 3; // amount of lives before game over
    private Rectangle rectCannon = new Rectangle(pos - 12, 570, 38, 25); // rectangle used for collision

    private Image imgShip = new ImageIcon("sprites/cannon.png").getImage(); // picture of ship
    private Image shipDown0 = new ImageIcon("sprites/c_broken1.png").getImage(); // broken ships
    private Image shipDown1 = new ImageIcon("sprites/c_broken2.png").getImage();
    private int curImage = 0; // determines which broken image will be displayed

    private boolean gotShot = false; // flag to determine if user has been hit
    private int counter = 0; // used to moderate when to display image
    private Clip hitMusic;
    private MovingBehavior movingBehavior;
    private ShootingBehavior shootingBehavior;
    private int shootingPowerUpTimer;
    private int movementPowerUpTimer;
    private boolean hasMovementPowerUp;
    private boolean hasShootingPowerUp;
    private long lastShotTime;

    public Cannon() {

    }

    public void setMovingBehavior(MovingBehavior newBehavior) {
        movingBehavior = newBehavior;
    }

    public void setShootingBehavior(ShootingBehavior newBehavior) {
        shootingBehavior = newBehavior;
    }

    // these two functions move user left or right by 5 units
    public void right() {
        movingBehavior.right();
        updateRect();
    }

    public void left() {
        movingBehavior.left();
        updateRect();
    }

    public void up() {
        movingBehavior.up();
        updateRect();
    }

    public void down() {
        movingBehavior.down();
        updateRect();
    }

    public int getX() {
        return pos;
    }

    public int getY() {
        return posY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public void setPos(int newX) {
        pos = newX;
        updateRect();
    }

    private void updateRect() {
        rectCannon = new Rectangle(pos - 12, posY, 38, 25);
    } // updates collision rectangle

    public int getLives() { // returns # of user lives
        return lives;
    }

    public void addLife() { // adds 1 life to user
        if (lives < 99) {
            lives += 1;
        }
    }

    public boolean gotHit() {
        return gotShot;
    }

    public boolean canShoot() {
        return shootingBehavior.canShoot();
    }

    public void collide(ArrayList<Bullet> getBullets) { // used to see if user collides with any bullets
        for (int i = 0; i < getBullets.size(); i++) {
            if (getBullets.get(i) != null) {
                Rectangle getBulletRect = getBullets.get(i).getRect();
                if (getBulletRect.intersects(rectCannon)) {
                    getBullets.set(i, null);
                    gotShot = true;
                }
            }
        }
        if (gotShot) { // if shot, lose 1 life and reset position
            lives -= 1;
            posY = 570;
            if (lives < 0)
                lives = 0; // prevents # of lives from becoming negative

            // play music
            try {
                hitMusic = SoundMan.play("playerDown");
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics g) {
        if (!gotShot) { // normal ship
            g.drawImage(imgShip, pos - 12, posY, null);
        }
        // draws broken ship when hit
        else if (gotShot && hitMusic != null && hitMusic.isRunning()) {
            counter++;
            if (counter % 5 == 0) {
                curImage = 1 - curImage; // flips between 1 and 0
            }
            if (curImage == 0) {
                g.drawImage(shipDown0, pos - 12, posY, null);
            } else {
                g.drawImage(shipDown1, pos - 12, posY, null);
            }
        } else { // once music is done playing
            pos = 366;
            gotShot = false;
            counter = 0;
        }
    }

    public void setPosY(int newY) {
        posY = newY;
        updateRect();
    }

    public int getShootingPowerUpTimer() {
        return shootingPowerUpTimer;
    }

    public int getMovementPowerUpTimer() {
        return movementPowerUpTimer;
    }

    public void giveRandomMovementPowerUp() {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 70) { // 70% chance to get a random powerup
            movingBehavior = new MoveThrough(this);
        } else {
            movingBehavior = new MoveRandom(this);
        }

        movementPowerUpTimer = 400;
        hasMovementPowerUp = true;
    }

    public void giveRandomShootingPowerUp() {
        shootingBehavior = new ShootingThreeCannons(this);
        shootingPowerUpTimer = 300;
        hasShootingPowerUp = true;
    }

    public boolean hasMovementPowerUp() {
        return hasMovementPowerUp;
    }

    public void updatePowerUpTimers() {
        if (shootingPowerUpTimer > 0) {
            shootingPowerUpTimer--;
        } else {
            hasShootingPowerUp = false;
            shootingPowerUpTimer = 0;
            this.shootingBehavior = new ShootingNormal(this);
        }

        if (movementPowerUpTimer > 0) {
            movementPowerUpTimer--;
        } else {
            hasMovementPowerUp = false;
            movementPowerUpTimer = 0;
            this.movingBehavior = new MoveNormal(this);
        }
    }

    public boolean hasShootingPowerUp() {
        return hasShootingPowerUp;
    }

    public ShootingBehavior getShootingBehavior() {
        return shootingBehavior;
    }

    public MovingBehavior getMovingBehavior() {
        return movingBehavior;
    }

    public void changeImage(Image newimageShip) {
        imgShip = newimageShip;
    }

    public long getLastShotTime() {
        return lastShotTime;
    }

    public void setLastShotTime(long newTime) {
        lastShotTime = newTime;
    }
}
