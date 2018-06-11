package com.heybro.custom;

import com.heybro.domain.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String sqlLoadUser;
    private final String sqlLoadAuthorities;
    private final RowMapper<UserEntity> myUserDetailsRowMapper;
    private final RowMapper<GrantedAuthority> authorityRowMapper;

    public CustomUserDetailsService() {
        super();
        sqlLoadUser = "select user_id,user_name,user_pass,enable,user_phone,user_mail from average_user where user_name=?";
        sqlLoadAuthorities = "select authority from authorities where username = ?";

        myUserDetailsRowMapper = (rs, i) -> new UserEntity(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString("user_phone"), rs.getString("user_mail"));

        authorityRowMapper = (rs,i) -> new SimpleGrantedAuthority(rs.getString(1));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            UserEntity userFromQuery = jdbcTemplate.queryForObject(sqlLoadUser, myUserDetailsRowMapper, s);
            logger.info("查询得到用户：{}", userFromQuery);
            List<GrantedAuthority> authorities = jdbcTemplate.query(sqlLoadAuthorities, authorityRowMapper, userFromQuery.getUsername());
            logger.info("得到其权限：{}", authorities);

            return new UserEntity(userFromQuery.getId(), userFromQuery.getUsername(), userFromQuery.getPassword(), userFromQuery.isEnabled(), userFromQuery.getPhone(), userFromQuery.getEmail(), authorities);
        }catch (EmptyResultDataAccessException e){
            logger.info("查询结果集为空：{}", s);
            throw new InvalidGrantException("用户名不存在");
        }
    }
}
