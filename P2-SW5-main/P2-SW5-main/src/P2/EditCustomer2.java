package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditCustomer2")
public class EditCustomer2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();

		    String sid = request.getParameter("customer_id");
		    int id = Integer.parseInt(sid);
		    String custName = request.getParameter("cust_name");
		    String city = request.getParameter("city");
		    String sgrade = request.getParameter("grade");
		    int grade = Integer.parseInt(sgrade);
		    String ssalesman = request.getParameter("salesman_id");
		    int salesman = Integer.parseInt(ssalesman);

		    customer vendedor = new customer();
		    vendedor.setId(id);
		    vendedor.setCustName(custName);
		    vendedor.setCity(city);
		    vendedor.setGrade(grade);
		    vendedor.setSalesmanId(salesman);

		    int status = generalDB.updateCustomer(vendedor);
		    if(status>0)
		    {
		        response.sendRedirect("ViewCustomer");
		    }
		    else
		    {
		        out.println("Sorry! unable to update record");
		    }

		        out.close();
		    }
}
