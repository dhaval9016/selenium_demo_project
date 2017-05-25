package API_call;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class weatherapi_call 
{
	
	public static void main(String args[])
	{	
		String FILENAME = "D:\\filename.txt";
		
		JSONParser parser = new JSONParser();
		
		
        try
        {
        	
        	
        	//String jsonText = JsonElement 
        	
        	
        	Object obj = parser.parse(new java.io.FileReader(FILENAME));
       
            JSONObject jsonObject = (JSONObject) obj;
            
            
            String name = (String) jsonObject.get("address_components");
 
            System.out.println(name);
            
           // String name = (String) jsonObject.get("results");
           
            /*
            String author  = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            
            while (iterator.hasNext()) 
            {
                System.out.println(iterator.next());
            }
            */
 
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}
