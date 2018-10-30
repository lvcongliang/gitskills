package com.imooc.security.browser;

import com.imooc.security.browser.support.SimpleResponse;
import com.imooc.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LvCongLiang on 2018/10/28.
 */
@RestController
public class BrowserSecurityController {
    private Logger logger= LoggerFactory.getLogger(getClass());
    private RequestCache requestCache=new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("/authentication/require")
    @ResponseStatus(code= HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest requestServlet, HttpServletResponse responseServlet) throws IOException {
        SavedRequest savedRequest=requestCache.getRequest(requestServlet,responseServlet);
        if(savedRequest!=null){
            String targetUrl=savedRequest.getRedirectUrl();
            logger.info("targetUrl:"+targetUrl);
            if(StringUtils.endsWithIgnoreCase(targetUrl,".html")){
                redirectStrategy.sendRedirect(requestServlet,responseServlet,securityProperties.getBrowser().getLoginPage());
            }

        }
        return new SimpleResponse("返回的服务需要身份认证，请返回到服务页");

    }
}
