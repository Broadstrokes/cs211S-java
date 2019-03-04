public class ExceptionScopeFinally {

	public void level1() {
		System.out.println("Level 1 beginning.");

		try {
			level2();
		} catch (ArithmeticException problem) {
			System.out.println();
			System.out.println("The exception message is: "	+ problem.getMessage());
			System.out.println();
			System.out.println("The call stack trace:");
			problem.printStackTrace();
			System.out.println();
		}

		System.out.println("Level 1 ending.");
	}

	public void level2() {
		try {
			System.out.println("Level 2 beginning.");
			level3();
		} finally {
			System.out.println("Level 2 ending.");
		}
	}

	public void level3() {
		try {
			int numerator = 10, denominator = 0;

			System.out.println("Level 3 beginning.");
			int result = numerator / denominator;
		} finally {
			System.out.println("Level 3 ending.");
		}
		System.out.println("Outside of Level 3 finally block. Will be printed ONLY if no exception thrown.");
	}
	
	
	public static void main(String[] args) {
		ExceptionScopeFinally demo = new ExceptionScopeFinally();

		System.out.println("Program beginning.");
		demo.level1();
		System.out.println("Program ending.");
	}
	
}
