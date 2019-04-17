package com.wzili.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: TextEntity
 * @projectName dingtalk-spring-boot-starter
 * @description: 文本消息实体类
 * @date 2019/4/179:35
 */
@Data
public class TextEntity {

    private String msgType = "text";

    // 显示内容
    private String content;

    // 是否at所有人
    private Boolean isAtAll;

    // 被@人的手机号(在content里添加@人的手机号)
    private List<String> atMobiles;

    public String toString() {
        // text类型
        JSONObject content = new JSONObject();
        content.put("content", this.getContent());

        // at some body
        JSONObject atMobile = new JSONObject();
        if(this.getAtMobiles().size() > 0){
            List<String> mobiles = new ArrayList<String>();
            for (int i=0;i<this.getAtMobiles().size();i++){
                mobiles.add(this.getAtMobiles().get(i));
            }
            if(mobiles.size()>0){
                atMobile.put("atMobiles", mobiles);
            }
            atMobile.put("isAtAll", this.getIsAtAll());
        }

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("text", content);
        json.put("at", atMobile);
        return json.toJSONString();
    }
}
