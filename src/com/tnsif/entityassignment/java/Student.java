package com.tnsif.entityassignment.java;

public class Student {

	public static void main(String[] args) {
		StudentDetails s1=new StudentDetails();
		s1.setStudentName("Abinaya");
		s1.setAge(12);
		s1.setRegister_Number(1422211467);
		s1.setStandard("Seventh");
		s1.setSection('A');
		System.out.println(s1);
		StudentDetails s2=new StudentDetails();
		s2.setStudentName("Samantha");
		s2.setAge(10);
		s2.setRegister_Number(1422218867);
		s2.setStandard("Sixth");
		s2.setSection('B');
		System.out.println(s2);
		StudentDetails s3=new StudentDetails();
		s3.setStudentName("Reena");
		s3.setAge(11);;
		s3.setRegister_Number(1422211465);
		s3.setStandard("Seventh");
		s3.setSection('A');
		System.out.println(s3);
	}

}
