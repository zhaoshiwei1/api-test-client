package com.api.client.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.api.client.db.DataBaseUtility;
import com.api.client.globaldefine.GlobalDefine;
import com.api.client.http.HttpRun;

public class Hello 
{
	public static void main(String[] args)
	{
		HttpRun hr = new HttpRun();
		List<List<Map>> l = new ArrayList();
		System.out.print("Hello world!"+"\n");
		DataBaseUtility dbu = new DataBaseUtility(GlobalDefine.DB_PATH);
		l = dbu.getData(GlobalDefine.TC_TABLE);
		for (List m : l)
		{
			System.out.print(m.toString()+"\n");
			System.out.print(hr.run(m).toString()+"\n");
		}
	}
}
