package com.api.client.http;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.api.client.globaldefine.GlobalDefine;

public class ParameterUtility 
{
	public ParameterUtility()
	{
		
	}
	
	public String BuildJson(List<Map> lis) throws JSONException 
	{	 
         JSONObject jo = new JSONObject();
    	 for (Map p : lis)
    	 {
    		 if(this.filter_not_parameter(p.get("name").toString()))
    		 {
    			 if((p.get("value").toString()).equals(GlobalDefine.TC_EMPTY))
    			 {
            		 jo.put(p.get("name").toString(), "");
    			 }else
    			 {
            		 jo.put(p.get("name").toString(), p.get("value").toString());
    			 }
    		 }
    	 }
    	 return jo.toString();
    }
	
	public String BuildGetUrl(List<Map> lis, String url)
	{
		StringBuffer buf = new StringBuffer("");
		buf.append(url);
		buf.append("?");
		for(Map p : lis)
		{
			 if(this.filter_not_parameter(p.get("name").toString()))
	   		 {
				if(p.get("value").toString().equals(GlobalDefine.TC_EMPTY))
				{
					buf.append(p.get("name").toString());
					buf.append("=");
					buf.append("");
					buf.append("&");
				}else
				{
					buf.append(p.get("name").toString());
					buf.append("=");
					buf.append(p.get("value").toString());
					buf.append("&");
				}
	   		 }
		}
		String url_temp = buf.toString();
		return url_temp.substring(0, url_temp.length()-1);
	}
	
	private boolean filter_not_parameter(String name)
	{
			switch (name)
			{
				case GlobalDefine.TC_ID:
					return false;
				case GlobalDefine.TC_NAME:
					return false;
				case GlobalDefine.TC_URL:
					return false;
				case GlobalDefine.TC_METHOD:
					return false;
				default:
					return true;
			}
	}
}
