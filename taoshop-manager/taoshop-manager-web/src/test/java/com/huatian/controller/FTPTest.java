package com.huatian.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {
	
	@Test
	public void testFtpClient() 
	{
		//创建一个FTPClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接  默认端口21
		try {
			ftpClient.connect("192.168.226.128",21);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//登录ftp服务，使用用户名和密码
		try {
			ftpClient.login("ftpuser", "ftpuser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//读取本地文件
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("F:\\BOOK\\psu.jpg"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//设置上传的路径
		try {
			ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//修改上传文件的格式
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//上传文件
		//第一个参数：服务端文件名
		//第二个参数：上传文档的inputStream
		try {
			ftpClient.storeFile("hello.jpg", inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭连接
		try {
			ftpClient.logout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("e");
		
//		<dependency>
//		<groupId>commons-net</groupId>
//		<artifactId>commons-net</artifactId>
//		3.3
//	</dependency>
	}

}
