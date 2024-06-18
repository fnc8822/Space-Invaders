import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShootingNormal implements ShootingBehavior {
    private Cannon player;
    private long shotCooldown = 1000;
    private boolean canshoot = true;
    Bullet[] shoot;

    public ShootingNormal(Cannon getPlayer) {
        player = getPlayer;
        player.changeImage(new ImageIcon("sprites/cannon.png").getImage());
    }

    @Override
    public ArrayList<Bullet> shoot() {
        ArrayList<Bullet> bullets = new ArrayList<>();
        if (canshoot) {
            bullets.add(new Bullet(player.getX(), player.getY(), -1));
        }
        return bullets;
    }

    @Override
    public boolean canShoot() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - player.getLastShotTime() > shotCooldown) {
            player.setLastShotTime(currentTime);
            return true;
        }
        return false;
    }

    @Override
    public void setCooldown(int getcooldown) {
        this.shotCooldown = getcooldown;
    }
}
