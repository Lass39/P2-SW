package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteSalesman")
public class DeleteSalesman extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String sid = request.getParameter("salesman_id");
        int id = Integer.parseInt(sid);
        generalDB.deleteSalesman(id);
        response.sendRedirect("ViewSalesman");
    }
}
