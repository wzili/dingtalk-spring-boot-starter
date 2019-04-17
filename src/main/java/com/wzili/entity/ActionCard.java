package com.wzili.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq#-7
 *
 * @author : wzili
 * Date:  2019/4/17 19:16
 */

@Data
public class ActionCard {

    private String msgType = "actionCard";

    // 显示标题
    private String title;

    // 显示内容 markdown格式的消息
    private String content;

    // 0-正常发消息者头像，1-隐藏发消息者头像
    private String hideAvatar;

    // 0-按钮竖直排列，1-按钮横向排列
    private String btnOrientation;

    // 单个按钮的方案。(设置此项和singleURL后btns无效)
    private String singleTitle;

    // 点击singleTitle按钮触发的URL
    private String singleURL;

    private List<ActionCardButton> btns;

    public String toString() {
        // text类型
        JSONObject actionCardContent = new JSONObject();
        actionCardContent.put("title", this.getTitle());
        actionCardContent.put("text", this.getContent());
        actionCardContent.put("hideAvatar", this.getHideAvatar());
        actionCardContent.put("btnOrientation", this.getBtnOrientation());
        if(!StringUtils.isEmpty(this.getSingleTitle()) && !StringUtils.isEmpty(this.getSingleURL())){
            actionCardContent.put("singleTitle", this.getSingleTitle());
            actionCardContent.put("singleURL", this.getSingleURL());
        }else{
            List<ActionCardButton> btns = new ArrayList<ActionCardButton>();
            for (int i=0;i<this.getBtns().size();i++){
                btns.add(this.getBtns().get(i));
            }
            if(this.getBtns().size()>0){
                actionCardContent.put("btns", btns);
            }
        }

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("actionCard", actionCardContent);

        return json.toJSONString();
    }

}
