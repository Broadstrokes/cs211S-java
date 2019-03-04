import java.io.*;
import java.util.*;

public class NumberFileOutput {

	public static void main(String[] args) {
		
		PrintWriter out = null;
		try {
			FileWriter fileWriter = new FileWriter("numbers.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			out = new PrintWriter(bufferedWriter);

			Random generator = new Random();
			int maxNum = 500;
			for (int i = 0; i < 100; i++) {
				int randomNum = generator.nextInt(maxNum);
				out.println(randomNum);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if(out!=null) {
				out.close();
			}
		}

	}

}
