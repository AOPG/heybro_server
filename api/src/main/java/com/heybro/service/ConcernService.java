package com.heybro.service;


import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.AverageUser;
import com.heybro.entity.Concern;
import com.heybro.mapper.AverageUserMapper;
import com.heybro.mapper.ConcernMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Slf4j
public class ConcernService {

    @Autowired
    ConcernMapper concernMapper;

    @Autowired
    AverageUserMapper averageUserMapper;

    /**
     * 所有关注，未分页
     *
     * */
    public BusinessMessage<JSONObject> getConcernIndex(String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            List<Concern> list;
            Concern concern = new Concern();
            concern.setUserCode(userCode);
            list = concernMapper.select(concern);
            if (null!=list&&list.size()>= 0){
                JSONObject json = new JSONObject();
                json.put("list",list);
                builder.data(json);
                builder.success(true);
                builder.msg("查询成功！");
            }else {
                builder.msg("查询失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> concernByUserCode(String userCode,String concernCode,String accessToken) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            AverageUser user = averageUserMapper.selectOne(new AverageUser(){{
                setUserCode(userCode);
            }});

            AverageUser concernUser = averageUserMapper.selectOne(new AverageUser(){{
                setUserCode(concernCode);
            }});
            if (null!=user&&user.getAccessToken().equals(accessToken)){
                Concern concern = new Concern();
                concern.setUserCode(userCode);
                concern.setUserConcernCode(concernCode);
                concern.setUserNote(concernUser.getUserNickname());

                Example concernExample = new Example(Concern.class);
                Example.Criteria criteria = concernExample.createCriteria();
                criteria.andEqualTo("userCode",userCode);
                criteria.andEqualTo("userConcernCode",concernCode);
                int count = concernMapper.selectByExample(concernExample).size();
                if (count>0){
                    builder.success(false);
                    builder.msg("您已经关注过了！");
                }else {
                    concernMapper.insert(concern);
                    builder.success(true);
                    builder.msg("关注成功！");
                }
            }else {
                builder.msg("关注失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }
}
