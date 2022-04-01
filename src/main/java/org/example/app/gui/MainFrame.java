package org.example.app.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JSplitPane splitPane;
    public MainFrame(JPanel upperPanel,JPanel lowerPanel) throws HeadlessException {
        splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,upperPanel,lowerPanel);

        splitPane.setResizeWeight(0.3);
        setLayout(new BorderLayout());
        add(splitPane,BorderLayout.CENTER);



        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
