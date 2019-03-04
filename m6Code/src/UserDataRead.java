import java.util.*;
import java.io.*;

public class UserDataRead {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		// the fileScan object reads in lines from the file
		Scanner fileScan = new Scanner(new FileReader(new File("userdata.csv")));
		
		// reads past the column header line
		// IMPORTANT! you can only do this if you are confident that your
		// data is well-formed and clean (e.g., no missing cells, etc.).
		// that is usually not the case with real world data, so be careful!
		fileScan.nextLine();
		
		while(fileScan.hasNext()) {
			String oneLine = fileScan.nextLine();
			
			
			Scanner lineScan = new Scanner(oneLine);
			lineScan.useDelimiter(",");
			
			/* use a second Scanner object to parse out each individual token
			while(lineScan.hasNext()) {
				String token = lineScan.next();
				System.out.println(token);
			}
			*/
			
			// IMPORTANT! see note above- this only works with perfectly formed data!
			// in the real world, this will really never happen!
			String firstName = lineScan.next();
			String lastName = lineScan.next();
			String email = lineScan.next();
			String phone = lineScan.next();
			
			User user = new User(firstName, lastName, email, phone);
			userList.add(user);
			
		}
		
		fileScan.close();
		
		for(User u : userList) {
			System.out.println(u);
		}
	}

}
