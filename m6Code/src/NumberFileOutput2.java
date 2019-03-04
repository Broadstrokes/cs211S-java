import java.io.*;
import java.util.Random;

public class NumberFileOutput2 {

	public static void main(String[] args)  {
	    
	    String outputFile = "output.dat";
		try ( 

      FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outputWriter = new PrintWriter(bw);
      ) {
	
			Random generator = new Random();
			int maxNum = 96;
			for (int i = 0; i < 5; i++) {
				int num = generator.nextInt(maxNum);
				outputWriter.print(num+",");
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 

	}

}
