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

@WebServlet("/ViewSalesman")
public class ViewSalesman extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addSalesman.html'>Adicionar vendendor</a>");
        out.println("<h1>Lista de Vendedores</h1>");
        
        List<salesman> list = generalDB.getAllSalesmans();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Nome</th><th>Cidade</th><th>Comiss�o</th><th>Editar</th><th>Excluir</th></tr>");
        for(salesman vendedor:list)
        {
            out.print("<tr><td>" + vendedor.getId() + "</td><td>" + vendedor.getName() + "</td><td> "+vendedor.getCity()+" </td><td> "+vendedor.getCommission()+" </td><td><a href = 'EditSalesman?salesman_id="+vendedor.getId()+"'> Editar </a></td><td><a href = 'DeleteSalesman?salesman_id="+vendedor.getId()+"'> Excluir </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}