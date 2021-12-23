package com.smups;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.smups.codenightly.Conventions;
import com.smups.codenightly.request.Bericht;

public class App {
    //Port voor de server
    public static final int PORT = Conventions.CODENIGHTLY_PORT;

    public static void main(String[] args) {
        System.out.println("Starting codedusk v1.0 server...");
        //Probeer de server te starten
        ServerSocket server;
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.printf("[FATAL ERROR] - could not open server on port %d\n",
                PORT
            );
            return; //Fatal exception - sluit het programma
        }

        //We hebben nu een server -> open een verbinding met een client
        System.out.printf("[Codedusk] server is listening on port %d...\n",
            PORT
        );

        while (true) {
            try {
                Socket socket = server.accept();
                //Grab input from socket and turn bytes into a Bericht
                ObjectInputStream objstr = new ObjectInputStream(socket.getInputStream());
                Bericht bericht = (Bericht) objstr.readObject();

                //Voer het bericht aan het Handler-monster lol
                //TODO

            } catch (Exception e) {
                System.out.println("[Codedusk] server could not process request");
                e.printStackTrace();
            }
        }
    }
}