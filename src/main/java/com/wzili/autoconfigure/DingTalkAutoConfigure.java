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
 * @author Administrator
 * @title: DingTalkAutoConfigure
 * @projectName dingtalk-spring-boot-starter
 * @description: TODO
 * @date 2019/4/1710:09
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
