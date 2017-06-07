package com.cain.bos.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ResultUtils {

	public static void toJson(HttpServletResponse response, Object data) throws IOException {  
	   
	        JSONArray fromObject = JSONArray.fromObject(data);
	        String result = fromObject.toString();
	          
	        response.setContentType("text/json; charset=utf-8");  
	        response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存  
	        PrintWriter out = response.getWriter();  
	        out.print(result);  
	        out.flush();  
	        out.close();  
	    }  
}
