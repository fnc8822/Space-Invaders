import java.util.ArrayList;

public interface ShootingBehavior {
    public ArrayList<Bullet> shoot();

    public boolean canShoot();

    public void setCooldown(int cooldown);
}
