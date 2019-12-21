package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Admindao;
import com.model.RegisterModel;

/**
 * Servlet implementation class employeeController
 */
public class employeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("before admindao");
		Admindao db=new Admindao();
		List<RegisterModel> lst=db.getAllData();
		System.out.println("after getall data");
	/*	pw.print("<table>");
		for(Register r:lst)
		{
	pw.print("<tr><td>"+r.getFname()+"</td><td>"+r.getRno()+"</td><tr>");
		}
		pw.println("</table>")
		*/
		
		
		
		
		/*HttpSession session=request.getSession(true);
		session.setAttribute("data",lst);
		response.sendRedirect("DisplayAll.jsp");
	*/
	
request.setAttribute("userList",lst);
RequestDispatcher view = request.getRequestDispatcher("list.jsp");
view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
