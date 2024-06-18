import java.util.Random;

public class MoveRandom implements MovingBehavior {
    Cannon player;
    int speed = 1;
    final int GAME_WIDTH = 745;

    public MoveRandom(Cannon getplayer) {
        this.player = getplayer;
        player.setPosY(570);
    }

    @Override
    public void right() {
        Random random = new Random();
        if (player.getX() + speed > GAME_WIDTH) {
            player.setPos(GAME_WIDTH);
        } else {
            player.setPos(player.getX() + speed * (1 + random.nextInt(0, 16)));
        }
    }

    @Override
    public void left() {
        Random random = new Random();
        if (player.getX() - speed < 0) {
            player.setPos(0);
        } else {
            player.setPos(player.getX() - speed * (1 + random.nextInt(-4, 16)));
        }
    }

    @Override
    public void up() {
    }

    @Override
    public void down() {
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

}
