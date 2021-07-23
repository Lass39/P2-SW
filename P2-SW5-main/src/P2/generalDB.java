package P2;

//@author 
//Giovanni Fernandes CB1640488

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class generalDB {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			String dbName = "p2?useTimezone=true&serverTimezone=UTC";
			String dbUsername = "root";
			String dbPassword = "adm123";
			Class.forName(dbDriver);

			connection = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println("-------------------------");
			System.out.println("-------------------------");
			System.out.println(e);
			System.out.println("-------------------------");
			System.out.println("-------------------------");

		}
		return connection;
	}
	
	public static int saveSalesman(salesman vendedor) 
  {
		int status = 0;
		try {
			Connection connection = generalDB.getConnection();
			PreparedStatement ps = connection.prepareStatement(

					"insert into salesman(name,city,commission) values (?,?,?)");
			ps.setString(1, vendedor.getName());
			ps.setString(2, vendedor.getCity());
			ps.setDouble(3, vendedor.getCommission());

			status = ps.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

  public static int updateSalesman(salesman vendedor)
  {
        int status = 0;
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(
            "update salesman set name=?,city=?,commission=? where salesman_id=?");
            ps.setString(1, vendedor.getName());
            ps.setString(2, vendedor.getCity());
            ps.setDouble(3, vendedor.getCommission());
            ps.setInt(4, vendedor.getId());

            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteSalesman(int id)
  {
        int status = 0;
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from salesman where salesman_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static salesman getSalesmanById(int id)
  {
        salesman vendedor = new salesman();
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from salesman where salesman_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                vendedor.setId(rs.getInt(1));
                vendedor.setName(rs.getString(2));
                vendedor.setCity(rs.getString(3));
                vendedor.setCommission(rs.getFloat(4));
            }
            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return vendedor;
  }

  public static List<salesman> getAllSalesmans()
  {
        List<salesman> list = new ArrayList<salesman>();

        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from salesman");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                salesman vendedor = new salesman();
                vendedor.setId(rs.getInt(1));
                vendedor.setName(rs.getString(2));
                vendedor.setCity(rs.getString(3));
                vendedor.setCommission(rs.getFloat(4));
                list.add(vendedor);
            }
            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }
	
	public static int saveCustomer(customer vendedor) 
  {
		int status = 0;
		try {
			Connection connection = generalDB.getConnection();
			PreparedStatement ps = connection.prepareStatement(

					"insert into customer(cust_name,city,grade,salesman_id) values (?,?,?,?)");
			ps.setString(1, vendedor.getCustName());
			ps.setString(2, vendedor.getCity());
			ps.setInt(3, vendedor.getGrade());
			ps.setInt(4, vendedor.getSalesmanId());

			status = ps.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
  
  public static int updateCustomer(customer vendedor)
  {
        int status = 0;
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(
            "update customer set cust_name=?,city=?,grade=?,salesman_id=? where customer_id=?");
            ps.setString(1, vendedor.getCustName());
		    ps.setString(2, vendedor.getCity());
		    ps.setInt(3, vendedor.getGrade());
		    ps.setInt(4, vendedor.getSalesmanId());
            ps.setInt(5, vendedor.getId());

            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteCustomer(int id)
  {
        int status = 0;
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from customer where customer_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static customer getCustomerById(int id)
  {
        customer vendedor = new customer();
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customer where customer_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                vendedor.setId(rs.getInt(1));
                vendedor.setCustName(rs.getString(2));
                vendedor.setCity(rs.getString(3));
                vendedor.setGrade(rs.getInt(4));
                vendedor.setSalesmanId(rs.getInt(5));
            }
            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return vendedor;
  }

  public static List<customer> getAllCustomers()
  {
        List<customer> list = new ArrayList<customer>();

        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                customer vendedor = new customer();
                vendedor.setId(rs.getInt(1));
                vendedor.setCustName(rs.getString(2));
                vendedor.setCity(rs.getString(3));
                vendedor.setGrade(rs.getInt(4));
                vendedor.setSalesmanId(rs.getInt(5));
                list.add(vendedor);
            }
            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }

	public static int saveOrder(order vendedor) 
  {
		int status = 0;
		try {
			Connection connection = generalDB.getConnection();
			PreparedStatement ps = connection.prepareStatement(

					"insert into orders(purch_amt,ord_date,customer_id,salesman_id) values (?,?,?,?)");
			ps.setDouble(1, vendedor.getPurchAmt());
			ps.setDate(2, (Date) vendedor.getOrdDate());
			ps.setInt(3, vendedor.getCustomerId());
			ps.setInt(4, vendedor.getSalesmanId());

			status = ps.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

  public static int updateOrder(order vendedor)
  {
        int status = 0;
        try
        {
        	Connection connection = generalDB.getConnection();
	        PreparedStatement ps = connection.prepareStatement(
	        "update orders set purch_amt=?,ord_date=?,customer_id=?,salesman_id=? where ord_no=?");
	        ps.setDouble(1, vendedor.getPurchAmt());
	        ps.setDate(2, (Date) vendedor.getOrdDate());
		    ps.setInt(3, vendedor.getCustomerId());
		    ps.setInt(4, vendedor.getSalesmanId());
            ps.setInt(5, vendedor.getOrdNo());

            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return status;
  }

  public static int deleteOrder(int id)
  {
        int status = 0;
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from orders where ord_no=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return status;
  }

  public static order getOrderById(int id)
  {
        order vendedor = new order();
        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from orders where ord_no=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                vendedor.setOrdNo(rs.getInt(1));
                vendedor.setPurchAmt(rs.getFloat(2));
                vendedor.setOrdDate(rs.getDate(3));
                vendedor.setCustomerId(rs.getInt(4));
                vendedor.setSalesmanId(rs.getInt(5));
            }
            connection.close();
        }
        catch (Exception ex) { ex.printStackTrace(); }

        return vendedor;
  }

  public static List<order> getAllOrders()
  {
        List<order> list = new ArrayList<order>();

        try
        {
            Connection connection = generalDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from orders");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                order vendedor = new order();
                vendedor.setOrdNo(rs.getInt(1));
                vendedor.setPurchAmt(rs.getFloat(2));
                vendedor.setOrdDate(rs.getDate(3));
                vendedor.setCustomerId(rs.getInt(4));
                vendedor.setSalesmanId(rs.getInt(5));
                list.add(vendedor);
            }
            connection.close();
        }
        catch (Exception e) { e.printStackTrace(); }

        return list;
  }

}
