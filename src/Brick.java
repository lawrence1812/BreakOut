import javax.swing.ImageIcon;

public class Brick extends Sprite{
    private boolean broken;

    public Brick(int x, int y) {
        setX(x);
        setY(y);
        initBrick();
    }
    private void initBrick() {
        broken = false;

        loadImage();
        getImageDimensions();
        getMiddlePoint();
    }
    public void setBroken(boolean b) {
        broken = b;
    }
    public boolean isBroken() {
        return broken;
    }

    private void loadImage() {
        var ii = new ImageIcon("src/resources/ballAle.png");
        image = ii.getImage();
    }
    public void ballPosition(int xBall, int yBall) {
        System.out.println("xBall:" + xBall + "yBall:" + yBall);
    }
    
}
