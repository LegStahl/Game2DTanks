package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Records {
	private  String PATH = "res/";
	
	private  String NAMEFILE = "Records.txt";
	
	private int theBest;
	
	private int[] records;
	
	public Records(int newValue) {
		 File file = new File(PATH + NAMEFILE);
		 records = new int[4] ;
		 Scanner scaner;
		try {
			int i = 0;
			scaner = new Scanner(file);
			 while(scaner.hasNext()) {
	                if(scaner.hasNextInt()) {
	                    records[i] = scaner.nextInt();
	                    i++;
			
	                }else {
	                	scaner.nextLine();
	                }
			 }
			 scaner.close();
			 loop: for(int j = 0; j < records.length; j++) {
				 if(newValue > records[j]) {
					 for(int r = records.length - 1 ; r > j + 1; r --) {
						 records[r] = records[r - 1];
					 }
					 records[j] = newValue;
					 break loop;
				 }
			 }
			 theBest = records[0];
	            FileWriter fileOut = new FileWriter(PATH + NAMEFILE);

	            BufferedWriter buffer = new BufferedWriter(fileOut);
	            for (int r = 0; r < records.length; r++)
	                buffer.write( records[r] + "\n");
	            buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Records() {
		 File file = new File(PATH + NAMEFILE);
		 records = new int[4] ;
		 Scanner scaner;
		 try {
			int i = 0;
			scaner = new Scanner(file);
			 while(scaner.hasNext()) {
	                if(scaner.hasNextInt()) {
	                    records[i] = scaner.nextInt();
	                    i++;
			
	                }else {
	                	scaner.nextLine();
	                }
			 }
			 scaner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getResult(int i) {
		return records[i];
	}
	
	public int getTheBest() {
		return theBest;
	}
}
