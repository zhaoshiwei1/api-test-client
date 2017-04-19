package com.api.client.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class HttpUtility 
{
	public HttpUtility()
	{
		
	}
	
	public StringBuffer Post_Util(String js, String base_url, String url)
	{
		StringBuffer buffer=new StringBuffer();
		try{
				URL serverUrl= new URL(base_url+url);
				URLConnection uct= serverUrl.openConnection();
				HttpURLConnection hutc=(HttpURLConnection)uct;	
				// ���ñ��Ĳ���
				hutc.setRequestMethod("POST");
				// �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ���� http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false; 
				hutc.setDoOutput(true);
				// �����Ƿ��httpUrlConnection���룬Ĭ���������true
				hutc.setDoInput(true);
				hutc.setUseCaches(false);
		        hutc.setInstanceFollowRedirects(true);
		        hutc.setRequestProperty("Content-Type","application/json");
				//hutc.setAllowUserInteraction(true);
			
				// ��������д������data
				OutputStream out=hutc.getOutputStream();
				
				out.write(js.getBytes("UTF-8"));
				out.flush();
				out.close();
				
				//���´���Ϊ��ȡ�������ݣ� ��ʱע��
				// ��ȡ���ص�����	

				BufferedReader reader = null;
				InputStream ins=hutc.getInputStream();
				reader = new BufferedReader(new InputStreamReader(ins,"UTF-8"));
				String sg=reader.readLine();
				if (sg!= null)
				{
			           buffer.append(sg);
			    }
				//System.out.println("���շ���ֵ:" + buffer+ "\n");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return buffer;
	}
	
	public StringBuffer Get_Util(String url)
	{
		return null;
	}
}