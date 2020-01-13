package com.example.demo.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSOConfig {
    @Value("${cas.server-url-prefix}")
    private String urlPrefix;

    @Value("${cas.client-host-url}")
    private String hostUrl;
    @Bean
    public ServletListenerRegistrationBean signOutListener(){
        return new ServletListenerRegistrationBean(new SingleSignOutHttpSessionListener());
    }
    @Bean
    public FilterRegistrationBean signOutFilter(){
        FilterRegistrationBean outFilterFilterRegistrationBean=new FilterRegistrationBean();
        outFilterFilterRegistrationBean.setOrder(0);
        outFilterFilterRegistrationBean.setFilter(new SingleSignOutFilter());
        outFilterFilterRegistrationBean.addInitParameter("casServerUrlPrefix",urlPrefix);
        outFilterFilterRegistrationBean.addInitParameter("logoutCallbackPath",hostUrl);
        return outFilterFilterRegistrationBean;
    }
}
