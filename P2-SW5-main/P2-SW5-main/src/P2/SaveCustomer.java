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

@WebServlet("/SaveCustomer")
public class SaveCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String custName=request.getParameter("custName");
        String city=request.getParameter("city");
        String sgrade=request.getParameter("grade");
        int grade=Integer.parseInt(sgrade);
        String sSalesmanId=request.getParameter("salesmanId");
        int salesmanId=Integer.parseInt(sSalesmanId);

        customer vendedor=new customer();
        vendedor.setCustName(custName);
        vendedor.setCity(city);
        vendedor.setGrade(grade);
        vendedor.setSalesmanId(salesmanId);

		int status = generalDB.saveCustomer(vendedor);
		if (status > 0) {

			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}