package classwork.theme_1.ex5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReplacementInFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("User.java"));
             PrintWriter writer = new PrintWriter("User.txt")) {
            String line;
            while ((line = reader.readLine()) != null){
                writer.println(line.replace("public", "private"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
