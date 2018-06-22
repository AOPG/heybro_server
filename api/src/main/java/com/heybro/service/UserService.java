package com.heybro.service;



import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.AverageUser;
import com.heybro.entity.UserInfo;
import com.heybro.mapper.AverageUserMapper;
import com.heybro.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by 王攀 on 2018/5/29.
 */
@Service
@Slf4j
public class UserService {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AverageUserMapper averageUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 注册
     *password
     * @param username 帐号
     * @param password 密码
     */
    public BusinessMessage<JSONObject> register(String username, String password) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            @SuppressWarnings("serial")
            AverageUser user = averageUserMapper.selectOne(new AverageUser() {{
                setUserName(username);
            }});
            if (null == user) {
                String encPassword = passwordEncoder.encode(password);

                user = new AverageUser();
                user.setUserName(username);
                user.setUserPass(encPassword);
                user.setUserCode(username);
                Date createTime = new Date();
                user.setCreateTime(createTime);
//                user.setClientId(UUID.randomUUID().toString().replace("-", ""));
//                user.setClientSecret(UUID.randomUUID().toString().replace("-", ""));
                averageUserMapper.insert(user);
                JSONObject data = new JSONObject();
                data.put("user_code", user.getUserCode());
                builder.data(data);
                builder.success(true);
            }else{
                builder.msg("注册失败，用户名已经被占用");
            }
        } catch (Exception e) {
            log.error("用户注册失败");
        }
        return builder.build();
    }

    /**
     * 用户个人信息
     * */
    public BusinessMessage<JSONObject> userInfo(String username) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            AverageUser user = averageUserMapper.selectOne(new AverageUser() {{
                setUserName(username);
            }});

            user.setUserPass("");
            if (user!=null){
                String userCode =user.getUserCode();
                UserInfo userInfo = userInfoMapper.selectOne(new UserInfo(){{
                    setUserCode(userCode);
                }});
                JSONObject jsonUser = JSONObject.parseObject(JSONObject.toJSONString(user));
                JSONObject jsonInfo = JSONObject.parseObject(JSONObject.toJSONString(userInfo));
                jsonUser.put("userInfo",jsonInfo);
                builder.msg("加载个人信息成功！");
                builder.success(true);
                builder.data(jsonUser);
            }else {
                builder.msg("加载个人信息失败！");
            }
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }

    /**
     * 根据id查询
     * */
    public BusinessMessage<JSONObject> searchUserById(String id) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            List<AverageUser> userList = averageUserMapper.select(new AverageUser() {{
                setUserCode(id);
            }});
            if (null!=userList&&userList.size()>= 0){
                JSONObject json = new JSONObject();
                json.put("list",userList);
                builder.data(json);
                builder.success(true);
                builder.msg("查询成功！");
            }else {
                builder.msg("查询失败！");
            }
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }

    /**
     * 根据userCode 修改用户信息
     * */
    public BusinessMessage<JSONObject> updateUserInfo(String userCode, String userNickName, String userPortrait,
                                                      String userIntro, String userProvince, String userCity, String birthday) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            AverageUser averageUser = new AverageUser();
            averageUser.setUserCode(userCode);
            averageUser.setUserNickname(userNickName);
            averageUser.setUserPortrait(userPortrait);
            averageUser.setUserIntro(userIntro);
            averageUser.setUserProvince(userProvince);
            averageUser.setUserCity(userCity);
            if (birthday!=null){
                averageUser.setBirthday(new Date(Long.parseLong(birthday)));
            }
            Example averageUserExample = new Example(AverageUser.class);
            Example.Criteria criteria = averageUserExample.createCriteria();
            criteria.andEqualTo("userCode",userCode);
            averageUserMapper.updateByExampleSelective(averageUser,averageUserExample);
            builder.code("200");
            builder.success(true);
            builder.msg("修改成功！");
        }catch (Exception e){
            builder.code("500");
            builder.msg("服务器异常，修改失败");
            e.printStackTrace();
        }
        return builder.build();

    }

    /**
     * 根据userCode获取用户信息
     * */

    public BusinessMessage<JSONObject> userInfoByCode(String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            AverageUser user = averageUserMapper.selectOne(new AverageUser() {{
                setUserCode(userCode);
            }});

            user.setUserPass("");
            user.setUserName("");
            if (user!=null){
                UserInfo userInfo = userInfoMapper.selectOne(new UserInfo(){{
                    setUserCode(userCode);
                }});
                JSONObject jsonUser = JSONObject.parseObject(JSONObject.toJSONString(user));
                JSONObject jsonInfo = JSONObject.parseObject(JSONObject.toJSONString(userInfo));
                jsonUser.put("userInfo",jsonInfo);
                builder.msg("加载个人信息成功！");
                builder.success(true);
                builder.data(jsonUser);
            }else {
                builder.msg("加载个人信息失败！");
            }
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }
}
