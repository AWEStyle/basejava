package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        directoryStart(".\\src\\com\\urise\\webapp", 0);

    }

    public static void directoryStart(String filePath, int level) {
        File dir = new File(filePath);
        int lev = level;
        String[] list = dir.list();

        if (list != null) {
            for (File name : dir.listFiles()) {
                int i = 0;
                do {
                    System.out.print("    ");
                    i++;
                } while (i <= lev);
                if (!name.isDirectory()) {
                        System.out.print("-");
                    }
                System.out.println(name.getName());
                if (name.isDirectory()) {
                    lev++;
                    directoryStart(name.getAbsolutePath(),lev);
                    lev--;
                }
            }
        }
    }
}
