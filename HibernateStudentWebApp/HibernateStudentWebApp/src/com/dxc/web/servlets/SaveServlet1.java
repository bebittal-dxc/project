package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.beans.Student_exam;
import com.dxc.web.hibdaoimp.Student_examJDBCDAO;



/**
 * Servlet implementation class SaveServlet1
 */
@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student_examJDBCDAO examdao;
	public void init()
	{
		try {
			examdao=new Student_examJDBCDAO();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String exam_name=request.getParameter("exam_name");
		if((id==0)||exam_name.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("exam.jsp");
			rd.include(request, response);
		}
		
		else
		{
			Student_exam e=new Student_exam();
			e.setId(id);
			e.setExam_name(exam_name);
			try {
				examdao.save(e);
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			response.sendRedirect("scernario1.jsp");
		}	
	}
}
