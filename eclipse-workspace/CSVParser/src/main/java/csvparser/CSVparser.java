package main.java.csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVparser {
	public void usingScanner(String filepath) {
		try {
			Scanner sc = new Scanner(new File(filepath));
			while(sc.hasNext()) {
				System.out.println(sc.next().toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void usingBufferReader(String filepath) {
		try {
			List<Data> userData = new ArrayList<Data>();
			BufferedReader reader= new BufferedReader(new FileReader(filepath));
			String line =reader.readLine();
			/*while(line!=null&&line!="") {
				String[] data = line.split(",");
				Data dataobj = new Data(data[0],data[1],data[2],data[3],data[4],data[5]);
				userData.add(dataobj);
				/*for(int i=0;i<data.length;i++) {
					System.out.print(data[i]+"  ");
				}
				line = reader.readLine();
			}*/
			/*Iterator<Data> itr = userData.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}*/
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i)=='"') {
					
				}
			}
			for(Data udata : userData) {
				System.out.println(udata);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CSVparser parser = new CSVparser();
		parser.usingBufferReader("/Users/prashantjapkar/2022-q3/prashant-japkar/training/student.csv");

	}

}
