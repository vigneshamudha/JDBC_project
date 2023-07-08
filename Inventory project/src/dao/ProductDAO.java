package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionManager.ConnectionManager;
import model.Product;

public class ProductDAO 
{
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		//1.Java and JDBC connect
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection(); 
		
		String sql_query = "insert into product(productId,productname,minCell,price,quantity) values (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductname());
		ps.setInt(3,product.getMinCell());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
		
		conm.closeConnection();
		
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		//1.Java and JDBC connect
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection(); 
		
		Statement st=con.createStatement();
		
		//ResultSet class - to convert the value from table and store in list
		ResultSet rt=st.executeQuery("select * from product");
		
		while(rt.next())
		{
			System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+" | "+rt.getInt("minCell")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity"));
		}
	}

}