package org.example.app.controllers;

import org.example.app.gui.CreateBookPanel;
import org.example.app.gui.MainFrame;
import org.example.app.gui.ViewBooksPanel;
import org.example.app.model.Book;
import org.example.app.services.BookService;

import java.io.IOException;

public class Controller {

    private MainFrame mainFrame;
    private CreateBookPanel createBookPanel;
    private ViewBooksPanel viewBooksPanel;

    private BookService bookService;

    public Controller(){
        bookService=new BookService();
        try {
            var bookList = bookService.getAllBooks();
            viewBooksPanel=new ViewBooksPanel(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createBookPanel=new CreateBookPanel();
        createBookPanel.setFormListener((author,title) -> {
            var book =new Book(title,author);
            try {
                bookService.saveBook(book);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

        mainFrame=new MainFrame(createBookPanel,viewBooksPanel);
    }
}
