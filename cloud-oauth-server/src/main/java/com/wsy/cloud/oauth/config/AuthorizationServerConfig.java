package com.wsy.cloud.oauth.config;

import com.wsy.cloud.oauth.service.UserService;
import com.wsy.cloud.oauth.util.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.*;

/**
 * 认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
     @Autowired
     private PasswordEncoder passwordEncoder;
     @Autowired
     private AuthenticationManager authenticationManager;
     @Autowired
     private UserService userService;
     @Autowired
     @Qualifier("redisTokenStore")
     //@Qualifier("jwtTokenStore")
     private TokenStore tokenStore;
     @Autowired
     private JwtAccessTokenConverter jwtAccessTokenConverter;
     @Autowired
     private JwtTokenEnhancer jwtTokenEnhancer;
    /**
     * 使用密码模式需要配置
     */
    @Override
     public void configure(AuthorizationServerEndpointsConfigurer endpoints){
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer); //配置JWT的内容增强器
        delegates.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)//可使用使用mysql存储
                .tokenStore(tokenStore)//配置令牌存储策略
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(enhancerChain);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()//认证方式, 只是admin和secret的获取方式
                .withClient("admin")//配置client_id
                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
                .accessTokenValiditySeconds(3600)//配置访问token的有效期
                .refreshTokenValiditySeconds(86400)//配置刷新token的有效期
                .autoApprove(true) //自动授权配置
                .redirectUris("http://localhost:9501/login")//配置redirect_uri，用于授权成功后跳转
                .scopes("all")//配置申请的权限范围
                .authorizedGrantTypes("authorization_code","password","refresh_token");//配置grant_type，表示授权类型
    }
    public void configure(AuthorizationServerSecurityConfigurer security){
        security.tokenKeyAccess("isAuthenticated()");//// 获取密钥需要身份认证，使用单点登录时必须配置
    }
}
/**
public final class AuthorizationServerEndpointsConfigurer {
    private AuthorizationServerTokenServices tokenServices;
    private ConsumerTokenServices consumerTokenServices;
    private AuthorizationCodeServices authorizationCodeServices;
    private ResourceServerTokenServices resourceTokenServices;
    private TokenStore tokenStore;
    private TokenEnhancer tokenEnhancer;
    private AccessTokenConverter accessTokenConverter;
    private ApprovalStore approvalStore;
    private TokenGranter tokenGranter;
    private OAuth2RequestFactory requestFactory;
    private OAuth2RequestValidator requestValidator;
    private UserApprovalHandler userApprovalHandler;
    private AuthenticationManager authenticationManager;
    private ClientDetailsService clientDetailsService;//配置客户端详情服务
    private String prefix;
    private Map<String, String> patternMap = new HashMap();
    private Set<HttpMethod> allowedTokenEndpointRequestMethods = new HashSet();
    private FrameworkEndpointHandlerMapping frameworkEndpointHandlerMapping;
    private boolean approvalStoreDisabled;
    private List<Object> interceptors = new ArrayList();
    private DefaultTokenServices defaultTokenServices;
    private UserDetailsService userDetailsService;
    private boolean tokenServicesOverride = false;
    private boolean userDetailsServiceOverride = false;
    private boolean reuseRefreshToken = true;
    private WebResponseExceptionTranslator<OAuth2Exception> exceptionTranslator;
    private RedirectResolver redirectResolver;
}
*/