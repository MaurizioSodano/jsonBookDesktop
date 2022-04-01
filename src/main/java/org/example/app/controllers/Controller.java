package org.example.app.controllers;

import org.example.app.gui.CreateBookPanel;
import org.example.app.gui.MainFrame;
import org.example.app.gui.ViewBooksPanel;

public class Controller {

    private MainFrame mainFrame;

    private CreateBookPanel createBookPanel;
    private ViewBooksPanel viewBooksPanel;
    public Controller(){
        createBookPanel=new CreateBookPanel();
        viewBooksPanel=new ViewBooksPanel();
        mainFrame=new MainFrame(createBookPanel,viewBooksPanel);
    }
}
