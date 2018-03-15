package com.ldw.familyTree.xmlTest;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParseXML {

	public static void main(String[] args) {
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder dBuilder =dFactory.newDocumentBuilder();
			System.out.println(DOMParseXML.class.getResource("book.xml"));
			Document document = dBuilder.parse(DOMParseXML.class.getResource("book.xml").toString());
			
			//开始解析
			NodeList list = document.getElementsByTagName("book");
			
			System.out.println("书本数量："+list.getLength());
			//遍历book节点的集合
			for(int i=0;i<list.getLength();i++){
				Node book = list.item(i);
				
				//获取book节点的所有属性
				NamedNodeMap nameMap= book.getAttributes();
				
				//遍历book的属性
				for(int n=0;n<nameMap.getLength();n++){
					nameMap.item(n).getNodeName();
					nameMap.item(n).getNodeValue();
					
					System.out.println(nameMap.item(n).getNodeName()+" "+nameMap.item(n).getNodeValue());
					
				}
				
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
