package com.bmw.news.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUrlConnection {
	
	private static Log log = LogFactory.getLog(HttpUrlConnection.class);
	public static String urlConnection(String methodUrl,String json){
		StringBuffer sb = new StringBuffer("");
		try {
		    //创建连接
		    URL url = new URL(methodUrl);
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setDoOutput(true);
		    connection.setDoInput(true);
		    connection.setRequestMethod("GET");
		    connection.setUseCaches(false);
		    connection.setInstanceFollowRedirects(true);
//		    connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		    connection.setRequestProperty("Content-Type","application/json");
		
		    connection.connect();
		    
		    //POST请求
		    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");  
		    
		    //String img = Base64Img.GetImageStr();
		    out.write(json);
		    out.flush();  
		    out.close();  
		    
		    //读取响应
		    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
		   // log.info("reader=="+reader.toString());
		    String lines;
		    
		    while ((lines = reader.readLine()) != null) {
		    	log.info("linesstart=="+lines);
		        // lines = new String(lines.getBytes(), "utf-8");
		        //log.info("linesend=="+lines);
		        sb.append(lines);
		    }
		    reader.close();
		    // 断开连接
		    connection.disconnect();
		} catch (MalformedURLException e) {
		    
		    e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		    
		    e.printStackTrace();
		} catch (IOException e) {
		    
		    e.printStackTrace();
		}
		return sb.toString();
	}
}

