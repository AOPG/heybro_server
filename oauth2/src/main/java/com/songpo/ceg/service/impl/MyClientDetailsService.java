package com.songpo.ceg.service.impl;

import com.songpo.ceg.entity.CegUser;
import com.songpo.ceg.mapper.CegUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by SongpoLiu on 2016/12/23.
 */
@Service
public class MyClientDetailsService implements ClientDetailsService {

    @Autowired
    private CegUserMapper userMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        CegUser user = this.userMapper.selectOne(new CegUser() {{
            setClientId(clientId);
        }});
        if (null == user) {
            throw new ClientRegistrationException("客户端 " + clientId + " 不存在");
        }

        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(user.getClientId());
        details.setClientSecret(user.getClientSecret());
        details.setScope(StringUtils.commaDelimitedListToSet("read,write"));
        details.setAuthorizedGrantTypes(StringUtils.commaDelimitedListToSet("client_credentials"));
        details.setAuthorities(AuthorityUtils.createAuthorityList(user.getRole().toString()));
        return details;
    }
}
