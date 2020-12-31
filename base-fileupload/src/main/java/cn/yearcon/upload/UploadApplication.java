package cn.yearcon.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //允许上传的文件最大值
//        factory.setMaxFileSize(DataSize.parse("30MB"));
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize(DataSize.parse("30MB"));
//        return factory.createMultipartConfig();
//    }
}
