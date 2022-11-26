import javax.swing.ImageIcon;

public class Brick extends Sprite {
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

    public void checkCollision(Ball ball) {
        if (ball.getY() + ball.getImageHeight() > getY() && ball.getY() < getY() + getImageHeight()
                && ball.getX() + ball.getImageWidth() > getX() && ball.getX() < getX() + getImageWidth()) {
            ball.setYDir(ball.getYDir() * -1.0);
            setX((int) (Math.random() * Commons.WIDTH) - getImageWidth());
            setY(100);
        }
    }

}
