package com.cestar.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Employee;

public class EmpDao {
	public Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/rogers";
		String user="root";
		String password="tutkuutku";
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con=DriverManager.getConnection(url,user,password);
				System.out.print("Connection Succesfull!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public int addEmp(Employee e) {
		Connection con=getConnection();
		int status=0;
		String sql="insert into employee value (?,?,?,?,?)";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1,e.getId());
			psmt.setString(2,e.getName());
			psmt.setString(3,e.getCity());
			psmt.setString(4, e.getContact());
			psmt.setString(5, e.getEmail());
			status=psmt.executeUpdate();
			if(status>0) {
				System.out.print("Recoed insterted succesfully");
			}
			else {
				System.out.print("Recoed can not insterted");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
		
	}
	
	public List<Employee> displayAllRecord(){
		Connection con=getConnection();
		List <Employee> newEmp=new ArrayList<>();
		String sql="select*from employee ";
		try {
//			Statement stmt = con.createStatement(); //create stattemnt does not take parameter
//			ResultSet rs=stmt.executeQuery(sql);
			PreparedStatement psmt=con.prepareStatement(sql);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				//you can use column label or id
				Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				newEmp.add(emp);
			}
			System.out.println(newEmp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newEmp;
	}
	
	public Employee getRecordById(int id) {
		Connection con=getConnection();
		String sql="select*from employee where idemployee=?";
		
		Employee emp=null;
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}
	
	public int updateRecordEmp(int oldID,Employee e) {
		Connection con=getConnection();
		String sql="update employee set idemployee=?, employeeName=?,city=?,contact=?,email=? where idemployee=?";
		int status=0;
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, e.getId());
			pstm.setString(2, e.getName());
			pstm.setString(3,e.getCity());
			pstm.setString(4, e.getContact());
			pstm.setString(5, e.getEmail());
			pstm.setInt(6, oldID);
			status=pstm.executeUpdate();
			if(status>0) {
				System.out.print("Record is updated");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
		
	}
	
	public int deleteRecord(int id) {
		Connection con=getConnection();
		String sql="delete from employee where idemployee=?";
		int status=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			status=pstmt.executeUpdate();
			if(status>0) 
			{System.out.print("record is deleted.");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	

}
