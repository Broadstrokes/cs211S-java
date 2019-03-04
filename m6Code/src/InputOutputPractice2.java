import java.util.*;
import java.io.*;

public class InputOutputPractice2 {

	public static void main(String[] args) {

		PrintWriter fileOut = null;
		try {
			Scanner fileScan = new Scanner(new FileReader(new File("input_oneperline.txt")));
			fileOut = new PrintWriter(new BufferedWriter(new FileWriter("output_alloneline.txt")));

			while (fileScan.hasNext()) {
				String fileLine = fileScan.nextLine();
				fileOut.print(fileLine + " ");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if(fileOut!=null) {
				fileOut.close();
			}
		}
	}

}
