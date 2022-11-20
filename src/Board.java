

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel {

    private Timer timer;
    private String message = "Game Over";
    private Ball ball;
    private Ball[] balls;
    private Brick brick;
    private int tempCounter = 0;
    //private Paddle paddle;
    //private Brick[] bricks;
    private boolean inGame = true;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));

        gameInit();
    }

    private void gameInit() {

        ball = new Ball();
        balls = new Ball[0];
        brick = new Brick(150, 200);

        System.out.println("length" + balls.length);
        
        for (int i = 0; i < balls.length; i++) {
            //System.out.println(i);
            balls[i] = new Ball();
            balls[i].setX(10 * i);
        }
        

        timer = new Timer(Commons.PERIOD/100, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {
            drawObjects(g2d);
        } else {
            gameFinished(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {
        
        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),ball.getImageWidth(), ball.getImageHeight(), this);           
        for (int i = 0; i < balls.length; i++) {
            g2d.drawImage(balls[i].getImage(), balls[i].getX(), balls[i].getY(), balls[i].getImageWidth(), balls[i].getImageHeight(), this);
        }
        //drawLine(g2d);

        g2d.drawImage(brick.getImage(), brick.getX(), brick.getY(), brick.getImageWidth(), brick.getImageHeight(), this);


        var font = new Font("Verdana", Font.BOLD, 26);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Boss ale vite perse: "+ tempCounter, (Commons.WIDTH - fontMetrics.stringWidth(message))/2 , Commons.HEIGHT / 8);
    }

    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message, (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2, Commons.WIDTH / 2);
    }
    private void drawLine(Graphics2D g2d) { 
        g2d.drawLine(ball.getX()+13, ball.getY()+13, (ball.getX()+13)+ (ball.getXDir()*1000 ), (ball.getY()+13)+(ball.getYDir()*1000));     
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            //paddle.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            //paddle.keyPressed(e);
        }
    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private void doGameCycle() {   
        ball.move();
        for (int i = 0; i < balls.length; i++) {
            //System.out.println(i);
            balls[i].move();
        }
        
        //paddle.move();
        checkCollision();
        repaint();
    }
    /**
     * like exercise, draw a line on the road of the ball
     */
    
    private void stopGame() {

        inGame = false;
        timer.stop();
    }

    private void checkCollision() {
        if(ball.getY() > brick.getY() && ball.getY() < brick.getY()+brick.getImageHeight() && 
        ball.getX() > brick.getX() && ball.getX() < brick.getX()+brick.getImageWidth()) {
            brick.ballPosition(ball.getX(),ball.getY());
            ball.setYDir(ball.getYDir()*-1);
            ball.incrementaVel();
            tempCounter++;
            brick.setX((int)(Math.random()* (Commons.HEIGHT-brick.getImageHeight())));
            brick.setY((int)(Math.random()* (Commons.WIDTH-brick.getImageWidth())));
        }
    }
}
