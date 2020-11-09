package com.cestar.controller.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cestar.dao.EmpDao;
import com.cestar.model.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("e_id"));
		
		String name = request.getParameter("e_name");
		
		String city = request.getParameter("e_city");
		
		String contact = request.getParameter("e_contact");
		
		String email = request.getParameter("e_email");
		
		Employee emp = new Employee(id,name,city,contact,email);
		
		EmpDao obj = new EmpDao();
		
		int status = obj.addEmp(emp);
		out.print(status);
		
		if(status>0){
			
			out.print("<h1>Employee Record Inserted Successfuly!!!</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
