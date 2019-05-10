import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class Address {

	@ProperLength
	private String street;
	private String street2;
	@ProperLength(maxLength = 40)
	private String city;
	@ProperLength(minLength = 2, maxLength = 2)
	private String state;
	@ProperLength(minLength = 5, maxLength = 5)
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) throws IllegalArgumentException  {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}
	private void validateLengths() throws IllegalArgumentException {
		// YOUR CODE HERE
	}
	
	@Override
	public String toString() {
		String s = street + (street2.length()>0 ? "\t"+street2 : "") +
				"\t" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
