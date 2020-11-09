package com.cestar.dao;

import com.cestar.model.Employee;

public class EmpRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpDao obj=new EmpDao();
		
//		Employee emp=new Employee(123,"Jane Austen","Londan","23455e","jane@gmail.com");
//		obj.displayAllRecord();
//		System.out.print(obj.getRecordById(45));
//		Employee emp=new Employee(45,"songul","toronto","4567","tutku2gamil.com");

		obj.deleteRecord(45);
	}
	

}
