package org.example.app.gui;

import org.example.app.model.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewBooksPanel extends JPanel {

    private BookTableModel tableModel;
    private JTable table;

    public ViewBooksPanel(List<Book> booklist) {
        tableModel=new BookTableModel(booklist);
        table=new JTable(tableModel);

        setBackground(Color.green);

        setLayout(new BorderLayout());

        JScrollPane scrollPane=new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);


    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
