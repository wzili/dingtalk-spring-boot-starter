package com.wzili.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : wzili
 * Date:  2019/4/17 19:44
 */

@UtilityClass
public class DingTalkUtils {

    public JSONObject setAtAllAndMobile(List<String> atMobiles, Boolean isAtAll){
        JSONObject atMobile = new JSONObject();
        if(atMobiles.size() > 0){
            List<String> mobiles = new ArrayList<String>();
            for (int i=0;i<atMobiles.size();i++){
                mobiles.add(atMobiles.get(i));
            }
            if(mobiles.size()>0){
                atMobile.put("atMobiles", mobiles);
            }
            atMobile.put("isAtAll", isAtAll);
        }

        return atMobile;
    }
}
