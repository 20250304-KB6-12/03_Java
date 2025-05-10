package ch18.sec02.exam03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {		
			OutputStream os = new FileOutputStream("C:/Temp/test3.db");
			
			byte[] array =  { 65, 66, 67, 68, 69 };
			
			os.write(array, 1, 3);
			
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
