package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){

        super("OOP RT");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel sideMenu = new JPanel(new GridLayout(1, 4));
        Canvas canvas = new Canvas();
        Logic logic = new Logic(canvas);
        canvas.addMouseListener(logic);
        canvas.addMouseMotionListener(logic);

        add(canvas, BorderLayout.CENTER);
        add(sideMenu, BorderLayout.PAGE_END);

        JButton treeBtn = new JButton("Tree");
        JButton moveBtn = new JButton("Move");
        JButton colorBtn = new JButton("Next color");

        treeBtn.addActionListener(logic);
        moveBtn.addActionListener(logic);
        colorBtn.addActionListener(logic);

        sideMenu.add(treeBtn);
        sideMenu.add(moveBtn);
        sideMenu.add(colorBtn);
        sideMenu.add(logic.getModeLabel());

        setResizable(false);
        setVisible(true);
    }
}
