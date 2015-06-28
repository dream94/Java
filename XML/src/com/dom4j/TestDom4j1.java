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
	 * ����Լ�������document����
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
		e1.setText("����");
		e1.addAttribute("other", "���");
		try {
			/*
			XMLWriter writer;
			writer = new XMLWriter(new  FileWriter("./src/test1.xml"));    //��documentд��xml�ļ���
			writer.write(document);
			writer.flush();
		    writer.close();*/
			
			//�����������
			OutputFormat format = OutputFormat.createPrettyPrint();// �����ļ������ʱ���Զ������ĸ�ʽ                  
		    format.setEncoding("UTF-8");//���ñ���
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
