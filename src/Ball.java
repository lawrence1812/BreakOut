import javax.swing.ImageIcon;

public class Ball extends Sprite {
    private int xdir;
    private int ydir;
    private int vel;
    private final int MAX_VEL = 4;

    public Ball() {
        initBall();
    }
    private void initBall() {
        xdir = 1;
        ydir = -9;
        vel = 1;


        loadImage();
        getImageDimensions();
        resetState();
        getMiddlePoint();
    }

    private void loadImage() {
        var ii = new ImageIcon("src/resources/ball.png");
        image = ii.getImage();
    }
    /**
     * move the ball adding to position(x,y) the direction of the ball
     */
    void move() {
        x += (xdir* vel);
        y += (ydir* vel);

        if(x == 0) {
            setXDir(1);
        }

        // if the ball is on the end of the screen the direction become negative direction
        if(x > Commons.WIDTH - imageWidth || x < 0) {
            setXDir(xdir*-1);
            
        }
        
        if(y > Commons.HEIGHT - imageHeight || y < 0) {
            setYDir(ydir*-1);
            
        }

    }
    // change the position of the ball at initial position
    private void resetState() {
        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {
        xdir = x;
    }
    void setYDir(int y) {
        ydir = y;
    }
    public int getYDir() {
        return ydir;
    }
    public int getXDir() {
        return xdir;
    }
    public void incrementaVel() {
        if(vel < MAX_VEL) vel++;
    }

}
