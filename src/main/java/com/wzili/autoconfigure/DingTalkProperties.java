package com.wzili.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DingTalk-spring-boot-starter
 * @author : wzili
 * Date: 2019/4/17 10:09
 */
@ConfigurationProperties("com.wzili")
@Data
public class DingTalkProperties {

    private String webHook;

    private String accessToken;

}
