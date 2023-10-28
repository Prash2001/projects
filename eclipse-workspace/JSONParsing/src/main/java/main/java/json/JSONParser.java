package main.java.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/Users/prashantjapkar/2022-q3/prashant-japkar/training/student.json"));
			StringBuilder sbuilder = new StringBuilder();
			String line;
			while((line=reader.readLine())!=null) {
				sbuilder.append(line);
			}
			JSONObject jobj = new JSONObject(sbuilder.toString());
			JSONArray jarray = jobj.getJSONArray("student");
			for(int i=0;i<jarray.length();i++) {
				System.out.println("Student Information");
				System.out.println("==============");
				String name = jarray.getJSONObject(i).getString("name");
				System.out.println("Name : "+name);
				int age = jarray.getJSONObject(i).getInt("age");
				System.out.println("Age : "+age);
				boolean isMindstixEmployee = jarray.getJSONObject(i).getBoolean("isMindstixEmployee");
				System.out.println("isMindstixEmployee : "+isMindstixEmployee);
				JSONArray jarrayo = jarray.getJSONObject(i).getJSONArray("hobbies");
				System.out.print("Hobbies : ");
				for(int l=0;l<jarrayo.length();l++) {
					System.out.print(jarrayo.getString(l)+", ");
				}
				System.out.println();
				String email = jarray.getJSONObject(i).getString("email");
				System.out.println("Email : "+email);
				String mobilenum = jarray.getJSONObject(i).getString("mobile");
				System.out.println("Mobile number : "+mobilenum);
				System.out.println();
				System.out.println("===================");
				JSONArray jarray1 = jarray.getJSONObject(i).getJSONArray("friends");
				for(int j=0;j<jarray1.length();j++) {
					System.out.println("Friends Information");
					System.out.println("-------------------");
					String friendname = jarray1.getJSONObject(j).getString("name");
					System.out.println("Name : "+friendname);
					int friendage = jarray.getJSONObject(j).getInt("age");
					System.out.println("Age : "+friendage);
					boolean isfriendMindstixEmployee = jarray.getJSONObject(j).getBoolean("isMindstixEmployee");
					System.out.println("isMindstixEmployee : "+isfriendMindstixEmployee);
					JSONArray jarray2 = jarray.getJSONObject(j).getJSONArray("hobbies");
					System.out.print("Hobbies : ");
					for(int k=0;k<jarray2.length();k++) {
						System.out.print(jarray2.getString(k)+", ");
					}
					System.out.println();
					System.out.println("-------------------");
				}
				System.out.println("===================");
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
