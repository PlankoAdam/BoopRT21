package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

@Getter
public class Tree {

    @Setter
    private int x;
    @Setter
    private int y;
    @Setter
    private int width;
    @Setter
    private int height;
    private final Ellipse2D ellipse;
    private final Rectangle2D rectangle;
    private final Color color;

    private final Point relativeGrabPoint;

    public Tree(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ellipse = new Ellipse2D.Double(x, y, width, height);
        this.rectangle = new Rectangle2D.Double(x, y, width, height);
        this.color = color;

        relativeGrabPoint = new Point(x, y);
    }

    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(color);
        if (width >= 0 && height >= 0) {
            ellipse.setFrame(x, y, width, (double) (2 * height) /3);
            rectangle.setRect(x + (double) width /3, y + (double) height /3, (double) width /3, (double) (2 * height) /3);
        } else if (width < 0 && height >= 0) {
            ellipse.setFrame(x + width, y, Math.abs(width), (double) (2 * height) /3);
            rectangle.setRect(x + (double) Math.abs(width) /3 + width, y + (double) height /3, (double) Math.abs(width) /3, (double) (2 * height) /3);
        } else if (width >= 0) {
            ellipse.setFrame(x, y + height,width, (double) (2 * Math.abs(height)) /3);
            rectangle.setRect(x + (double) width /3, y + (double) Math.abs(height) /3 + height, (double) width /3, (double) (2 * Math.abs(height)) /3);
        } else {
            ellipse.setFrame(x + width, y + height, Math.abs(width), (double) (2 * Math.abs(height)) /3);
            rectangle.setRect(x + (double) Math.abs(width) /3 + width, y + (double) Math.abs(height) /3 + height, (double) Math.abs(width) /3, (double) (2 * Math.abs(height)) /3);
        }
        graphics2D.fill(ellipse);
        graphics2D.fill(rectangle);
    }

    public boolean contains(double x, double y) {
        return (ellipse.contains(x, y) || rectangle.contains(x, y));
    }
}
