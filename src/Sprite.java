// per sprite si intende risorse/Immagini per un video-gioco

import java.awt.Image;
import java.awt.Rectangle;
/*
 * Sprite
 */
public class Sprite {
    int x, y, imageWidth, imageHeight;
    Image image;

    public int getX() {
        return x;
    }
    protected void setX(int x) {
        this.x = x;
    }

    protected int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    Image getImage() {
        return image;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }
    /**
    * return an Object Rectangle that can be used to see the Width and Height of the image
    */ 
    
    Rectangle getRect() {
        return new Rectangle(x,y, image.getWidth(null), image.getHeight(null));
    }

    void getImageDimensions() {
        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }
}
