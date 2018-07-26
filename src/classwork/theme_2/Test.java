package classwork.theme_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("User.java"); FileOutputStream out = new FileOutputStream("User2.dat")) {
            int c = 0;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
