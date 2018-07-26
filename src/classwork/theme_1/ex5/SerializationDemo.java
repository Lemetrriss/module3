package classwork.theme_1.ex5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
    public static void main(String[] args) {
//        List<User> users = new ArrayList<>();
//        users.add(new User(1, "Ivan", "Ivanov", 90));
//        users.add(new User(2, "Petya", "Ivanova", 88));
//        users.add(new User(3, "Masha", "Ivanova", 39));
//        Memento memento = new Memento();
//        memento.setUsers(users);
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
//            oos.writeObject(memento);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            Memento memento = (Memento) ois.readObject();
            List<User> users = memento.getUsers();
            for (User user : users) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getLastName() + " " + user.getWeight());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
