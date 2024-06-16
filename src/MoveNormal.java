public class MoveNormal implements MovingBehavior{
    Cannon player;
    int speed = 5;
    final int GAME_WIDTH = 745;

     public MoveNormal(Cannon getplayer){
        this.player=getplayer;
        player.setPosY(570);
    }

    @Override
    public void right(){
        if (player.getX() + speed > GAME_WIDTH) {
            player.setPos(GAME_WIDTH);
        } else {
            player.setPos(player.getX() + speed);
        }
    }
    @Override
    public void left(){
        if (player.getX() - speed < 20) {
            player.setPos(0);
        } else {
            player.setPos(player.getX() - speed);
        }
    }
    @Override
    public void up(){
    }
    @Override
    public void down(){
    }
    @Override
    public void setSpeed(int speed){
        this.speed=speed;
    }
    @Override
    public int getSpeed(){
        return speed;
    }

}
