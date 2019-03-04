public class ExceptionScope {

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
		System.out.println("Level 2 beginning.");
		level3();
		System.out.println("Level 2 ending.");
	}

	public void level3() {
		int numerator = 10, denominator = 0;

		System.out.println("Level 3 beginning.");
		int result = numerator / denominator;
		System.out.println("Level 3 ending.");
	}
	
	
	public static void main(String[] args) {
		ExceptionScope demo = new ExceptionScope();

		System.out.println("Program beginning.");
		demo.level1();
		System.out.println("Program ending.");
	}
}
