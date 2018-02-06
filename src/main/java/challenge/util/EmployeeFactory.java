package challenge.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import challenge.domain.Employee;

public class EmployeeFactory {
	public static Employee build() throws Exception {
		URL url = new URL("https://randomuser.me/api/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		JSONObject jsonObj = new JSONObject(content.toString());
		JSONArray results = (JSONArray)jsonObj.get("results");
		
		JSONObject result = (JSONObject)results.get(0);
		
		JSONObject name = (JSONObject)result.get("name");
		
		String firstName = name.getString("first");
		String lastName = name.getString("last");

		String email = result.getString("email");
		String gender = result.getString("gender");

		JSONObject info = (JSONObject)jsonObj.get("info");
		String seed = info.getString("seed");
		
		Employee newEmployee = new Employee(firstName + " " + lastName, gender, email, null, null, seed);
		
		con.disconnect();
		
		return newEmployee;
	}
}
