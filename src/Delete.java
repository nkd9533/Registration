

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 int roll=Integer.parseInt(request.getParameter("roll"));
		 try {
				Connection c = DBConnection.getConn();
				PreparedStatement ps = c.prepareStatement("delete from Student where roll_no=?");
				ps.setInt(1,roll);
				int i=0;
				i=ps.executeUpdate();
		 if(i!=0)
			{
			 RequestDispatcher rd=request.getRequestDispatcher("afterlogin.html");
			 rd.include(request,response);
			 out.println("<h1 style=text-align:center;>");
			 out.println("Record Deleted Successfully.");
			}
		 else
		 {
			 RequestDispatcher rd=request.getRequestDispatcher("delete.html");
			 rd.include(request,response);
			 out.println("<h3 style=color:red;>");
			 out.println("! Wrong Roll Number");
		 }
			 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			 
	}

}
