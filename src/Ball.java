import javax.naming.directory.DirContext;

public class Ball extends Sprite {
    private double xdir;
    private double ydir;
    private int vel;
    private double xDoublePos, yDoublePos;
    private double yVel;

    public Ball() {
        initBall();
    }
    private void initBall() {
        xdir = 1;
        ydir = 5;
        yVel = 1;
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
        
        xDoublePos += (xdir/Math.abs(ydir)) ;
        yDoublePos += (ydir/Math.abs(xdir)) ;
    
        x = (int)xDoublePos;
        y = (int)yDoublePos;
        
        checkBounds();

    }
    private void checkBounds() {
        // if the ball is on the end of the screen the direction become negative direction
        if(x > Commons.WIDTH - imageWidth || x < 0) {
            
            if(x > Commons.WIDTH - imageWidth) x = Commons.WIDTH - imageWidth-1;
            if(x < 0) xDoublePos = 1;
            xdir = xdir*(-1);
        } 
        if(y > Commons.HEIGHT - imageHeight || y < 0) {
            
            if(y > Commons.HEIGHT - imageHeight) y = Commons.HEIGHT - imageHeight-1;
            if(y < 0) yDoublePos = 1;
            ydir = ydir*(-1);  
        }
    }
    // change the position of the ball at initial position
    private void resetState() {
        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(double x) {
        xdir = x;
    }
    void setYDir(double y) {
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
    

}
