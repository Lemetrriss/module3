package classwork.theme_8.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        new Client().run();
    }

    private void run() {
        try (Socket socket = new Socket("127.0.0.1", 1234)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = reader.readLine();
            System.out.println(s);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}