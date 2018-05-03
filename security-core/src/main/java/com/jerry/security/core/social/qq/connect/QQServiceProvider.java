package com.jerry.security.core.social.qq.connect;

import com.jerry.security.core.social.qq.api.QQ;
import com.jerry.security.core.social.qq.api.impl.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/5/3
 * Time: 17:20
 * Description: 继承的AbstractOAuth2ServiceProvider需要泛型是获取QQ用户信息的接口
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    /**
     * 对应流程中第1步的操作
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    /**
     * 对应流程中第4步的操作
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    private String appId;

    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
