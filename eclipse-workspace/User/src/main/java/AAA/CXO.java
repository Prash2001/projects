package AAA;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class CXO {
	Scanner sc = new Scanner(System.in);
	public void add_emp(JSONObject jobj) {
		//System.out.println("Hello ");
		JSONArray jarray = jobj.getJSONArray("userData");
		System.out.print("user_id: ");
		int id = sc.nextInt();
		System.out.println();
		System.out.print("Name : ");
		String name = sc.next();
		System.out.println();
		System.out.print("pass : ");
		int password = sc.nextInt();
		System.out.println();
		System.out.print("user_role: ");
		String role = sc.next();
		System.out.println();
		JSONObject jobj1 = new JSONObject().put("user_id", id).put("user_name", name).put("pass", password).put("user_role", role);
		JSONArray njarray = jarray.put(jobj1);
		JSONObject nJobj = jobj.put("userData", njarray);
		String jstr = nJobj.toString();
		System.out.println(jstr);
	}
	public void update_emp(JSONObject jobj) {
		System.out.print("Enter employee id : ");
		int emp_id= sc.nextInt();
		int eid;
		JSONArray jarray = jobj.getJSONArray("userData");
		for(int i=0;i<jarray.length();i++) {
			eid=jarray.getJSONObject(i).getInt("user_id");
			if(eid==emp_id) {
				int choice = sc.nextInt();
				switch(choice) {
				case 2:System.out.print("Enter new user_id : ");
				       System.out.println();
				       int nid = sc.nextInt();
				       jarray.getJSONObject(i).put("user_id", nid);
				       System.out.println("user_id updated successfully");
				       break;
				case 1:System.out.print("Enter new user_name : ");
				       System.out.println();
			           String nName = sc.next();
			           jarray.getJSONObject(i).put("user_name", nName);
			           System.out.println("user_name updated successfully");
			           break;
				case 3:System.out.print("Enter new Password : ");
			           System.out.println();
		               int nPass = sc.nextInt();
		               jarray.getJSONObject(i).put("pass", nPass);
		               System.out.println("password updated successfully");
		               break;
				case 4:System.out.print("Enter new Role : ");
			           System.out.println();
		               String nRole = sc.next();
		               jarray.getJSONObject(i).put("user_role", nRole);
		               System.out.println("user_role updated successfully");
		               break;
		        default:System.out.println("Invalid Choice!");
		                break;
				}
				System.out.println(jobj);
			}
		}
	}
}
