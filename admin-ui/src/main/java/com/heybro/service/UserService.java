package com.heybro.service;//package com.heybro.service;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.domain.ManageUserDTO;
import com.heybro.entity.AverageUser;
import com.heybro.entity.ManageUser;
import com.heybro.entity.ManageUserRole;
import com.heybro.mapper.AverageUserMapper;
import groovy.util.logging.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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

    /**
     * 查询用户列表
     *
     * @param page
     * @param size
     * @return
     */
    public BusinessMessage<JSONObject> indexUserSearch(String userName, Integer page, Integer size) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            PageHelper.startPage(page == null || page == 0 ? 1 : page, size == null ? 10 : size);
            Example example = new Example(AverageUser.class);
            Example.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(userName)) {
                criteria.andLike("userName", "%" + userName + "%");
            }
            List<AverageUser> list = averageUserMapper.selectByExample(example);

            if (null != list && list.size() > 0) {
                PageInfo<AverageUser> pageInfo = new PageInfo<>(list);
                JSONObject json = JSON.parseObject(JSON.toJSONString(pageInfo));
                JSONArray jsonArray = new JSONArray();

                for (int i = 0;i<list.size();i++) {

                    JSONObject item = new JSONObject();
                    item.put("id", list.get(i).getUserId());
                    item.put("userCode", list.get(i).getUserCode());
                    item.put("userName", list.get(i).getUserName());
                    item.put("phone", list.get(i).getUserPhone());
                    item.put("email", list.get(i).getUserMail());
                    item.put("signature", list.get(i).getUserSignature());
                    item.put("userIntro",list.get(i).getUserIntro());
                    item.put("userGrade",list.get(i).getUserGrade());

                    System.out.println("2222222");
                    System.out.println(list.get(i).getUserSex());
                    System.out.println(list.get(i).getUserSignature());
                    System.out.println(list.get(i).getUserIntro());
                    jsonArray.add(item);
                }

                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);

            } else {
                builder.msg("读取失败，请重试");
                PageInfo<AverageUser> pageInfo = new PageInfo<>(list);
                JSONObject json = JSON.parseObject(JSON.toJSONString(pageInfo));
                builder.data(json);
            }
        } catch (Exception e) {
            PageInfo<AverageUser> pageInfo = new PageInfo<>(null);
            JSONObject json = JSON.parseObject(JSON.toJSONString(pageInfo));
            builder.data(json);

        }
        return builder.build();
    }





    /**
     *
     *  修改用户
     *
     * */

    @Transactional
    public BusinessMessage<JSONObject> doEditAverageUser(AverageUser averageUser) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            averageUserMapper.updateByPrimaryKeySelective(averageUser);
            builder.msg("修改成功");
            builder.success(true);
        } catch (Exception e) {
            builder.msg("修改人员失败,请重试");
        }
        return builder.build();
    }

    /**
     *
     *  添加用户
     *
     * */
    public BusinessMessage<JSONObject> doAddAverageUser(AverageUser averageUser)  {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            averageUserMapper.insert(averageUser);
            builder.msg("添加用户成功");
            builder.success(true);
        } catch (Exception e) {
            builder.msg("添加用户失败，请重试");
        }
        return builder.build();
    }

    /*
    * 查找用户
    * */
    public BusinessMessage<JSONObject> findAverageUserById(Integer id) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            JSONObject data = new JSONObject();
            data.put("info", averageUserMapper.selectByPrimaryKey(id));
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            builder.msg("查询用户失败,请重试");
        }
        return builder.build();
    }


    /**
     *  删除用户
     * */

    @Transactional
    public BusinessMessage<JSONObject> deleteAverageUser(String ids) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            String[] idsS = ids.split(",");
            List<Integer> listIds = new ArrayList<>();
            for (String id : idsS) {
                listIds.add(Integer.parseInt(id));
            }
            Example example = new Example(AverageUser.class);
            example.createCriteria().andIn("userId",listIds);
            averageUserMapper.deleteByExample(example);
            builder.msg("删除成功");
            builder.success(true);
        } catch (Exception e) {
            System.out.println(e);
            builder.msg("刪除失败");
        }
        return builder.build();
    }

}
