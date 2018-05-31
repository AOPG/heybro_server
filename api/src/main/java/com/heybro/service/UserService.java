package com.heybro.service;//package com.heybro.service;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.AverageUser;
import com.heybro.mapper.AverageUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王攀 on 2018/5/29.
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private AverageUserMapper averageUserMapper;

    /*
    *
    * 普通用户登陆
    *
    * */
    public String selectAverageUser (String userName , String passWord) throws IOException {


        System.out.println("4444444");
        Example example = new Example(AverageUser.class);
        Example.Criteria criteria = example.createCriteria();

        System.out.println(userName);
        System.out.println(passWord);
        criteria.andEqualTo("userName", userName);
        criteria.andEqualTo("userPass", passWord);

        AverageUser averageUser = new AverageUser();

        if (null != averageUserMapper.selectByExample(example) && averageUserMapper.selectByExample(example).size() > 0) {
            averageUser = averageUserMapper.selectByExample(example).get(0);
        }

        ObjectMapper x = new ObjectMapper();
        String str = "true";
        if (averageUser.getUserId() != null) {
            str = x.writeValueAsString(true);
        } else {
            str = x.writeValueAsString(false);
        }
        return str;

    }
}
