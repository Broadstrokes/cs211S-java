
public class Student implements java.io.Serializable { 
	private String name;
	private String id;
	private double tuition;

	public Student(String name, String id, double tuition) {
		this.name = name;
		this.id = id;
		this.tuition = tuition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTuition() {
		return tuition;
	}
	public void setTuition(double tuition) {
		if(tuition >= 0) {
			this.tuition = tuition;
		}
	}
	@Override
	public String toString() {
		String s = "Name: " + name + "\n";
		s += "\tID: " + id + "\n";
		s += "\tTuition: " + tuition + "\n";
		return s;
	}
	
	
}
