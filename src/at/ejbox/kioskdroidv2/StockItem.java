package at.ejbox.kioskdroidv2;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

public class StockItem implements Parcelable {

	private int _barcode;
	private String _name;
	private int _quantity;
	private String _description;
	private double _price;
	
	// Constructors
	public StockItem(int barcode, String name, String description, int quantity, double price) {
		_barcode = barcode;
		_name = name;
		_description = description;
		_quantity = quantity;
		_price = price;
	}
	
	public StockItem(int barcode, String name, int quantity){
		_barcode = barcode;
		_name = name;
		_quantity = quantity;
		_description = "";
		_price = 0.0;
	}
	
	public StockItem(int barcode, int quantity){
		_barcode = barcode;
		_name = "";
		_quantity = quantity;
		_description = "";
		_price = 0.0;
	}
	
	public StockItem(int barcode, String name){
		_barcode = barcode;
		_name = name;
		_quantity = 1;
		_description = "";
		_price = 0.0;
	}
	
	public StockItem(int barcode){
		_barcode = barcode;
		_name = "";
		_quantity = 1;
		_description = "";
		_price = 0.0;
	}
	
	public StockItem(){
		super();
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
	
	@SuppressWarnings("unused")
    public StockItem(Parcel in) {
        this();
        readFromParcel(in);
    }
	
	private void readFromParcel(Parcel in) {
        _barcode = in.readInt();
        _name = in.readString();
        _description = in.readString();
        _quantity = in.readInt();
        _price = in.readDouble();
    }
	
	public static final Parcelable.Creator<StockItem> CREATOR = new Parcelable.Creator<StockItem>() {
        public StockItem createFromParcel(Parcel in) {
            return new StockItem(in);
        }

        public StockItem[] newArray(int size) {
            return new StockItem[size];
        }
    };
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_barcode);
        dest.writeString(_name);
        dest.writeString(_description);
        dest.writeInt(_quantity);
        dest.writeDouble(_price);
    }

}
