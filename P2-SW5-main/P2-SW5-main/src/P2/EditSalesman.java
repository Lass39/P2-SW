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

@WebServlet("/EditSalesman")
public class EditSalesman extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Atualizar Vendedor</h1>");
        String sid = request.getParameter("salesman_id");
        int id = Integer.parseInt(sid);

        salesman vendedor = generalDB.getSalesmanById(id);

        out.print("<form action='EditSalesman2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='salesman_id' value='"+ vendedor.getId()+"'/></td></tr>");
        out.print("<tr><td>Nome:</td><td><input type='text' name='name' value= '"+vendedor.getName()+"' /></ td ></ tr > ");
        out.print("<tr><td>Cidade:</td><td><input type='text' name='city' value='"+vendedor.getCity()+"'/></td></tr>");
        out.print("<tr><td>Comiss�o:</td><td><input type='number' name='commission' value= '"+vendedor.getCommission()+"' /></ td ></ tr > ");
        out.print("<tr><td colspan='2'><input type='submit' value='Editar vendedor Salvar'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
