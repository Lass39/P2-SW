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

@WebServlet("/SaveSalesman")
public class SaveSalesman extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name=request.getParameter("name");
        String city=request.getParameter("city");
        String scommission=request.getParameter("commission");
        float commission=Float.parseFloat(scommission);

        salesman vendedor=new salesman();
        vendedor.setName(name);
        vendedor.setCity(city);
        vendedor.setCommission(commission);

		int status = generalDB.saveSalesman(vendedor);
		if (status > 0) {

			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}