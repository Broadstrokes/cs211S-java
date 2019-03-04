
public class InvalidShippingCodeException extends Exception {

	public InvalidShippingCodeException() {
		super("Invalid Shipping Code");
	}
	public InvalidShippingCodeException(String message) {
		super(message);
	}
}
