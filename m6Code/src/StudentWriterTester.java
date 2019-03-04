import java.io.*;


public class StudentWriterTester {

	public static void main(String[] args) throws IOException {
		writeStudent();
		readStudent();
	}
	
	public static void writeStudent() throws IOException {
		Student s1 = new Student("Jane Doe", "JD123", 500);
		//String s1 = new String("Hello World");
		System.out.println(s1);
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("student.ser"));
		output.writeObject(s1);
		output.close();
		
	}
	
	public static void readStudent() throws IOException {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("student.ser"));
			Student s = (Student) input.readObject();
			System.out.println(s);
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
