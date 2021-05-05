package com.example.eureka;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        String path = "D:\\迅雷下载\\20200808\\m d[84部]";
        File rootFile = new File(path);
        overFile(rootFile);
    }

    private static void overFile(File rootFile) {
        if (rootFile != null && rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            for (File file : files) {
                overFile(file);
            }
        } else {
            if (rootFile.getName().endsWith(".rar")) {
                rootFile.delete();
            } else {
                System.out.println(rootFile.getAbsolutePath());
            }
        }
    }

}
