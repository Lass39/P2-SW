package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveOrder")
public class SaveOrder extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Date formattedDate = null;
		String sPurchAmt=request.getParameter("purchAmt");
		float purchAmt=Float.parseFloat(sPurchAmt);
		String ordDateS=request.getParameter("ordDate");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
        try {
		 formattedDate = new java.sql.Date(formatter.parse(ordDateS).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
       

        String sCustomeId=request.getParameter("customerId");
        int customerId=Integer.parseInt(sCustomeId);
        String sSalesmanId=request.getParameter("salesmanId");
        int salesmanId=Integer.parseInt(sSalesmanId);

        order vendedor=new order();
        vendedor.setPurchAmt(purchAmt);
        vendedor.setOrdDate(formattedDate);
        vendedor.setCustomerId(customerId);
        vendedor.setSalesmanId(salesmanId);

		int status = generalDB.saveOrder(vendedor);
		if (status > 0) {

			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
