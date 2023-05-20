package sk.stuba.fei.uim.oop.tree;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

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
    private Color color;

    public Tree(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        if (width >= 0 && height >= 0) {
            g.fillOval(x, y, width, 2*height/3);
            g.fillRect(x + width/3, y + height/3, width/3, 2*height/3);
        } else if (width < 0 && height >= 0) {
            g.fillOval(x + width, y, Math.abs(width), 2*height/3);
            g.fillRect(x + Math.abs(width)/3 + width, y + height/3, Math.abs(width)/3, 2*height/3);
        } else if (width >= 0 && height < 0) {
            g.fillOval(x, y + height,width, 2*Math.abs(height)/3);
            g.fillRect(x + width/3, y + Math.abs(height)/3 + height, width/3, 2*Math.abs(height)/3);
        } else {
            g.fillOval(x + width, y + height, Math.abs(width), 2*Math.abs(height)/3);
            g.fillRect(x + Math.abs(width)/3 + width, y + Math.abs(height)/3 + height, Math.abs(width)/3, 2*Math.abs(height)/3);
        }
    }
}
