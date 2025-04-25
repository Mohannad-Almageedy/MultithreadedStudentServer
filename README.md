# Multithreaded Student Server

This is the **server-side application** for the Multithreaded Student Information & Communication System project.

## 🧠 Description

This Java-based server application is designed to handle multiple student clients concurrently using multithreading. Each connected student can submit their basic information (Name, Age, Course) and send messages to the server. The server displays all student information and messages on the console and can broadcast messages to all connected clients.

## 🚀 How to Run

1. Open this project (`MultithreadedStudentServer`) in NetBeans or any Java IDE.
2. Run the `Server.java` file **before** starting any client.
3. Make sure port `1234` is available.
4. The server will wait for incoming client connections.

## 📂 Files Included

- `Server.java` - The main server that listens for client connections and manages them using threads.
- `ClientHandler.java` - A helper class to handle each individual client in its own thread.

## ✅ Features

- Multithreaded client handling.
- Displays each student's name, age, and course.
- Receives and displays messages from clients.
- Supports optional message broadcasting.

## 💡 Notes

- Ensure this server is running before any client tries to connect.
- You can stop the server using the IDE's stop button or by closing the terminal.
