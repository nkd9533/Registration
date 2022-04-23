

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

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 int roll=Integer.parseInt(request.getParameter("roll"));
		 out.println("<html><body>");
		 try {
			Connection c = DBConnection.getConn();
			PreparedStatement ps = c.prepareStatement("select * from Student where roll_no=?");
			ps.setInt(1,roll);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				out.println("<table width=\"50%\" style=\"border: 6px solid green;\" cellpadding=\"10\" cellspacing=\"10\" align=\"center\">");
			out.println("<tr>"
						+ "<td><h1><b>Roll Number</b></h1></td>"
						+ "<td><h1>"+rs.getInt(1)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Student Name</b></h1></td>"
						+ "<td><h1>"+rs.getString(2)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Father's Name</b></h1></td>"
						+ "<td><h1>"+rs.getString(3)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>College Name</b></h1></td>"
						+ "<td><h1>"+rs.getString(4)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Hindi</b></h1></td>"
						+ "<td><h1>"+rs.getDouble(5)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>English</b></h1></td>"
						+ "<td><h1>"+rs.getDouble(6)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Mathematics</b></h1></td>"
						+ "<td><h1>"
						+rs.getDouble(7)
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Science</b></h1></td>"
						+ "<td><h1>"+rs.getDouble(8)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Social Science</b></h1></td>"
						+ "<td><h1>"
						+rs.getDouble(9)
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Total Marks</b></h1></td>"
						+ "<td><h1>"
						+rs.getDouble(10)
						+ "</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Percentage</b></h1></td>"
						+ "<td><h1>"+rs.getDouble(11)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><h1><b>Division</b></h1></td>"
						+ "<td><h1>"
						+rs.getString(12)
						+ "</td>"
						+ "</tr>"
						+ "</table>");
			}
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("view.html");
				 rd.include(request,response);
				 out.println("<h3 style=color:red;>");
				 out.println("Please Enter Correct Roll Number");
			 }
				 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
