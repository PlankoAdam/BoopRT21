package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import sk.stuba.fei.uim.oop.shapes.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    @Getter
    private final List<Tree> trees;

    public Canvas() {

        trees = new ArrayList<>();
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        trees.forEach(t -> t.draw(g));
    }
}
