public class Member {

    enum Status {FOUNDING, PAID, HONORARY}

    private String firstName, lastName;
    private int age;
    private Status status;

    public Member(String firstName, String lastName, int age, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " (Status: " + status + ")";
    }

}
