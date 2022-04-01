package org.example.app.gui;

import javax.swing.*;
import java.awt.*;

public class ViewBooksPanel extends JPanel {

    private BookTableModel tableModel;
    private JTable table;

    public ViewBooksPanel() {
        tableModel=new BookTableModel();
        table=new JTable(tableModel);

        setBackground(Color.green);

        setLayout(new BorderLayout());

        JScrollPane scrollPane=new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);


    }
}
