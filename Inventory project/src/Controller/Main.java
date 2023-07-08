package Controller;

import java.sql.SQLException;

import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product; 

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner s=new Scanner(System.in);
		int choice,option;
		Login login=new Login();
		Product product=new Product();
		LoginDAO logindao=new LoginDAO();
		ProductDAO productdao=new ProductDAO();
		do
		{
			System.out.println();
			System.out.println("1. Admin");
			System.out.println("2. Agent");
			System.out.println("3. Exit");
			System.out.println("Enter your choise");
			choice =s.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println();
				System.out.println("You are selected Admin Login :-");
				s.nextLine();
				System.out.println("Enter your username");
				String username=s.nextLine();
				System.out.println("Enter your password");
				String password=s.nextLine();
				login.setUsername(username);
				login.setPassword(password);
				
				if(logindao.validate(login))
				{
					System.out.println("Login Successful..!!");
					System.out.println();
					do
					{
						System.out.println("1. Add Product");
						System.out.println("2. Display Project");
						System.out.println("3. Logout");
						System.out.println("Enter your option");
						option =s.nextInt();
						
						switch(option)
						{ 
						case 1:
							System.out.println();
							System.out.println("Your option is Add Product :-");
							System.out.println("Enter the Product Id :");
							int productId=s.nextInt();
							s.nextLine();
							System.out.println("Enter the Product Name :");
							String productname=s.nextLine();
							System.out.println("Enter the Minimum Cell Quantity :");
							int minCell=s.nextInt();
							System.out.println("Enter the price :");
							int price=s.nextInt();
							System.out.println("Enter the Quantity :");
							int quantity=s.nextInt();
							product.setProductId(productId);
							product.setProductname(productname);
							product.setMinCell(minCell);
							product.setPrice(price);
							product.setQuantity(quantity);
							productdao.addProduct(product);
							break;
						case 2:
							System.out.println("Your option is Display Project :-");
							System.out.println();
							productdao.display();
							break;
						case 3:	
							System.out.println("Logout Successfull..!!!");
							break;
						}
					}while(option!=3);
				}
				else
				{
					System.out.println("Login Failure");
				}
				break;
			case 2:
				System.out.println();
				System.out.println("You are selected Agent Login :-");
				s.nextLine();
				System.out.println("Enter your username1");
				String username1=s.nextLine();
				System.out.println("Enter your password1");
				String password1=s.nextLine();
				login.setUsername(username1);
				login.setPassword(password1);
				if(logindao.validate(login))
				{
					System.out.println("Login Successful..!!");
					System.out.println();
					do
					{
						System.out.println("1. Display Project");
						System.out.println("2. Logout");
						System.out.println("Enter your option");
						option =s.nextInt();
						switch(option)
						{ 
						case 1:
							System.out.println("Your option is  Display Project :-");
							System.out.println();
							productdao.display();
							break;
						case 2:	
							System.out.println("Logout Successful..!!");
							break;
						}
					}while(option!=2);
				}
				else
				{
					System.out.println("Login Failure");
				}
				break;
			case 3:	
				System.out.println("Exit..!");
				break;
				
			}
			
		}while(choice!=3);  //Exit condition
		
		

	}

}