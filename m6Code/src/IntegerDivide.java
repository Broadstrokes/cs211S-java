import java.util.Scanner;

public class IntegerDivide {

	public static void main(String[] args) {
		helper1();
	}
	
	public static void helper1() {
		helper2();
	}
	
	public static void helper2() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number 1");
		int n1 = scan.nextInt();
		
		System.out.println("Enter non-zero number 2");
		int n2 = scan.nextInt();
		if(n2!=0) {
			int n3 = n1 / n2;
			System.out.println("The quotient is " + n3);
		} else {
			System.out.println("Bad input.");
		}
	}
}
