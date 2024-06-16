import javax.swing.*;
import java.util.ArrayList;

public class ShootingThreeCannons implements ShootingBehavior{
    private Cannon player;
    private long shotCooldown = 1000;
    private long lastShotTime;
    private boolean canshoot = true ;
    public ShootingThreeCannons(Cannon getplayer){
        this.player= getplayer;
        player.changeImage(new ImageIcon("sprites/CannonSides.png").getImage());
        lastShotTime = System.currentTimeMillis()-500;
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
        if (currentTime - player.getLastShotTime() > shotCooldown){
            player.setLastShotTime(currentTime);
            return true;
        }
        return false;
    }
    @Override
    public void setCooldown(int getcooldown){
        this.shotCooldown=getcooldown;
    }
}

