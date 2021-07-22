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

@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='addOrder.html'>Adicionar Pedido</a>");
        out.println("<h1>Lista de Pedidos</h1>");
        
        List<order> list = generalDB.getAllOrders();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Nome do Pedido</th><th>Valor do Pedido</th><th>Data da Compra</th><th>Cliente</th><th>Vendedor</th><th>Editar</th><th>Excluir</th></tr>");
        for(order vendedor:list)
        {
            out.print("<tr><td>" + vendedor.getOrdNo() + "</td><td>" + vendedor.getPurchAmt() + "</td><td> "+vendedor.getOrdDate()+" </td><td> "+vendedor.getCustomerId()+" </td><td> "+vendedor.getSalesmanId()+" </td><td><a href = 'EditOrder?ord_no="+vendedor.getOrdNo()+"'> Editar </a></td><td><a href = 'DeleteOrder?ord_no="+vendedor.getOrdNo()+"'> Excluir </a></td></tr> ");
        }
        out.print("</table>");
        
        out.close();
    }
}