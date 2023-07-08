package model;

public class Product 
{
	private int productId;
	private String productname;
	private int minCell;
	private int price;
	private int quantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getMinCell() {
		return minCell;
	}
	public void setMinCell(int minCell) {
		this.minCell = minCell;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {  
		this.quantity = quantity;
	}
}