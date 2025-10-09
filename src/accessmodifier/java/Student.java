package accessmodifier.java;

public class Student extends Person {
	 public Student(String name, int age, String address) {
	        super(name, age, address);
	    }

	    public void showStudentDetails() {
	        // System.out.println("Name: " + name); // ❌ Error: 'name' is private
	        System.out.println("Age: " + age);       // ✅ default: accessible within same package
	        System.out.println("Address: " + address); // ✅ protected: accessible in subclass
	        System.out.println("Country: " + country); // ✅ public: accessible everywhere
	    }
}
