package com.heybro.service;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.ZonedDateTime;

/**
 * 图片服务
 */
@Slf4j
@Service
public class ImgServiceImpl {

    @Autowired
    private GridFsTemplate fsTemplate;

    /**
     * 读取mongodb
     * @param request
     * @param response
     * @param id
     */
    public void showImage(HttpServletRequest request, HttpServletResponse response, String id){
        GridFSDBFile file = fsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
        try {
            file.writeTo(response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * upload image save mongodb
     * @param image_data
     * @author yanghuadong
     * @return
     */
    public BusinessMessage<JSONObject> uploadImg(MultipartFile image_data){
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            //获取文件全名
            String fileId = this.saveImg(image_data);
            String serverImgFront = "img/show?id=" + fileId;
            JSONObject data = new JSONObject();
            data.put("imgUrl", serverImgFront);
            builder.code("200");
            builder.data(data);
            builder.msg("上传成功");
            builder.success(true);
        }catch (Exception e) {
            builder.code("500");
            builder.msg("上传错误，请重试");
        }
        return builder.build();
    }
    /**
     * 保存文件
     * @param image_data
     * @return mongdb中的id
     * @throws Exception
     */
    private String saveImg(MultipartFile image_data) throws Exception{
        //获取文件全名
        String fileName = image_data.getOriginalFilename();
        //获取前缀
        String prefix = fileName.substring(0, fileName.lastIndexOf("."));
        //加入时间戳
        prefix += "-" + ZonedDateTime.now().toInstant().toEpochMilli();
        //获取扩展名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //设置新名称
        String newFileName = prefix + suffix;
        //保存文件
        GridFSFile gridFSFile = fsTemplate.store(image_data.getInputStream(), newFileName, image_data.getContentType());
        //校验文件
        gridFSFile.validate();
        String serverImgId = gridFSFile.getId().toString();
        return serverImgId;
    }

    /**
     * 保存base64文件
     * @param base64
     * @param usercode
     * @return
     * @throws Exception
     */
    public BusinessMessage<JSONObject> saveBase64(String base64, String usercode){
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            //获取前缀
            String newFileName =usercode+"-" + ZonedDateTime.now().toInstant().toEpochMilli()+".jpg";
            ByteArrayInputStream stream = null;
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes1 = decoder.decodeBuffer(base64);
            stream = new ByteArrayInputStream(bytes1);
            //保存文件
            GridFSFile gridFSFile = fsTemplate.store(stream, newFileName,"JPEG");
            //校验文件
            gridFSFile.validate();
            String serverImgId = gridFSFile.getId().toString();
            String serverImgFront = "/android/api/img/show?id=" + serverImgId;
            JSONObject data = new JSONObject();
            data.put("imgUrl", serverImgFront);
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            builder.msg("上传错误，请重试");
        }
        return builder.build();
    }

    /**
     * 保存二维码信息
     * @param b
     * @param usercode
     * @return
     */
    public BusinessMessage<JSONObject> saveQR(byte[] b,String usercode){
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            InputStream sbs = new ByteArrayInputStream(b);
            //文件名
            String newFileName=usercode+"-" + ZonedDateTime.now().toInstant().toEpochMilli()+".jpg";        //保存文件
            GridFSFile gridFSFile = fsTemplate.store(sbs, newFileName,"JPEG");
            //校验文件
            gridFSFile.validate();
            String fileId = gridFSFile.getId().toString();
            String serverImgFront = "/android/api/img/show?id=" + fileId;
            JSONObject data = new JSONObject();
            data.put("imgUrl", serverImgFront);
            builder.data(data);
            builder.success(true);
        }catch (Exception e) {
            builder.msg("上传错误，请重试");
        }
        return builder.build();
    }
}
