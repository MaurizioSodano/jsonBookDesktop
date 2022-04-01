package org.example.app.services;

import org.example.app.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BookService {
    private static final String DATA_URL = "http://localhost:8080/books";

    public List<Book> getAllBooks() throws IOException {
        var url = new URL(DATA_URL);

        var conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setRequestProperty("Accept", "application/json,text/plain");
        conn.setRequestMethod("GET");

        conn.connect();

        StringBuilder sb = new StringBuilder();
        try (var br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }

        System.out.println(sb);
        conn.disconnect();
        return null;
    }
}
