package com.fsrin.menumine.common.util;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class FileIOUtility {
	
	public static String getDBUpdateDate() {

		
		String filename = getProperty("menumine.rootpath", "") + "config/databaseUpdateDate.txt";
		
		String result = FileIOUtility.getFileLine(filename);
		
		if(result != null) {
			return result;
		}
		return "";
	}
	
	public static void setDBUpdateDate(String date) {

		if(date != null ) {
		
			String filename = getProperty("menumine.rootpath", "") + "config/databaseUpdateDate.txt";
			FileIOUtility.setFileLine(filename,date);
		}
	}
	
	public static boolean isSiteUp() {
		
		
		String filename = getProperty("menumine.rootpath", "") + "config/websiteStatus.txt";
		
		String result = FileIOUtility.getFileLine(filename);
		
		if(result != null) {
			if(result.equals("up") || result.equals("on")) {
				return true;
			}
		}
		
		return true;
	//	return false;
	}
	
	public static String getErrorMessage() {
		
		String filename = getProperty("menumine.rootpath", "") + "config/websiteStatus.txt";
		
		String result = FileIOUtility.getSecondFileLine(filename);
		
		return result;
		
		
		
		
	}

	private static String getFileLine(String filePath){
		
		String fileLine = null;
		
		if(filePath!=null) {
			
			try {
				
				FileInputStream fstream = new FileInputStream(filePath);
	
				// Convert our input stream to a DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				
				if (in.available() !=0) {
					fileLine = in.readLine();
				}
				
				in.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("Error reading from file:\nFile not found.\nFilename: " + filePath);
				System.err.println("trace:"+e.fillInStackTrace());
				java.io.File currentDir = new java.io.File("");
				String dir = currentDir.getAbsolutePath();
				System.err.println("FILE NEEDS TO BE PLACE HERE:  " + dir+ "\\" + filePath);
			} catch (SecurityException e) {
				System.err.println("Error reading from file:\nSecurity error.\nFilename: " + filePath);
			} catch (Exception e) {
				System.err.println("Error reading from file:\nFilename: " + filePath);
			}
		}
		
		
		return fileLine;
	}
	
	private static String getSecondFileLine(String filePath){
		
		String fileLine = null;
		
		if(filePath!=null) {
			
			try {
				
				FileInputStream fstream = new FileInputStream(filePath);
	
				// Convert our input stream to a DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				
				if (in.available() !=0) {
					fileLine = in.readLine();
				}
				if (in.available() !=0) {
					fileLine = in.readLine();
				}

				in.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("Error reading from file:\nFile not found.\nFilename: " + filePath);
			} catch (SecurityException e) {
				System.err.println("Error reading from file:\nSecurity error.\nFilename: " + filePath);
			} catch (Exception e) {
				System.err.println("Error reading from file:\nFilename: " + filePath);
			}
		}

		
		return fileLine;
	}
	
	
	private static void setFileLine(String filePath, String content){
		
		if(filePath != null && content != null) {
			try {
				FileWriter fileWriter = new FileWriter(filePath);
		        BufferedWriter out = new BufferedWriter(fileWriter);
		        out.write(content);
		        out.close();
		    } catch (IOException e) {
		    	System.err.println("Error writing to file:\nFilename: " + filePath);
		    }
		} else {
			if(filePath == null) {
				System.err.println("Error writing to file:\nFile Name is NULL");
			} else {
				System.err.println("Error writing to file:\nContent is NULL");
			}
		}
	}
	
	private static String getProperty(String name, String defaultValue)
	{
		String rc=defaultValue;
		String str;
		
		ResourceBundle bundle = ResourceBundle.getBundle("spring");

		try
		{
			str = bundle.getString(name);
			rc = str;
		}
		catch(Exception e)
		{}
		
		return rc;
	}
}
