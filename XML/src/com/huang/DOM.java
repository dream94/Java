package com.huang;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//测试DOM在XML文件上的CURD操作
//在XML中换行和标签中的内容在遍历过程中若不加判断则会输出#text


public class DOM {

	public static void main(String[] args) {
	
		//获取抽象类的实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse("./src/data.xml");
			
			//遍历XML表中的内容
			list(document);
			
			//查询XML表中第一个Student的姓名
			//find(document);
			
			//在XML表中插入一个学生的信息
			//add(document);
			
			//在XML表中修改属性和元素值
			//update(document);
			
			//在XML表中删除一个学生或者属性 
			//del(document);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	// 遍历xml中所有元素
	// 在XML中换行和标签中的内容在遍历过程中若不加判断则会输出#text
	public static void list(Node node) {
		if (node.getNodeType() == node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		NodeList nodelist = node.getChildNodes();

		for (int t = 0; t < nodelist.getLength(); ++t) {
			Node n = nodelist.item(t);
			list(n);
		}
		return;
	}
		
	//在XML表中删除一个学生或者属性
	public static void del(Document document) throws TransformerException{
		Element node = (Element)document.getElementsByTagName("student").item(0);
		//移除属性
		node.removeAttribute("id");
		
		//移除元素
		Element name = (Element) node.getElementsByTagName("name").item(0);
		node.removeChild(name);
		
		//获得父亲结点
		//Node parentnode = node.getParentNode();
		//parentnode.removeChild(node);
		
		//写入文件XML中
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		
	}
	
	
	
	//在XML表中修改一个学生的信息
	public static void update(Document document){
		try{
			Element stuName = (Element) document.getElementsByTagName("name").item(0);
			stuName.setTextContent("zhang");
			stuName.setAttribute("小名", "zhangsan");
			
			//写入文件XML中
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//在XML表中插入一个学生的信息
	public static void add(Document document){
		try{
			Element stu = document.createElement("student");
			//添加属性
			stu.setAttribute("学生称号", "tiger");
			Element name = document.createElement("name");
			name.setTextContent("Ben");
			Element studentid = document.createElement("studentid");
			studentid.setTextContent("123321");
			Element sex = document.createElement("sex");
			sex.setTextContent("男");
			
			stu.appendChild(name);
			stu.appendChild(studentid);
			stu.appendChild(sex);
			
			//在根节点后面添加元素
			document.getDocumentElement().appendChild(stu);
			
			//写入文件XML中
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	//查询XML表中第一个student的姓名
	public static void find(Document document){
		NodeList nodelist = document.getElementsByTagName("student");
		//类型强制转换转换成子类Element类型
		Element stu = (Element)nodelist.item(0);
		//获得属性值
		System.out.println("id : "+ stu.getAttribute("id"));
		NodeList name = stu.getElementsByTagName("name");
		Element firstname = (Element)name.item(0);
		//获得元素值
		System.out.println("name : " + firstname.getTextContent());		
	}
	
	
	
	
	
	

}
