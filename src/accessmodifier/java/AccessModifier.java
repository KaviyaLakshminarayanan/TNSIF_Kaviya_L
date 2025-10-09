package accessmodifier.java;

public class AccessModifier {
	 public static void main(String[] args) {
	        Person p = new Person("Alice", 30, "Mumbai");
	        p.displayInfo();       // ✅ Accessible - public method
	        p.revealSecret();      // ✅ Can indirectly access private method
	        // p.showSecret();     // ❌ Error - private method not accessible

	        Student s = new Student("Bob", 22, "Delhi");
	        s.showStudentDetails();
	    }
}
