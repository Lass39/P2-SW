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

@WebServlet("/EditSalesman2")
public class EditSalesman2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();

		    String sid = request.getParameter("salesman_id");
		    int id = Integer.parseInt(sid);
		    String name = request.getParameter("name");
		    String city = request.getParameter("city");
		    String scommission = request.getParameter("commission");
		    float commission = Float.parseFloat(scommission);

		    salesman vendedor = new salesman();
		    vendedor.setId(id);
		    vendedor.setName(name);
		    vendedor.setCity(city);
		    vendedor.setCommission(commission);

		    int status = generalDB.updateSalesman(vendedor);
		    if(status>0)
		    {
		        response.sendRedirect("ViewSalesman");
		    }
		    else
		    {
		        out.println("Sorry! unable to update record" + status);
		    }

		        out.close();
		    }

}