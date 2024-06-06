public class MoveThrough implements MovingBehavior{
    Cannon player;
    int speed=3;
    final int GAME_WIDTH = 745;

    public MoveThrough(Cannon getplayer){
        this.player=getplayer;
    }

    @Override
    public void right(){
        if (player.getX() + speed > GAME_WIDTH) {
            player.setPos(0);
        } else {
            player.setPos(player.getX() + speed);
        }
    }
    @Override
    public void left(){
        if (player.getX() - speed < 0) {
            player.setPos(GAME_WIDTH );
        } else {
            player.setPos(player.getX() - speed);
        }
    }
    @Override
    public void up(){

        if (player.getY() - speed < 370) {
            player.setPosY(370);
        } else {
            player.setPosY(player.getY() - speed);
        }
    }
    @Override
    public void down(){

        if (player.getY() + speed > 570) {
            player.setPosY(570);
        } else {
            player.setPosY(player.getY() + speed);
        }
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
