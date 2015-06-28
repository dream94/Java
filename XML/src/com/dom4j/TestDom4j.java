package com.dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ����Dom4j����XML�ĵ�,����XML�ĵ�
 * @author Admin
 *
 */
public class TestDom4j {
	/**
	 * ���xml�ĵ���Document����
	 * @param filepath �ļ�·��
	 * @return
	 */
	public static Document getDocument(String filepath){
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(filepath));   //��ȡ��Ŀ¼�µ�xml�ĵ�
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return document;
	}
	
	public static void testParseXMLData(){
		Document document = getDocument("./src/data.xml");
		Element root = document.getRootElement();      //��ø��ڵ�
		//System.out.println(root.getName());      //����ڵ�����
		StringBuffer str = new StringBuffer();
		for(Iterator iter=root.elementIterator(); iter.hasNext(); ){
			Element element = (Element) iter.next();    //��ýڵ�Ԫ��
			if(element.attribute("id")!=null){
				//System.out.println(element.asXML());   ��xml����ʽ�������ڵ�����ݣ������ӽڵ㣩
				System.out.println(element.getName()+" "+element.attributeValue("id"));
			}else{
				System.out.println(element.getName());
			}
			System.out.println(element.element("name").getText());
			System.out.println(element.elementText("name"));     //Ч���������Ǿ���ͬ   
			System.out.println(element.element("studentid").getText());
			System.out.println(element.element("sex").getText());
		}
	}
	public static void main(String[] args) {
		testParseXMLData();
	}

}
