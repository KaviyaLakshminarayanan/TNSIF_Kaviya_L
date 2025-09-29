package com.tnsif.entityassignment.java;

public class StudentDetails {
	private String StudentName;
	private String Standard;
	private int Age;
	private char Section;
	private int Register_Number;
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public char getSection() {
		return Section;
	}
	public void setSection(char section) {
		Section = section;
	}
	public int getRegister_Number() {
		return Register_Number;
	}
	public void setRegister_Number(int register_Number) {
		Register_Number = register_Number;
	}
	@Override
	public String toString() {
		return "StudentDetails [StudentName=" + StudentName + ", Standard=" + Standard + ", Age=" + Age + ", Section="
				+ Section + ", Register_Number=" + Register_Number + "]";
	}
}
