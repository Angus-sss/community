package com.insedesign.community.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;


/**
 * @author: NALHOUG
 * @time: 2019/10/31 15:31
 * @explain: json解析工具类
 * 1. 用于获取redis数据
 */
public class JsonUtils {
	
	public static Logger log = Logger.getLogger(JsonUtils.class);

	/**
	 * 把对象转换为json数据
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj){
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
			try {
				String json = gson.toJson(obj);
				return json;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	/**
	 * 把json字符串转化为对象
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static Object jsonToObject(String jsonString, Class<?> clazz) {
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Object obj = null;
		try {
			obj = gson.fromJson(jsonString, clazz);
		} catch (JsonSyntaxException e) {
			
			e.printStackTrace();
		}
		return obj;
	}
	
	/**

	 * 2018年5月7日  下午5:49:18
	 * @param jsonArray
	 * @return
	 */
	public static ArrayList<?> jsonArrayToArrayList(String jsonArray) {
				
		Gson gson = new GsonBuilder()
	            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
	            .setDateFormat("yyyy-MM-dd HH:mm:ss")
	            .serializeNulls()
	            .create();
		ArrayList<?> list = null;
		try {
			Type listType = new TypeToken<ArrayList<?>>() {}.getType();
			
			list = gson.fromJson(jsonArray, listType);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * JSON 转 ArrayList
	 * @param jsonArray
	 * @param clazz
	 * @return
	 */
	public static ArrayList<?> jsonArrayToArrayList(String jsonArray, Class<?> clazz) {
		
		Gson gson = new GsonBuilder()
	            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
	            .setDateFormat("yyyy-MM-dd HH:mm:ss")
	            .serializeNulls()
	            .create();
		ArrayList<?> list = null;
		try {
		
			list = (ArrayList<?>) gson.fromJson(jsonArray, clazz);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 把json转换为map类型的数据
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String json) {
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Map<String, Object> map = null;
		try {
			Type type=new TypeToken<Map<String,Object>>(){}.getType();
			
			map = gson.fromJson(json, type);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
