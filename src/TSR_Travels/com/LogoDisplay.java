package TSR_Travels.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LogoDisplay {
	
	public static void logoDisplay(String path) {
		
				
		try(FileInputStream fis = new FileInputStream(new File(path))) {
			int temp = 0;
			while ((temp = fis.read()) != -1) {
				System.out.print((char) temp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oh Oh !! Server couldn't find the logo :( ");
//			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	 public static void main(String[] args) {
	        // Replace "path_to_your_logo_file" with the actual path to your logo file.
	        String logoPath = "C:/Users/Tarun Sreenivas/Desktop/FLM java/== TSR Travels ==.txt";
	        logoDisplay(logoPath);
	    }

}
