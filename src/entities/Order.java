package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order(){
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//public List<OrderItem> getItems() {   (Longa historia)
	//	return items;						Não pode retornar uma  referencia direta pra lista
	//}										Quebra de integridade
	
	public void addItem(OrderItem item){     // Usar somente add e remove. Fazendo isso a lista ficará encapsulada/protegida. 
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem c: items) {
			sum += c.subTotal();
		}
		return sum;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Date moment = new Date();
		sb.append("Order moments: " + sdf2.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(getClient() + "\n");
		sb.append("Order items: \n");
		for (OrderItem c : items) {
			sb.append(c.toString());
			sb.append("\n");
		}
		
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
	
}
