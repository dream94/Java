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

//����DOM��XML�ļ��ϵ�CURD����
//��XML�л��кͱ�ǩ�е������ڱ����������������ж�������#text


public class DOM {

	public static void main(String[] args) {
	
		//��ȡ�������ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse("./src/data.xml");
			
			//����XML���е�����
			list(document);
			
			//��ѯXML���е�һ��Student������
			//find(document);
			
			//��XML���в���һ��ѧ������Ϣ
			//add(document);
			
			//��XML�����޸����Ժ�Ԫ��ֵ
			//update(document);
			
			//��XML����ɾ��һ��ѧ���������� 
			//del(document);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	// ����xml������Ԫ��
	// ��XML�л��кͱ�ǩ�е������ڱ����������������ж�������#text
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
		
	//��XML����ɾ��һ��ѧ����������
	public static void del(Document document) throws TransformerException{
		Element node = (Element)document.getElementsByTagName("student").item(0);
		//�Ƴ�����
		node.removeAttribute("id");
		
		//�Ƴ�Ԫ��
		Element name = (Element) node.getElementsByTagName("name").item(0);
		node.removeChild(name);
		
		//��ø��׽��
		//Node parentnode = node.getParentNode();
		//parentnode.removeChild(node);
		
		//д���ļ�XML��
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		
	}
	
	
	
	//��XML�����޸�һ��ѧ������Ϣ
	public static void update(Document document){
		try{
			Element stuName = (Element) document.getElementsByTagName("name").item(0);
			stuName.setTextContent("zhang");
			stuName.setAttribute("С��", "zhangsan");
			
			//д���ļ�XML��
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//��XML���в���һ��ѧ������Ϣ
	public static void add(Document document){
		try{
			Element stu = document.createElement("student");
			//�������
			stu.setAttribute("ѧ���ƺ�", "tiger");
			Element name = document.createElement("name");
			name.setTextContent("Ben");
			Element studentid = document.createElement("studentid");
			studentid.setTextContent("123321");
			Element sex = document.createElement("sex");
			sex.setTextContent("��");
			
			stu.appendChild(name);
			stu.appendChild(studentid);
			stu.appendChild(sex);
			
			//�ڸ��ڵ�������Ԫ��
			document.getDocumentElement().appendChild(stu);
			
			//д���ļ�XML��
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult("src/data.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	//��ѯXML���е�һ��student������
	public static void find(Document document){
		NodeList nodelist = document.getElementsByTagName("student");
		//����ǿ��ת��ת��������Element����
		Element stu = (Element)nodelist.item(0);
		//�������ֵ
		System.out.println("id : "+ stu.getAttribute("id"));
		NodeList name = stu.getElementsByTagName("name");
		Element firstname = (Element)name.item(0);
		//���Ԫ��ֵ
		System.out.println("name : " + firstname.getTextContent());		
	}
	
	
	
	
	
	

}
