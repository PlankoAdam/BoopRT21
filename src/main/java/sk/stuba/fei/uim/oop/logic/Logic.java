package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.gui.Canvas;
import sk.stuba.fei.uim.oop.shapes.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Logic extends UniversalAdapter{

    private final Canvas canvas;
    private Map.Entry<Color, String> color;
    private final HashMap<Color, String> colors;
    private Iterator<Map.Entry<Color, String>> colorIterator;
    private Tree currentTree;
    private Mode mode;
    @Getter
    private final JLabel modeLabel;

    public Logic(Canvas canvas) {
        colors = new HashMap<>();
        colors.put(Color.RED, "RED");
        colors.put(Color.GREEN, "GREEN");
        colors.put(Color.BLUE, "BLUE");
        colorIterator = colors.entrySet().iterator();
        color = colorIterator.next();
        this.canvas = canvas;
        mode = Mode.DRAW;
        modeLabel = new JLabel();
        updateLabels();
    }

    public void updateLabels() {
        modeLabel.setText(String.valueOf(mode));
        modeLabel.setForeground(color.getKey());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(canvas) && mode == Mode.DRAW){
            currentTree = new Tree(e.getX(), e.getY(), 0, 0, color.getKey());
            canvas.addTree(currentTree);
        } else if (e.getSource().equals(canvas) && mode == Mode.MOVE){
            for (Tree tree : canvas.getTrees()) {
                if (tree.contains(e.getX(), e.getY())) {
                    currentTree = tree;
                    currentTree.getRelativeGrabPoint().setLocation(
                            e.getX() - currentTree.getX(),
                            e.getY() - currentTree.getY()
                    );
                }
            }
        }
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(canvas)){
            currentTree = null;
            canvas.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (currentTree != null && e.getSource().equals(canvas)) {
            if (mode == Mode.DRAW) {
                currentTree.setWidth(e.getX() - currentTree.getX());
                currentTree.setHeight(e.getY() - currentTree.getY());
            } else if (mode == Mode.MOVE) {
                currentTree.setX((int) (e.getX() - currentTree.getRelativeGrabPoint().getX()));
                currentTree.setY((int) (e.getY() - currentTree.getRelativeGrabPoint().getY()));
            }
        }
        canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Tree")) {
            mode = Mode.DRAW;
        } else if (e.getActionCommand().equals("Move")) {
            mode = Mode.MOVE;
        } else if (e.getActionCommand().equals("Next color")) {
            if (!colorIterator.hasNext()) {
                colorIterator = colors.entrySet().iterator();
            }
            color = colorIterator.next();
        }
        updateLabels();
    }
}
