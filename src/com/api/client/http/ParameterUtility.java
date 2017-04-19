package com.api.client.http;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

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
    		 jo.put(p.get("name").toString(), p.get("value").toString());
    	 }
    	 
    	 return jo.toString();
    }
	
	public String BuildGetUrl(List<Map> lis, String url)
	{
		return null;
	}
}
