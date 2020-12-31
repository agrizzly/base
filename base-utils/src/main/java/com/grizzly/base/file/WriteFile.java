package com.grizzly.base.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

    public static void main(String[] args) throws IOException {

        String path = "c:\\users\\ad\\desktop\\log\\HelloWorld.txt";
        File file = new File(path);
        if (file.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在");
            file.createNewFile();// 不存在则创建
        }
        String content = "hello,grizzly.\n";
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);//true,追加内容
        fileOutputStream.write(content.getBytes());

        fileOutputStream.close();
    }
}
