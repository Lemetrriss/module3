package classwork.theme_1;

import java.io.Console;


public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();
        if(console==null){
            System.out.println("null");
        } else {
            System.out.println("console");
            int a = Integer.parseInt(console.readLine());
            console.printf("a=%d\n", a);
        }
    }
}
