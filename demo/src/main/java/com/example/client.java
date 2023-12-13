package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;

public class client {
    public static void main(String[] args) throws IOException {

            ServerHttp s = new ServerHttp();

            s.attendi();
            String req = s.leggi().split(" ")[1];
            if (req.equals("/")) {
                req = "index.html";
                
            }

            File file = new File("src/risposte" + req );

            if (file.exists() && file.isFile()) {
                s.rispondi("HTTP/1.1 200 OK\r\n".getBytes());
                s.rispondi("Content-type: text/html\r\n\r\n".getBytes());
                s.rispondi(Files.readAllBytes(file.toPath()));
            } else {
                s.rispondi("HTTP/1.1 404 Not Found\r\n".getBytes());
                s.rispondi("Content-type: text/html\r\n\r\n".getBytes());
                s.rispondi(Files.readAllBytes(Paths.get("src/risposte/errore.html")));
            }


    }
}