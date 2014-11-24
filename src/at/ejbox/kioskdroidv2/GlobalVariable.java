package at.ejbox.kioskdroidv2;

public class GlobalVariable {
	
	private static Item item = null;
	

	public static Item getItem() {
		return item;
	}
	
	public static void setItem(Item newItem){
		item = newItem;
	}
	
	public static void resetItem(){
		item = null;
		System.gc();
	}

}
