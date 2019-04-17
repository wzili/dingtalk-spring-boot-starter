package com.wzili.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq#-8
 * @author : wzili
 * Date:  2019/4/17 19:21
 */
@Data
public class FeedCard {

    private String msgType =  "feedCard";


    // links
    private List<FeedCardLink> links;

    public String toString() {

        // text类型
        JSONObject feedCardContent = new JSONObject();
        List<FeedCardLink> links = new ArrayList<FeedCardLink>();
        for (int i=0;i<this.getLinks().size();i++){
            links.add(this.getLinks().get(i));
        }
        if(this.getLinks().size()>0){
            feedCardContent.put("links", links);
        }

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("feedCard", feedCardContent);

        return json.toJSONString();
    }

}
