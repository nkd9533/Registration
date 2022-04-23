

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String stuName = request.getParameter("stuName");
		 int roll=Integer.parseInt(request.getParameter("roll"));
		 out.println("<html><body>");
		 try {
			Connection c = DBConnection.getConn();
			PreparedStatement ps = c.prepareStatement("select * from Student where name=? and roll_no=?");
			ps.setString(1,stuName);
			ps.setInt(2,roll);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				response.sendRedirect("afterlogin.html");
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				 rd.include(request,response);
				 out.println("<h3 style=color:red;>");
				 out.println("! Wrong Name or Roll Number");
			 }
				 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
