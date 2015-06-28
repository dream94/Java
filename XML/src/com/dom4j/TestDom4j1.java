package com.dom4j;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestDom4j1 {
	/**
	 * 获得自己创建的document对象
	 * @return
	 */
	public static Document getDocument(){
		Document document = DocumentHelper.createDocument();
		document.addElement("student");
		return document;
	}
	
	public static void testDom4j(){
		Document document = getDocument();
		Element root = document.getRootElement();
		Element e1 = root.addElement("id");
		e1.setText("号码");
		e1.addAttribute("other", "你好");
		try {
			/*
			XMLWriter writer;
			writer = new XMLWriter(new  FileWriter("./src/test1.xml"));    //将document写入xml文件中
			writer.write(document);
			writer.flush();
		    writer.close();*/
			
			//处理中文情况
			OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式                  
		    format.setEncoding("UTF-8");//设置编码
		    XMLWriter writer = new XMLWriter(new FileOutputStream("./src/test1.xml"),format);
		    writer.write(document);
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public static void main(String[] args) {
		testDom4j();
	}

}
