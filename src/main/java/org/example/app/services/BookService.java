package org.example.app.services;

import com.google.gson.Gson;
import org.example.app.model.Book;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class BookService {
    private static final String DATA_URL = "http://localhost:8080/books";
    private final Gson gson = new Gson();

    public void saveBook(Book book) throws IOException {


        var json = gson.toJson(book);
        HttpURLConnection con = getHttpURLConnection("POST",json.getBytes().length);
        System.out.println(json);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        con.getResponseCode();//waits the response from the server
        con.disconnect();
    }

    public List<Book> getAllBooks() throws IOException {
        HttpURLConnection conn = getHttpURLConnection("GET", 0);

        StringBuilder sb = new StringBuilder();
        try (var br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        conn.disconnect();

        var bookArray = gson.fromJson(sb.toString(), Book[].class);

        return Arrays.asList(bookArray);
    }

    @NotNull
    private HttpURLConnection getHttpURLConnection(String restType, int length) throws IOException {
        var url = new URL(DATA_URL);

        var conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Accept", "application/json,text/plain");
        conn.setRequestMethod(restType);
        switch (restType) {
            case "GET":
                conn.setDoInput(true);
                break;
            case "POST":
                conn.setRequestProperty("Content-Type", "application/json; utf-8");
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(length);
                break;


        }
        conn.connect();
        return conn;
    }
}
