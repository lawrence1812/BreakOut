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

        loadImage();
        getImageDimensions();
    }
    public void setBroken(boolean b) {
        broken = b;
    }
    public boolean isBroken() {
        return broken;
    }

    private void loadImage() {
        var ii = new ImageIcon("src/resources/brick.png");
        image = ii.getImage();
    }


    /* cose inutili */
    public void ballPosition(int xBall, int yBall) {
        System.out.println("xBall:" + xBall + "yBall:" + yBall);
    }
    public void position(){
        System.out.println("x: " + x + "y:" + y);
    }
    
}
