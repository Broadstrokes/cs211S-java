import java.util.*;
import java.io.*;

public class InputOutputPractice {

	public static void main(String[] args) throws IOException {

		// the Scanner object will read from the file
		Scanner fileScan = new Scanner(new FileReader(new File("input_oneperline.txt")));

		// the PrintWriter object will write to a file
		PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("output_alloneline.txt")));
		
		while(fileScan.hasNext()) {
			String fileLine = fileScan.nextLine();
			//System.out.println(fileLine);
			fileOut.print(fileLine + " ");
		}
		
		fileOut.close(); // CRITICAL!! you must close your output stream or you lose your output!
		
	}

}
