package cn.yearcon.upload.controller;

import cn.yearcon.upload.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadController {

    @Value("${uploadHost}")
    private String uploadHost;

    private String[] types = new String[]{".pdf", ".doc", ".docx", ".xls", ".xlsx", ".zip", ".rar", ".mp4"};

    @PostMapping(value = "fileupload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if (!Arrays.asList(types).contains(suffixName)) {
            return Result.fail("不支持的文件格式");
        }
        String name = UUID.randomUUID().toString().replaceAll("-", "") + suffixName;
        System.out.println("文件大小为:" + file.getSize());
        System.out.println("原文件名为:" + fileName);
        System.out.println("新文件名为:" + name);
        String filePath = "/upload/";   // Linux系统
//        String filePath = "F:\\upload\\";   // Windows系统
        String path = filePath + name;
        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("url", uploadHost + "/" + name);
        return Result.success(map);
    }
}
