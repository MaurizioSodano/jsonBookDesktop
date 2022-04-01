package org.example.app.gui;

import org.example.app.model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private List<Book> bookList ;

    public BookTableModel(List<Book> books) {
        this.bookList=books;
    }

    @Override
    public int getRowCount() {
        return bookList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var book = bookList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getAuthor();
            case 2:
                return book.getTitle();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Author";
            case 2:
                return "Title";
        }
        return "";
    }
}
