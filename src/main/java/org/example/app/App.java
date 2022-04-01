package org.example.app;

import org.example.app.controllers.Controller;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Controller::new);
    }
}
