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
 * SAX解析XML文档
 * @author Admin
 *
 */
class MyHandler extends DefaultHandler{
	//扫描文本开始
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	//扫描到元素
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {          //qName表示节点名称，attributes表示节点属性值
		super.startElement(uri, localName, qName, attributes);
		System.out.println(qName);        //输出每个节点名称
		String s = attributes.getValue("学生称号");
		if (s != null) {
			System.out.println("学生称号:" + s);
		}

	}
	//扫描到文本时，元素值时（包括空的,如root，student等）
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if(!str.trim().equals("")){       //xml文档中有很多节点的值是空的,如student
			System.out.println("内容:"+str);
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
			//将扫描仪与事件处理绑定
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
