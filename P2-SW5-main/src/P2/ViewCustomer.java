package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addCustomer.html'>Adicionar novo Cliente</a>");
        out.println("<h1>Clientes</h1>");
        
        List<customer> list = generalDB.getAllCustomers();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Nome</th><th>Cidade</th><th>Avalia��o</th><th>Vendedor</th><th>Editar</th><th>Excluir</th></tr>");
        for(customer vendedor:list)
        {
            out.print("<tr><td>" + vendedor.getId() + "</td><td>" + vendedor.getCustName() + "</td><td> "+vendedor.getCity()+" </td><td> "+vendedor.getGrade()+" </td><td> "+vendedor.getSalesmanId()+" </td><td><a href = 'EditCustomer?customer_id="+vendedor.getId()+"'> Editar </a></td><td><a href = 'DeleteCustomer?customer_id="+vendedor.getId()+"'> Excluir </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}
