package kot.system;

import java.util.ArrayList;
import java.util.Scanner;

import kots.classes.*;

public class KOTWaiterApp {
	private static int orderID = 0;
	private ArrayList<Item> menu;
	private Waiter waiter;
	private ArrayList<Order> orders;
	
	public KOTWaiterApp() {
		menu = new ArrayList<Item>();
		menu.add(new Item(1,"Rice", "This is rice", 150.0));
		menu.add(new Item(2,"Hoppers", "This is Hoppers", 50.0));
		menu.add(new Item(3,"Pasta", "This is Pasta", 250.0));
		menu.add(new Item(4,"Noodles", "This is Noodles", 200.0));
		menu.add(new Item(5,"Kottu", "This is Kottu", 50.0));
		
		waiter = new Waiter(1, "Jack");
		orders = new ArrayList<Order>();
		
		
		
	}
	public void run() {
		takeOrder();
		
		displayOrder(orders.get(0));
		
		editOrder(orders.get(0));
		
		placeOrder(orders.get(0));
		
	}
	
	private void takeOrder() {
		Order order =  new Order(orderID++, this.waiter);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter table no. : ");
		order.setTableNo(scanner.nextInt());
		
		char ch = 0;
		do{
			OrderRow orderRow = new OrderRow();
			
			// get item number and set item;
			System.out.println("Enter item no. :");
			orderRow.setItem(getItem(scanner.nextInt()));
			
			// get quantity and set
			System.out.println("Enter quantity : ");
			orderRow.setQuantity(scanner.nextInt());
			
			order.getOrderRows().add(orderRow);
			
			System.out.println("Do you want to add more item? (y/n)? : ");
			ch = scanner.next().charAt(0);
			
			
		}while(ch!= 'n');
		
		System.out.println("Order taken.");
		orders.add(order);
		
	}

	private Item getItem(int id) {
		for(Item item: menu) {
			if(item.getId() == id) {
				return item;
			}				
		}
		return null;
	}
	
	private void displayOrder(Order order) {
		System.out.println("ID : " + order.getId());
		System.out.println("Status : " + order.getStatus());
		System.out.println("Waiter : " + order.getWaiter().getName());
		System.out.println("Table No. : " + order.getTableNo());
		System.out.println("Item List...");
		int rowNo = 1;
		for(OrderRow row : order.getOrderRows()) {
			
			System.out.print(""+ rowNo++ + ". " +row.getItem().getName());
			System.out.print("\t" + row.getQuantity());
			System.out.println();
		}		
	}
	
	private void editOrder(Order order) {
		Scanner scanner = new Scanner(System.in);
		int line = 0;
		char choice = 0;
		do {
			displayOrder(order);
			System.out.println("Enter line number to edit.");
			line = scanner.nextInt() - 1;
			System.out.println("Do you want to (d)delete or (c)change quantity? (Enter d or c)");
			char ch = scanner.next().charAt(0);
			
			if(ch=='d') {
				order.getOrderRows().remove(line);
			}
			else if(ch=='c') {
				System.out.println("Enter quantity...");
				order.getOrderRows().get(line).setQuantity(scanner.nextInt());
			}
			
			System.out.println("Do you want to edit more item?");
			choice = scanner.next().charAt(0);
		}while(choice != 'n');
	}
	
	private void placeOrder(Order order) {
		
		order.setStatus("Waiting");
		
		// add to database
		
		System.out.println("Order added to queue. STATUS: Waiting");
	}
	
	private void checkOrderStatus() {
				
	}

}
