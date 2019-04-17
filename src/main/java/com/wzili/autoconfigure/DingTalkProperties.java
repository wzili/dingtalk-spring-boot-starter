package com.wzili.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Administrator
 * @title: DingTalkProperties
 * @projectName dingtalk-spring-boot-starter
 * @description: TODO
 * @date 2019/4/1710:11
 */
@ConfigurationProperties("com.wzili")
@Data
public class DingTalkProperties {

    private String webHook;

    private String accessToken;

}
