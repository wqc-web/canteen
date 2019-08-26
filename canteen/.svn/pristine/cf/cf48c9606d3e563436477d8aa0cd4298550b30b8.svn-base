package com.zhongzhou.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessToken {
	
	private static Date lnTime;
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static String access_token_ln;
	
	private static ObjectMapper jsonMapper=new ObjectMapper();
	
	//���access_token
	public static String getAccessToken(){
		Date nowDate=new Date();
		if (lnTime == null || (nowDate.getTime() - lnTime.getTime()) > 1000 * 60 * 60) {
			lnTime = new Date();
			access_token_ln=getAT("wx50039c6fbc9c811f","AQvzDuWnOeAV8DfmccOecC2J2ohbcfFKnVOSFOGyB38");
		}
		return access_token_ln;	
	}	
	public static String getAccessToken(String corporateid,String secret){
		Date nowDate=new Date();
		if (lnTime == null || (nowDate.getTime() - lnTime.getTime()) > 1000 * 60 * 60) {
			lnTime = new Date();
			access_token_ln=getAT(corporateid,secret);
		}
		return access_token_ln;	
	}	
	
	// ��ȡ��Ա��Ϣ
	public static String getAT(String appID, String appScret) {
				
		// ����΢�ŷ�����
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + appID + "&corpsecret=" + appScret;
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b,"UTF-8");
			JsonNode jn=jsonMapper.readTree(message);
			String access_token=jn.get("access_token").asText();
			return access_token;      //����access_token
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static boolean send_text_msg(String touser, String content){
        // 拼接请求地址
        /*String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + getAccessToken("wx50039c6fbc9c811f","9wyRIqI0YcJlYLmrrKN94E8DEOdAiewcmTIDsdHiRPo");
        String postJson = "{\"touser\": \"%s\",\"agentid\":%s,\"msgtype\": \"%s\",\"text\":{\"content\": \"%s\"},\"safe\":0}";
        String outputStr = String.format(postJson, touser, 1000024, "text",content);
        JsonNode node = HttpRequestUtils.sendPost(requestUrl, outputStr);
        if(Integer.parseInt(node.get("errcode").toString())==0){
            return true;
        }*/
        return false;
    }
	
	
	/*public static void main(String[] args) {
		send_text_msg("17712802520","测试");
	}*/
	
	
	
}
