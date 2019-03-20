package TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader

{

	public String UserName, UserPass;

	JSONParser parser = new JSONParser();

	public void JsonReaderData() throws FileNotFoundException, IOException, ParseException {

		String filePath = System.getProperty("user.dir") + "/src/test/java/TestData/FundData.json";
		File jFile = new File(filePath);
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(jFile));
				
		for (Object jsonObj : jArray) {

					JSONObject jObj = (JSONObject) jsonObj;
				
					if (jObj.get("UserName") != null) 
					{
						UserName = (String) jObj.get("UserName");
						System.out.println(UserName);
						UserPass = (String) jObj.get("UserPass");
						System.out.println(UserPass);
					}
					
		
	}

}

}
