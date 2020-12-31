package com.grizzly.base;

import com.grizzly.base.utils.ExcelUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        List<List<String>> resultList = ExcelUtil.readExcel("c:/users/ad/desktop/test.xlsx");
        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                System.out.print("第" + (i) + "行");
                List<String> cellList = resultList.get(i);
                for (int j = 0; j < cellList.size(); j++) {
                    System.out.print("    " + cellList.get(j));
                }
                System.out.println();
            }
        }

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

        //把读取的结果在写回去
//        ExcelUtil.writeExcel(resultList, "H:/result.xlsx");
    }
}