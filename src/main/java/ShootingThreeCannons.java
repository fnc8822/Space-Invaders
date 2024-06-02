import javax.swing.*;
import java.util.ArrayList;

public class ShootingThreeCannons implements ShootingBehavior{
    private Cannon player;
    private long shotCooldown;
    private long lastShotTime;
    private boolean canshoot = true ;
    public ShootingThreeCannons(Cannon getplayer){
        this.player= getplayer;
        player.changeImage(new ImageIcon("sprites/CannonSides.png").getImage());
    }
    @Override
    public ArrayList<Bullet> shoot(){
        ArrayList<Bullet> bullets = new ArrayList<>();
        if (canshoot){
            bullets.add(new Bullet(player.getX(),player.getY(),-1));
            bullets.add(new Bullet(player.getX()-17,player.getY()-5,-1));
            bullets.add(new Bullet(player.getX()+17,player.getY()-5,-1));
        }
        return bullets;
    }
    @Override
    public boolean canShoot(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime > shotCooldown){
            lastShotTime = currentTime;
            return true;
        }
        return false;
    }
    @Override
    public void setCooldown(int getcooldown){
        this.shotCooldown=getcooldown;
    }
}

