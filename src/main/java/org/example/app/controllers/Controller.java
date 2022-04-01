package org.example.app.controllers;

import org.example.app.gui.CreateBookPanel;
import org.example.app.gui.MainFrame;
import org.example.app.gui.ViewBooksPanel;
import org.example.app.model.Book;
import org.example.app.services.BookService;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private MainFrame mainFrame;
    private CreateBookPanel createBookPanel;
    private ViewBooksPanel viewBooksPanel;

    private BookService bookService;

    private List<Book> bookList = new ArrayList<>();

    public Controller() {
        bookService = new BookService();

        viewBooksPanel = new ViewBooksPanel(bookList);

        createBookPanel = new CreateBookPanel();
        createBookPanel.setFormListener((author, title) -> {
            var book = new Book(title, author);
            try {
                bookService.saveBook(book);
                refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mainFrame = new MainFrame(createBookPanel, viewBooksPanel);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                refresh();
            }
        });
    }

    protected void refresh()  {
        bookList.clear();
        try {
            bookList.addAll(bookService.getAllBooks());
            viewBooksPanel.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
