import java.util.Scanner;


public class CodeEntry {

	public static void main(String[] args)  {
		
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		
		int numValid = 0, numInvalid = 0;
		
		while(keepGoing) {
			System.out.println("Enter a zip code followed by \'S\' or \'E\'. Enter \'q\' to quit.");
			String userInput = scan.nextLine();
			
			if(userInput.equalsIgnoreCase("q")) {
				keepGoing = false;
			} else {
		
				try {		
					String zipCodeString = userInput.substring(0,5);
					int zipCode = Integer.parseInt(zipCodeString);
					
					String shipSpeedString = userInput.substring(5,6);
					
					System.out.println("Shipping to " + zipCode);
					
					if(zipCode >= 90000) {
						System.out.println("\tShipping out west.");
					}
					
					if(shipSpeedString.equalsIgnoreCase("S")) {
						System.out.println("\tStandard speed");
					} else if(shipSpeedString.equalsIgnoreCase("E")) {
						System.out.println("\tExpedited speed");
					} else {
						// my own exception case
						throw new InvalidShippingCodeException();
					}
					
					numValid++;
					
				} catch(NumberFormatException ex) {
					System.out.println("Zip code is not numeric. Try again.");
					numInvalid++;
				} catch(StringIndexOutOfBoundsException ex) {
					System.out.println("Input too short. Try again.");
					numInvalid++;
				} catch(InvalidShippingCodeException ex) {
					System.out.println("Invalid shipping speed code. Try again.");
					numInvalid++;
				} finally {
					System.out.println(numValid + " valid and " + numInvalid + " invalid codes entered so far.");
				}
				
			} // end of while
			//System.out.println(numValid + " valid and " + numInvalid + " invalid codes entered.");
		}
		
	}
}
