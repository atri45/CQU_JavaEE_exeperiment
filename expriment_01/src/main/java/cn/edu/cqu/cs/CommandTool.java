package cn.edu.cqu.cs;


import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;
import java.util.Set;

public class CommandTool {
    public static Object getSystemInObject(JSONObject jsonObject, Class clazz){

        Scanner scanner = new Scanner(System.in);
        Set<String> keys = jsonObject.keySet();
        for (String key : keys){
            System.out.print(key + "：");
            String value = scanner.nextLine();
            jsonObject.put(key, value);
        }

        return jsonObject.toJavaObject(clazz);
    }

}
