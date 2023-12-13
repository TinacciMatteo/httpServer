package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHttp {

    private ServerSocket serverSocket;
    private Socket client;
    private BufferedReader in;
    private DataOutputStream out;
     
     public void attendi() {

          try {                
                serverSocket = new ServerSocket(8000);
                client = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new DataOutputStream(client.getOutputStream());
                
          } catch (IOException e) {

               e.printStackTrace();
          }
     }

     public String leggi(){
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
     } 
    
     public void rispondi(byte [] test){
        try {
            out.write(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}