package classwork.theme_1.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileList {
    public static void main(String[] args) {
        if(args.length==0){
            listFiles(".");
        } else {
            listFiles(args[0]);
        }
    }

    private static void listFiles(String fname){
        File file = new File(fname);
        if (file.isDirectory()) {
            File[] files = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("th");
                }
            });
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }
}
