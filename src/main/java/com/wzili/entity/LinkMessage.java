package com.wzili.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;


/**
 * dingTalk-spring-boot-starter
 * https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq#-5
 * @author : wzili
 * Date: 2019/4/19:10
 *
 */
@Data
public class LinkMessage {

    private String msgType = "link";

    // 显示标题
    private String title;

    // 显示内容
    private String content;

    // icon url
    private String picUrl;

    // 内容对链接
    private String messageUrl;

    public String toString() {
        // text类型
        JSONObject linkContent = new JSONObject();
        linkContent.put("title", this.getTitle());
        linkContent.put("text", this.getContent());
        linkContent.put("picUrl", this.getPicUrl());
        linkContent.put("messageUrl", this.getMessageUrl());

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("link", linkContent);
        return json.toJSONString();
    }


}
