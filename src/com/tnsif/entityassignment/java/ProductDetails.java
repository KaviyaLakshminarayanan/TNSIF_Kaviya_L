package com.tnsif.entityassignment.java;

public class ProductDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		product p1=new product();
		p1.setAmount(100);
		p1.setName("Vijay");
		p1.setManufacturing_date("12-12-2024");
		p1.setExpiry_date("12-12-2026");
		System.out.println(p1);
		product p2=new product();
		p2.setAmount(200);
		p2.setName("Surya");
		p2.setManufacturing_date("10-10-2020");
		p2.setExpiry_date("10-10-2020");
		System.out.println(p2);
		product p3=new product();
		p3.setAmount(300);
		p3.setName("Ajay");
		p3.setManufacturing_date("11-11-2021");
		p3.setExpiry_date("11-11-2023");
		System.out.println(p3);
	}

}
