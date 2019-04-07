package TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader

{

	//create private hashtable to read data from json file
	private Hashtable<String,String> jData = new Hashtable<String,String>();

	//create method to read the desired object, keys and testcaseinputs then return a hashtable of (key and value)
	public Hashtable<String,String> JsonReaderData(String jObject, String [] jKeys, String[] testCaseInputs) throws FileNotFoundException, IOException, ParseException {

		//define json file path and read the data from it into a json array
		JSONParser parser = new JSONParser();
		String filePath = System.getProperty("user.dir") + "/src/test/java/TestData/FundData.json";
		File jFile = new File(filePath);
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(jFile));

		//looping on objects of Json array
		for (Object jsonObj : jArray)
		{
			JSONObject jObj = (JSONObject) jsonObj;	

			if (jObj.get(jObject) != null) 
			{
				JSONObject testCasesObj = (JSONObject) jObj.get(jObject);
				//looping on every key and value under each object
				int i;
				int j;
				for ( i = 0; i<jKeys.length;i++)
				{
					for ( j = 0; j<testCaseInputs.length; j++)
					{

						if (jKeys[i] == testCaseInputs[j])
						{
							jData.put(jKeys[i], (String) testCasesObj.get(jKeys[i]));
							break;
						}
					}

				}


			}

		}
		return jData;
	}

}

