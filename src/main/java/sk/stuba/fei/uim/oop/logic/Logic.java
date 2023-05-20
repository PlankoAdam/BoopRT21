package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import lombok.extern.java.Log;
import sk.stuba.fei.uim.oop.gui.Canvas;
import sk.stuba.fei.uim.oop.tree.Tree;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Logic extends UniversalAdapter{

    @Getter
    private Color color;
    private final Canvas canvas;
    private Tree currentTree;

    public Logic(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(canvas)){
            currentTree = new Tree(e.getX(), e.getY(), 0, 0, Color.blue);
            canvas.addTree(currentTree);
            canvas.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(canvas)){
            currentTree = null;
            canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource().equals(canvas)){
            currentTree.setWidth(e.getX() - currentTree.getX());
            currentTree.setHeight(e.getY() - currentTree.getY());
            canvas.repaint();
        }
    }
}
