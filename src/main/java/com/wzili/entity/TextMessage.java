package com.wzili.entity;

import com.alibaba.fastjson.JSONObject;
import com.wzili.common.utils.DingTalkUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * dingTalk-spring-boot-starter
 * https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq#-4
 * @author : wzili
 * Date: 2019/4/17 10:09
 */
@Data
public class TextMessage {

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

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("at", DingTalkUtils.setAtAllAndMobile(this.getAtMobiles(),this.getIsAtAll()));
        json.put("text", content);
        return json.toJSONString();
    }
}
