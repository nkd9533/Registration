

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
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String UserId = request.getParameter("UserId");
		 int Password=Integer.parseInt(request.getParameter("Password"));
		 out.println("<html><body>");
		 try {
			Connection c = DBConnection.getConn();
			PreparedStatement ps = c.prepareStatement("select * from Admin where UserId=? and Password=?");
			ps.setString(1,UserId);
			ps.setInt(2,Password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				response.sendRedirect("afterlogin.html");
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("LoginAdmin.html");
				 rd.include(request,response);
				 out.println("<h3 style=color:red;>");
				 out.println("! Wrong User Id or Password");
			 }
				 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
