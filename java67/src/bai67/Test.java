package bai67;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
	
public class Test {
	public static void copy_all(File f1,File f2) {
		try {
			Files.copy(f1.toPath(),f2.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(f1.isDirectory()) {
			File[] files = f1.listFiles();
			for(File sub_file : files ) {
				File f2_new = new File(f2.getAbsolutePath()+"\\"+sub_file.getName());
				copy_all(sub_file, f2_new);
			}
			
		}
	}
	
	public static void main(String[] args) {
//		File f0 = new File("\\C:\\Users\\adm\\eclipse-workspace\\bai67\\t1.txt");
//		File f1 = new File("\\C:\\Users\\adm\\eclipse-workspace\\bai67\\f0");
//		File f2 = new File("\\C:\\Users\\adm\\eclipse-workspace\\bai67\\bin\\f0");
//		
//		f1.renameTo(f2);	
		
		File bin = new File("\\C:\\Users\\adm\\eclipse-workspace\\bai67\\bin");
		File bin_copy = new File("\\C:\\Users\\adm\\eclipse-workspace\\bai67\\bin_copy");
		
		copy_all(bin, bin_copy);
		
		
		
//		try {
//			Files.copy(bin.toPath(),bin_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}	
}
