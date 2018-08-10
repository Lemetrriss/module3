package classwork.theme_8.server;

import classwork.theme_8.client.Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<ClientHandler> handlers = new ArrayList<>();

    public static void main(String[] args) {
//        InetAddress ip = null;
//        try {
//            ip = InetAddress.getByName("www.berkut.mk.ua");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        System.out.println(ip.getAddress());
//        System.out.println(ip.getHostAddress());
//        System.out.println(ip.getHostName());

        new Main().run();
    }

    private void run() {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(this, socket);
                handlers.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isFree(String name) {
        return handlers.stream().noneMatch(h -> name.equals(h.getName()));
    }

    public void remove(String name) {
        handlers.removeIf(h -> name.equals(h.getName()));
    }

    public void remove(ClientHandler clientHandler) {
        handlers.remove(clientHandler);
    }

    public synchronized void send(String name, String line) {
        handlers.forEach(h -> h.print(name, line));
    }
}