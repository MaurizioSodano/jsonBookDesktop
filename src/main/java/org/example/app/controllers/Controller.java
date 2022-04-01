package org.example.app.controllers;

import org.example.app.gui.CreateBookPanel;
import org.example.app.gui.MainFrame;
import org.example.app.gui.ViewBooksPanel;
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
            var booklist = bookService.getAllBooks();
            System.out.println(booklist);
            viewBooksPanel=new ViewBooksPanel(booklist);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createBookPanel=new CreateBookPanel();
        createBookPanel.setFormListener((author,title) -> {
            System.out.println(author+": "+title);
        });

        mainFrame=new MainFrame(createBookPanel,viewBooksPanel);
    }
}
