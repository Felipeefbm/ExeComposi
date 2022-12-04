package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (dd/MM/yyyy): ");
		Date birthDate = sdf.parse(sc.next());                     
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();         //
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		System.out.print("How many items to this order? ");
		int item = sc.nextInt();
		
		for (int i = 1; i <= item; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderitem = new OrderItem(quantity, productPrice, new Product (productName, productPrice));
			order.addItem(orderitem);
			
		}
		
		
		System.out.println(order);
		
		
		
		
		sc.close();
	}

}
