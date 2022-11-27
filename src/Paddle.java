import java.awt.event.KeyEvent;

public class Paddle extends Sprite{
    private int speed;
    private int dx;
    public Paddle() {
        initPaddle();
    }

    public void initPaddle() {
        speed = 5;
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
            dx = speed * -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
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

    public void paddleCollision(Ball ball) {
        //palla e paddle
        double coef;
        if(ball.getY()+ball.getImageHeight() > getY() && ball.getY() < getY()+ getImageHeight() 
        && ball.getX() > getX() && ball.getX() < getX()+ getImageWidth() 
        ) { 
            coef = ((ball.x - this.x) - (this.getImageWidth()/2+1)) / 15;
            System.out.println(coef); 
            ball.setYDir(ball.getYDir()* -1.0);
            ball.setXDir(coef);
        }
    }
    

}
