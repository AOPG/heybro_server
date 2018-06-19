package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.service.ImgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    ImgServiceImpl imgService;

    /**
     * 读取图片
     * @param request
     * @param response
     * @param id
     */
    @GetMapping("/show")
    public void show(HttpServletRequest request, HttpServletResponse response,String id){
        this.imgService.showImage(request,response,id);
    }

    /**
     * 上传图片
     * @param imageData
     * @return
     */
    @PostMapping("uploadImage")
    public BusinessMessage<JSONObject> uploadImage(@RequestParam("imageData") MultipartFile imageData) {
        return this.imgService.uploadImg(imageData);
    }

    /**
     * 上传图片
     * @param imageData
     * @return
     */
    @PostMapping("uploadImg")
    public BusinessMessage<JSONObject> uploadImg(MultipartFile imageData) {
        return this.imgService.uploadImg(imageData);
    }
}
