package classwork.theme_1.ex3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileCopy {
    public static void main(String[] args) {
        copy(args[0], args[1]);
    }

    private static void copy(String f1, String f2) {
        try(FileInputStream in = new FileInputStream(f1); FileOutputStream out = new FileOutputStream(f2)){
            int data;
            while ((data = in.read()) != -1){
                out.write(data);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
