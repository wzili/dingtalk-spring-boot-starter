package com.wzili.autoconfigure;

import com.wzili.robot.DingTalkRoBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DingTalk-spring-boot-starter
 * @author : wzili
 * Date: 2019/4/17 10:09
 */
@Configuration
@ConditionalOnClass(DingTalkRoBot.class)
@EnableConfigurationProperties(DingTalkProperties.class)
public class DingTalkAutoConfigure {
    @Autowired
    private DingTalkProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "com.wzili",value = "enabled", havingValue = "true")
    DingTalkRoBot dingTalkRoBot (){
        return  new DingTalkRoBot(properties.getWebHook(), properties.getAccessToken());
    }
}
