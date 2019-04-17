# dingtalk-spring-boot-starter

### Spring Boot Dependency
> Maven 
```
<dependency>
    <groupId>com.wzili</groupId>
    <artifactId>dingtalk-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Spring Boot Config
> Easy Config
```
com:
  wzili:
    enabled: true
    access-token: # // DingTalk Robot Access_Token
```

### Spring Boot Use
> Easy Use
```
    @Resource
    DingTalkRoBot dingTalkRoBot;
    
    // Funtion 
    TextMessage text = new TextMessage();
    text.setContent("Content");
    text.setIsAtAll(false);
    text.setAtMobiles(Arrays.asList("139*"));
    dingTalkRoBot.sendTextMsg(text);
```