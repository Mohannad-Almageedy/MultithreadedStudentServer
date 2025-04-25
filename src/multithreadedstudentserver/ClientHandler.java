/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadedstudentserver;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            out.println("Enter your Name:");
            String name = in.readLine();
            out.println("Enter your Age:");
            String age = in.readLine();
            out.println("Enter your Course:");
            String course = in.readLine();

            this.name = name;
            System.out.println("Student Connected -> Name: " + name + ", Age: " + age + ", Course: " + course);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println(name + " has left the session.");
                    break;
                }
                String fullMessage = "[" + name + "]: " + message;
                System.out.println(fullMessage);
                MultithreadedStudentServer.broadcast(fullMessage, this);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
