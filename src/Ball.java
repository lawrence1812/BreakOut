

public class Ball extends Sprite {
    private double xdir;
    private double ydir;
    private int vel;
    private double xDoublePos, yDoublePos;
    private final int MAX_VEL = 4;

    public Ball() {
        initBall();
    }
    private void initBall() {
        xdir = 4;
        ydir = 1;
        vel = 2;
        xDoublePos = x;
        yDoublePos = y;

        loadImage("src/resources/ball.png");
        getImageDimensions();
        resetState();
    }
    /**
     * move the ball adding to position(x,y) the direction of the ball
     */
    void move() {
        
        xDoublePos += (xdir/ydir) * vel;
        yDoublePos += (ydir/xdir) * vel;
        System.out.println("xDoublePos: " + xDoublePos + " yDoublePos: " + yDoublePos + "xdir: " + (xdir/ydir));
        x = (int)xDoublePos;
        y = (int)yDoublePos;
        /*
        x += (xdir* vel);
        y += (ydir* vel);
*/
        if(x == 0) {
            setXDir(1);
        }

        // if the ball is on the end of the screen the direction become negative direction
        if(x > Commons.WIDTH - imageWidth || x < 0) {
            setXDir((int)xdir*-1);
            
        }
        
        if(y > Commons.HEIGHT - imageHeight || y < 0) {
            setYDir((int)ydir*-1);
            
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
    public double getYDir() {
        return ydir;
    }
    public double getXDir() {
        return xdir;
    }
    public double getXDoublePos() {
        return xDoublePos;
    }
    public double getYDoublePos() {
        return yDoublePos;
    }
    public void setXDoublePos(double DoublePos) {
        xDoublePos = DoublePos;
    }
    public void setYDoublePos(double DoublePos) {
        xDoublePos = DoublePos;
    }
    public void incrementaVel() {
        if(vel < MAX_VEL) vel++;
    }

}
