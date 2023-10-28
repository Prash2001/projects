package AAA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class APP {

  public static void main(String[] args) {
    String user = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("User_ID : ");
    int id = sc.nextInt();
    System.out.println();
    System.out.print("Password : ");
    int pass = sc.nextInt();
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("/Users/prashantjapkar/Documents/data.json"));
      StringBuilder sbuilder = new StringBuilder();
      String line;
      String Role = "";
      while ((line = reader.readLine()) != null) {
        sbuilder.append(line);
      }
      JSONObject jobj = new JSONObject(sbuilder.toString());
      JSONArray jarray1 = jobj.getJSONArray("userData");
      boolean flag = true;
      int user_id, user_pass;
      for (int i = 0; i < jarray1.length(); i++) {
        user_id = jarray1.getJSONObject(i).getInt("user_id");
        user_pass = jarray1.getJSONObject(i).getInt("pass");
        if (user_id == id && user_pass == pass) {
          Role = jarray1.getJSONObject(i).getString("user_role");
          user = jarray1.getJSONObject(i).getString("user_name");
          flag = false;
        }
      }
      if (flag) {
        System.out.println("Invalid Login Credeintial");
      }
      if (Role.equals("cxo")) {
        System.out.println("Hello " + user);
        boolean loopflag = true;
        while (loopflag) {
          System.out.println("MENU :");
          JSONObject jobj2 = jobj.getJSONObject("userAction");
          JSONArray jarray2 = jobj2.getJSONArray("cxo");
          for (int i = 0; i < jarray2.length(); i++) {
            System.out.println((i + 1) + "." + jarray2.getString(i));
          }
          System.out.println((jarray2.length() + 1) + ".exist");
          System.out.print("Enter your choice : ");
          int choice = sc.nextInt();
          CXO obj = new CXO();
          switch (choice) {
            case 1:
              obj.add_emp(jobj);
              break;
            case 2:
              obj.update_emp(jobj);
              break;
            case 7:
              loopflag = false;
              System.out.println("Thank you for using the application");
              break;
            default:
              System.out.println("Working on this feature");
              break;
          }
        }
        // CXO obj = new CXO();
        // obj.update_emp(jobj);

        // obj.add_emp(jobj);
      } else if (Role.equals("manager")) {
        System.out.println("Hello " + user);
        System.out.println("MENU :");
        JSONObject jobj2 = jobj.getJSONObject("userAction");
        JSONArray jarray2 = jobj2.getJSONArray("manager");
        for (int i = 0; i < jarray2.length(); i++) {
          System.out.println((i + 1) + "." + jarray2.getString(i));
        }
      } else if (Role.equals("employee")) {
        System.out.println("Hello " + user);
        System.out.println("MENU :");
        JSONObject jobj2 = jobj.getJSONObject("userAction");
        JSONArray jarray2 = jobj2.getJSONArray("employee");
        for (int i = 0; i < jarray2.length(); i++) {
          System.out.println((i + 1) + "." + jarray2.getString(i));
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    sc.close();

  }

}

