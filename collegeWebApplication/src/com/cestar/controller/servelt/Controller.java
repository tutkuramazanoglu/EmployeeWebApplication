package com.cestar.controller.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.EmpDao;
import com.cestar.model.Employee;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url=request.getServletPath(); //use string in swtich case
		
		switch(url) {
		case "/insert":
			out.print("Your are in Insert page!");
			insertRecord(request,response);
			break;
		case "/display":
			displayAll(request,response);
			 break;
		case "/edit":
			editRecord(request,response);
			break;
		case "/update":
			updateRecord(request,response);
			break;
		case "/delete":
			deleteEmpRecord(request,response);
			out.print("Your are in Delete page!");
			break;
		default:
			out.print("Sorry url is not found.");
			break;		
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insertRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
//		if(status>0){
//			
//			out.print("<h1>Employee Record Inserted Successfuly!!!</h1>");
//		}
		displayAll(request,response);
	}
	
	protected void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmpDao obj = new EmpDao();
		
		List<Employee>  empz = obj.displayAllRecord(); //it comes from database
		
		HttpSession session = request.getSession();
		
		session.setAttribute("emps", empz);
		
		RequestDispatcher  rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
		
	}
	
	protected void editRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
EmpDao obj = new EmpDao();
		
		int  old_id = Integer.parseInt(request.getParameter("id"));
		
		Employee tobUpdated = obj.getRecordById(old_id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("empTobUpdate", tobUpdated);
		
		session.setAttribute("old_id", old_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		
		rd.forward(request, response);
		
		
		
	}
	
	protected void updateRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		
		String city = request.getParameter("city");
		
		String contact = request.getParameter("contact");
		
		String email = request.getParameter("email");
		
		EmpDao obj = new EmpDao();
		
		Employee updated_emp = new Employee(id,name,city,contact,email);
		
	    HttpSession session = request.getSession();
	    
	   int old_id = (int) session.getAttribute("old_id");
	    
	    obj.updateRecordEmp(old_id, updated_emp);
	    
	    displayAll(request, response);

			
	}
	
	protected void deleteEmpRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpDao obj=new EmpDao();
		int id =Integer.parseInt(request.getParameter("id"));
		obj.deleteRecord(id);
		displayAll(request,response);
	}


}
