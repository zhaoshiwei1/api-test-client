package com.api.client.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class log
{

	public static void out_to_file(String File_Path, StringBuffer buffer) {
			try {  
	            File newFile = new File(File_Path);  
	            if (newFile.exists())// ���ڣ���ɾ��  
	                if (!newFile.delete())// ɾ���ɹ��򴴽�  
	                {  
	                    System.out.print("ɾ���ļ�" + newFile + "ʧ��");  
	                }  
	            if (newFile.createNewFile()) {// �����ɹ�����д���ļ�����  
	                PrintWriter p = new PrintWriter(new FileOutputStream(newFile  
	                        .getAbsolutePath()));  
	                p.write(buffer.toString());  
	                p.close();  
	            } else {  
	                System.out.print("�����ļ���" + newFile + "ʧ��");  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
    }  
}
