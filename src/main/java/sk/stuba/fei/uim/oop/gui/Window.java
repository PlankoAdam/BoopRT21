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

        add(canvas, BorderLayout.CENTER);
        add(sideMenu, BorderLayout.PAGE_END);

        Logic logic = new Logic(canvas);
        canvas.addMouseListener(logic);
        canvas.addMouseMotionListener(logic);

        JButton treeBtn = new JButton("Strom");
        JButton moveBtn = new JButton("Presun");
        JButton colorBtn = new JButton("Dalsia farba");
        JLabel colorLabel = new JLabel("Color: " + logic.getColor());
        sideMenu.add(treeBtn);
        sideMenu.add(moveBtn);
        sideMenu.add(colorBtn);
        sideMenu.add(colorLabel);


        setResizable(false);
        setVisible(true);
    }
}
