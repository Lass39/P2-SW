package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String sid = request.getParameter("customer_id");
        int id = Integer.parseInt(sid);
        generalDB.deleteCustomer(id);
        response.sendRedirect("ViewCustomer");
    }
}

