package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String username;

    public Client(String username) {
        this.username = username;
    }

    public void waitMessage() {
        try (Socket socket = new Socket("localhost", 3000)) {
            System.out.println("----------------------------------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(username);
            printWriter.flush();
            String message = "";
            while ((message = bufferedReader.readLine()) != null) {
                printWriter.println(message);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
