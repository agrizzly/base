package com.grizzly.base.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        String path = "c:\\users\\ad\\desktop\\log\\HelloWorld.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        fileInputStream.close();
    }
}
