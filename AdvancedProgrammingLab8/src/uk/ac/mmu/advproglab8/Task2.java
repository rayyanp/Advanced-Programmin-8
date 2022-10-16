package uk.ac.mmu.advproglab8;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

public class Task2 {

	public static void main(String[] args) {
		
		try {
			
			DocumentBuilder db = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
			Document doc = db.parse("w:/eclipse_2021/myworkspace/AdvancedProgrammingLab8/library/library.xml");
			System.out.println("Books in Library");
			
			Element root = doc.getDocumentElement();
			NodeList titleNodes = root.getElementsByTagName("title");
		
			for(int i=0;i<titleNodes.getLength();i++) {
				if (titleNodes.item(i).getTextContent().equals("XML in a Nutshell")) {
					System.out.println(titleNodes.item(i).getTextContent());
					printAuthors((Element) titleNodes.item(i).getParentNode());
				}
			}
		
		}
		
		catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println("Error opening XML file: " + e);
		}

	}
	
	public static void printAuthors(Element book) {
		NodeList authors = book.getElementsByTagName("author");
		for(int i=0;i<authors.getLength();i++) {
			Element author = (Element) authors.item(i);
			String surname = author.getElementsByTagName("surname").item(0).getTextContent();
			String forename = author.getElementsByTagName("forename").item(0).getTextContent();
			System.out.println(forename + " " + surname);
		}
	}

}
