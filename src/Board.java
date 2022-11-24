

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
    private Paddle paddle;
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

        paddle = new Paddle();
        ball = new Ball();
        balls = new Ball[0];
        brick = new Brick(150, 100);
        
        for (int i = 0; i < balls.length; i++) {
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
            System.out.println("fine gioco");
        }
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawSprites(Graphics2D g2d, Sprite sprite) {
        g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(),sprite.getImageWidth(), sprite.getImageHeight(), this);
    }
    private void drawCounter(Graphics2D g2d) {
        var font = new Font("Verdana", Font.BOLD, 26);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Points: "+ tempCounter, (Commons.WIDTH - fontMetrics.stringWidth(message))/2 , Commons.HEIGHT / 8);
    }
    private void drawObjects(Graphics2D g2d) {
        
        drawCounter(g2d);
        drawSprites(g2d, ball);
        drawSprites(g2d, paddle);
        drawSprites(g2d, brick);

        for (int i = 0; i < balls.length; i++) {
            drawSprites(g2d, balls[i]);
        }

        
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
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
            balls[i].move();
        }
        
        paddle.move();
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
        if(ball.getY()+ball.getImageHeight() > brick.getY() && ball.getY() < brick.getY()+brick.getImageHeight() 
            && ball.getX()+ball.getImageWidth() > brick.getX() && ball.getX() < brick.getX()+brick.getImageWidth()
            ) {
                //brick.ballPosition(ball.getX(),ball.getY());
                ball.setYDir((int) (ball.getYDir()*-1.0));
                ball.incrementaVel();
                tempCounter++;
                brick.setX((int)(Math.random()* Commons.WIDTH)-brick.getImageWidth());
                brick.setY(100);//(int)(Math.random()* (Commons.WIDTH-brick.getImageWidth())));
                brick.position();
            }
        

        if(ball.getY()+ball.getImageHeight() > paddle.getY() && ball.getY() < paddle.getY()+paddle.getImageHeight() 
        && ball.getX() > paddle.getX() && ball.getX() < paddle.getX()+paddle.getImageWidth() 
        ) {
            //brick.ballPosition(ball.getX(),ball.getY());
            ball.setYDir((int) (ball.getYDir()*-1.0));
        }
    }

}
