package kots.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
	int id;
	int tableNo;
	Waiter waiter;
	String status;
	ArrayList<OrderRow> orderRows;
	
	
	
	public Order(int id, Waiter waiter) {
		super();
		this.id = id;
		this.waiter = waiter;		
		orderRows = new ArrayList<OrderRow>();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<OrderRow> getOrderRows() {
		return orderRows;
	}
	public void setOrderRows(ArrayList<OrderRow> orderRows) {
		this.orderRows = orderRows;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	
	
	
	
}
