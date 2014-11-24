package at.ejbox.kioskdroidv2;

public class Item {
	
	private int _barcode;
	private String _name;
	private int _quantity;
	private String _description;
	private double _price;

	public Item(int barcode, String name, String description, int quantity, double price) {
		_barcode = barcode;
		_name = name;
		_description = description;
		_quantity = quantity;
		_price = price;
	}
	
	//*****************************
	// Getters
	public int getBarcode() {
		return _barcode;
	}
	public String getName(){
		return _name;
	}
	public String getDescription(){
		return _description;
	}
	public int getQuantity(){
		return _quantity;
	}
	public double getPrice(){
		return _price;
	}
	//*****************************
	
	
	
	//*****************************
	// Setters
	public void setBarcode(int newBarcode){
		_barcode = newBarcode;
	}
	public void setName(String newName){
		_name = newName;
	}
	public void setDescription(String newDescription){
		_description = newDescription;
	}
	public void setQuantity(int newQuantity){
		_quantity = newQuantity;
	}
	public void setPrice(double newPrice){
		_price = newPrice;
	}
	//*****************************
	
	public void resetQuantity(){
		_quantity = 1;
	}

}
