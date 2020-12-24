package com.wsy.cloud.oauth.config;

import com.wsy.cloud.oauth.domain.MemberDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {
    //增强Jwt,可在token中加入额外的信息,比如nick_name,需要重写方法
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication){
        if(accessToken instanceof DefaultOAuth2AccessToken){
            Object principal = authentication.getPrincipal();
            System.out.println("principal.getClass()"+principal.getClass());
            if(principal instanceof MemberDetails)
            {
                MemberDetails memberDetails = (MemberDetails) principal;
                HashMap<String,Object> map = new HashMap<>();
                map.put("user",memberDetails.getUmsMember());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
            }
        }
        return super.enhance(accessToken,authentication);
    }
}
