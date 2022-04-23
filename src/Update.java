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
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StuBean b=new StuBean();
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 String stuName = request.getParameter("stuName");
		 String fName = request.getParameter("fName");
		 String collName=request.getParameter("collName");
		 int roll=Integer.parseInt(request.getParameter("roll"));
		 double hindi=Double.parseDouble(request.getParameter("hindi"));
		 double eng=Double.parseDouble(request.getParameter("eng"));
		 double maths=Double.parseDouble(request.getParameter("maths"));
		 double science=Double.parseDouble(request.getParameter("science"));
		 double sst=Double.parseDouble(request.getParameter("sst")); 
		 b.setStuName(stuName);	
		 b.setfName(fName);
		 b.setCollName(collName);
		 b.setRoll(roll);
		 b.setHindi(hindi);
		 b.setEng(eng);	
		 b.setMaths(maths);	
		 b.setScience(science);
		 b.setSst(sst);
		 try {
			 Connection c = DBConnection.getConn();
			 PreparedStatement ps=c.prepareStatement("update Student Set Name=?, Fname=?, Cname=?, Hindi=?, English=?, Maths=?, Science=?, Social_Science=?, Total_Marks=?, Percentage=?, Division=? where roll_no=?");
				ps.setString(1,b.getStuName());
				ps.setString(2,b.getfName());
				ps.setString(3,b.getCollName());
				ps.setDouble(4,b.getHindi());
				ps.setDouble(5,b.getEng());
				ps.setDouble(6,b.getMaths());
				ps.setDouble(7,b.getScience());
				ps.setDouble(8,b.getSst());
				ps.setDouble(9,b.getTotal());
				ps.setDouble(10,b.getPercentage());
				ps.setString(11,b.getDivision());
				ps.setInt(12,b.getRoll());
				
				PreparedStatement prs = c.prepareStatement("select * from Student where roll_no=?");
				prs.setInt(1,b.getRoll());
				ResultSet rs = prs.executeQuery();
				int i=0;
				if(rs.next())
				{
					i=ps.executeUpdate();
					if(i!=0)
					{
						RequestDispatcher rd=request.getRequestDispatcher("afterlogin.html");
						 rd.include(request,response);
						 out.println("<h1 style=text-align:center;>");
						 out.println("Record Updated Successfully.");
					}
					else
					 {
						 RequestDispatcher rd=request.getRequestDispatcher("update.html");
						 rd.include(request,response);
						 out.println("<h3 style=color:red;>");
						 out.println("Unable to Update, Try again!");
					 }
				}
				else
				 {
					 RequestDispatcher rd=request.getRequestDispatcher("afterlogin.html");
					 rd.include(request,response);
					 out.println("<h3 style=color:red;>");
					 out.println("Record with Roll Number - "+b.getRoll() +"  does not exist, Please Register First.");
				 }
		 }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
