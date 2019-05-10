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
		Field[] fields = this.getClass().getDeclaredFields();
		Arrays.stream(fields).forEach(field -> {
			if (field.isAnnotationPresent(ProperLength.class)) {
				ProperLength annotation = field.getAnnotation(ProperLength.class);
				try {
					String fieldValue = field.get(this).toString();
					if (fieldValue.length() < annotation.minLength() || fieldValue.length() > annotation.maxLength()) {
						throw new IllegalArgumentException(String.format(field.getName() + " has invalid length!"));
					}
				} catch (IllegalAccessException | IllegalAccessError e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public String toString() {
		String s = street + (street2.length()>0 ? "\t"+street2 : "") +
				"\t" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
