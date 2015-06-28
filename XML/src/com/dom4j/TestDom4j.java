package com.dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 测试Dom4j解析XML文档,遍历XML文档
 * @author Admin
 *
 */
public class TestDom4j {
	/**
	 * 获得xml文档的Document对象
	 * @param filepath 文件路径
	 * @return
	 */
	public static Document getDocument(String filepath){
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(filepath));   //读取该目录下的xml文档
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return document;
	}
	
	public static void testParseXMLData(){
		Document document = getDocument("./src/data.xml");
		Element root = document.getRootElement();      //获得根节点
		//System.out.println(root.getName());      //输出节点名称
		StringBuffer str = new StringBuffer();
		for(Iterator iter=root.elementIterator(); iter.hasNext(); ){
			Element element = (Element) iter.next();    //获得节点元素
			if(element.attribute("id")!=null){
				//System.out.println(element.asXML());   以xml的形式输出这个节点的内容（包括子节点）
				System.out.println(element.getName()+" "+element.attributeValue("id"));
			}else{
				System.out.println(element.getName());
			}
			System.out.println(element.element("name").getText());
			System.out.println(element.elementText("name"));     //效果和上面那句相同   
			System.out.println(element.element("studentid").getText());
			System.out.println(element.element("sex").getText());
		}
	}
	public static void main(String[] args) {
		testParseXMLData();
	}

}
