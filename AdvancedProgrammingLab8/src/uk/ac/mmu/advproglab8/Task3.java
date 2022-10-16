package uk.ac.mmu.advproglab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Task3 {

	public static void main(String[] args) {

		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("w:/eclipse_2021/myworkspace/AdvancedProgrammingLab8/library/library.json"));
			String json = ""; String line = "";
			while((line = br.readLine()) !=null) { json = json + line; }
			System.out.println("Books in Library");
			
			JSONArray root = new JSONArray(json);
			for(int i=0;i<root.length();i++) {
				JSONObject book = root.getJSONObject(i);
				if (book.getString("title").equals("XML in a Nutshell")) {
					System.out.println(book.getString("title"));
					JSONArray authors = book.getJSONArray("authors");
					for(int j=0;j<authors.length();j++) {
						JSONObject author =  authors.getJSONObject(j);
						System.out.println(author.getString("forename") + " " +  author.getString("surname"));
					}
				}
			}
		}
		
		catch (IOException | JSONException e) {
			System.err.println("Problem Parsing JSON file: " + e);
		}
	}

}
