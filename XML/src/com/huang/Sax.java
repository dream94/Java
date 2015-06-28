package com.huang;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX����XML�ĵ�
 * @author Admin
 *
 */
class MyHandler extends DefaultHandler{
	//ɨ���ı���ʼ
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	//ɨ�赽Ԫ��
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {          //qName��ʾ�ڵ����ƣ�attributes��ʾ�ڵ�����ֵ
		super.startElement(uri, localName, qName, attributes);
		System.out.println(qName);        //���ÿ���ڵ�����
		String s = attributes.getValue("ѧ���ƺ�");
		if (s != null) {
			System.out.println("ѧ���ƺ�:" + s);
		}

	}
	//ɨ�赽�ı�ʱ��Ԫ��ֵʱ�������յ�,��root��student�ȣ�
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if(!str.trim().equals("")){       //xml�ĵ����кܶ�ڵ��ֵ�ǿյ�,��student
			System.out.println("����:"+str);
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	
	
}
public class Sax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory saxpf = SAXParserFactory.newInstance();
		SAXParser saxp;
		try {
			saxp = saxpf.newSAXParser();
			//��ɨ�������¼������
			saxp.parse("./src/data.xml", new MyHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}
}
