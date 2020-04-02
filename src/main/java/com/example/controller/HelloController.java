package com.example.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class HelloController {

    private  String fileRootPath = "C:\\\\image\\\\";

    @GetMapping("/hello")
    public  String  hello(){
        return "hello";
    }

    @PostMapping("/file/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
        String filePath = "";
        System.out.println(request.getServletContext().getRealPath("/"));
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
        String originalFilename = file.getOriginalFilename();
        filePath = new StringBuilder(fileRootPath).append(System.currentTimeMillis())
                .append(originalFilename).toString();
        try{
            file.transferTo(new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
        }
        return filePath;
    }


}
