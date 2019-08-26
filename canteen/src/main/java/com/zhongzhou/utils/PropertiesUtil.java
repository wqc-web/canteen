package com.zhongzhou.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author Administrator
 *  读取properties文件
 */
public class PropertiesUtil {

	public PropertiesUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static Properties p;
	
	public static String ftp_properies = "ftp.properties";
	public static String consts_properties = "consts.properties";
	
	/**
	 * 加载properties文件
	 * @param proName
	 */
	public static void load(String proName) {
		InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(proName);
		 p = new Properties();
		 try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 传递key 读取value
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getValue(String key){
		try {
			//Properties 默认是按ISO-8859-1读取的
			return new String( p.getProperty(key).getBytes("ISO-8859-1"),"UTF-8" );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return  null;
	}
	
}
