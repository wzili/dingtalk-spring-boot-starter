package com.wzili.robot;

import com.wzili.DingTalk;
import com.wzili.entity.TextEntity;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wzili
 * @title: DingTalkRoBot
 * @projectName dingtalk-spring-boot-starter
 * @description: 钉钉机器人
 * @date 2019/4/179:29
 */
public class DingTalkRoBot implements DingTalk {

    private OkHttpClient client;

    private String webHook;

    private String accessToken;

    private final String api = "https://oapi.dingtalk.com/robot/send?access_token=";

    public DingTalkRoBot(String webHook, String accessToken){
        this.webHook = webHook;
        this.accessToken = accessToken;
        this.client = new OkHttpClient();
    }

    /**
     * 发送文本消息
     */
    public void sendTextMsg(TextEntity text){
        send(text.toString());
    }

    /**
     * 消息发送实现方法
     */
    private void send(String jsonString){
        try{
            String type = "application/json; charset=utf-8";
            RequestBody body = RequestBody.create(MediaType.parse(type), jsonString);

            String apiUrl = webHook;
            if(null == apiUrl || ("").equals(apiUrl)){
                apiUrl = api + accessToken;
            }
            Request.Builder builder = new Request.Builder().url(apiUrl);
            builder.addHeader("Content-Type", type).post(body);

            Request request = builder.build();
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(String.format("send ding message:%s", string));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
