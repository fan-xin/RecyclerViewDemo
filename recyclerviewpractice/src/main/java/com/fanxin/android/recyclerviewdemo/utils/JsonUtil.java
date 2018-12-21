package com.fanxin.android.recyclerviewdemo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

import java.lang.reflect.Type;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/19  15:02
 */
public class JsonUtil {
    private static Gson gson = new Gson();
    //构造函数
    private JsonUtil(){

    }

    public static String toJson(Object src){
        if (src == null){
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }

    public static <T>Object fromJson(String json, Class<T>classOfT){
        return gson.fromJson(json,(Type)classOfT);
    }

}
