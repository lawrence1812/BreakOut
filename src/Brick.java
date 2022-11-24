import javax.swing.ImageIcon;

public class Brick extends Sprite{
    private boolean broken;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        initBrick();
    }
    private void initBrick() {
        broken = false;

        loadImage("src/resources/brick.png");
        getImageDimensions();
    }
    public void setBroken(boolean b) {
        broken = b;
    }
    public boolean isBroken() {
        return broken;
    }




    /* cose inutili */
    public void ballPosition(int xBall, int yBall) {
        System.out.println("xBall:" + xBall + "yBall:" + yBall);
    }
    public void position(){
        System.out.println("x: " + x + "y:" + y);
    }
    
}
