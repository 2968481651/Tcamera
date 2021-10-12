package com.example.tcamera.data;


import java.util.HashMap;

public class Displaydata {
    static HashMap<String,Object> data = new HashMap<>();

    public static void setData(String key, Object value) {
//        data.put("FACE_STATUS", "");
        data.put("point-a", 70);
        data.put("CAMERA", "1");
        data.put(key,value);
    }
    public static Object getData(String key) {
        if (key==""){
            return "";
        }else {
            return data.get(key);//读取后保留
        }
    }
    public static Object remove(String key) {
        return data.remove(key);//读取后删除
    }
}
