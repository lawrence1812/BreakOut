import java.awt.event.KeyEvent;

public class Paddle extends Sprite{
    private int dx;
    public Paddle() {
        initPaddle();
    }

    public void initPaddle() {
        loadImage("src/resources/paddle.png");
        getImageDimensions();
        resetState();
    }

    private void resetState() {
        x = Commons.INIT_PADDLE_X;
        y = Commons.INIT_PADDLE_Y;
    }
    void move() {
        x += dx *2;
        if (x <= 0) {
            x = 0;
        }
        if (x >= Commons.WIDTH - imageWidth) {
            x = Commons.WIDTH - imageWidth;
        }
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    }

    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

}
