package P2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@author 
//Giovanni Fernandes CB1640488

@WebServlet("/EditOrder2")
public class EditOrder2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();

		    String sordNo = request.getParameter("ord_no");
		    int ordNo = Integer.parseInt(sordNo);
		    String spurchAmt = request.getParameter("purch_amt");
		    float purchAmt = Float.parseFloat(spurchAmt);
		    String ordDate = request.getParameter("ord_date");
		    String scustomer = request.getParameter("customer_id");
		    int customer = Integer.parseInt(scustomer);
		    String ssalesman = request.getParameter("salesman_id");
		    int salesman = Integer.parseInt(ssalesman);

		    order vendedor = new order();
		    vendedor.setOrdNo(ordNo);
		    vendedor.setPurchAmt(purchAmt);
		    vendedor.setOrdDate(ordDate);
		    vendedor.setCustomerId(customer);
		    vendedor.setSalesmanId(salesman);

		    int status = generalDB.updateOrder(vendedor);
		    if(status>0)
		    {
		        response.sendRedirect("ViewOrder");
		    }
		    else
		    {
		        out.println("Sorry! unable to update record");
		    }

		        out.close();
		    }
}