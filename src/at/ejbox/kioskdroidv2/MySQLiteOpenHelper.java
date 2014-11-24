package at.ejbox.kioskdroidv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DB_VERSION = 1;

	// Database Name
	private static final String DB_NAME = "GoodsManager3.db";

	// Stock table name
	public static final String TABLE_STOCK = "stock";

	// Stock table column names
	public static final String KEY_BARCODE = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_QUANTITY = "quantity";
	public static final String KEY_PRICE = "price";

	public MySQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Create the database
		final String CREATE_STOCK_TABLE = "create table "+TABLE_STOCK+"("+KEY_BARCODE+" integer primary key autoincrement,"+KEY_NAME+ " text,"
				+KEY_DESCRIPTION+" text,"+KEY_QUANTITY+" integer,"+KEY_PRICE+" real" + ");";

		db.execSQL(CREATE_STOCK_TABLE);

		final int barcodeForDroid = 111111111;
		final String nameDroid = "Droid For Kids"; 
		final String descDroid = "Toy"; 
		final int quantityDroid = 342;
		final double priceDroid = 3.99;

		final int barcodeForTacosFrozen = 222222222;
		final String nameTacosFrozen = "Frozen Tacos"; 
		final String descTacosFrozen = "Frozen/Processed Food"; 
		final int quantityTacosFrozen = 813;
		final double priceTacosFrozen = 4.99;

		final int barcodeForDonerFrozen = 333333333;
		final String nameDonerFrozen = "Frozen Doner"; 
		final String descDonerFrozen = "Frozen/Processed Food"; 
		final int quantityDonerFrozen = 124;
		final double priceDonerFrozen = 4.99;
		
		final int barcodeForGouda = 444444444;
		final String nameGouda = "Gouda Cheese"; 
		final String descGouda = "Cheese"; 
		final int quantityGouda = 212;
		final double priceGouda = 1.59;

		final int barcodeForSalami = 555555555;
		String nameSalami = "Milano Salami"; 
		String descSalami = "Salami"; 
		int quantitySalami = 675;
		double priceSalami = 2.89;

		final String INSERT_DROID = "INSERT INTO " + TABLE_STOCK + " VALUES ("+barcodeForDroid+",'"+nameDroid+"','"+descDroid+"',"+quantityDroid+","
				+priceDroid+")";
		final String INSERT_TACOS = "INSERT INTO " + TABLE_STOCK + " VALUES ("+barcodeForTacosFrozen+",'"+nameTacosFrozen+"','"+descTacosFrozen+"',"
				+quantityTacosFrozen+","+priceTacosFrozen+")";
		final String INSERT_DONER = "INSERT INTO " + TABLE_STOCK + " VALUES ("+barcodeForDonerFrozen+",'"+nameDonerFrozen+"','"+descDonerFrozen+"',"
				+quantityDonerFrozen+","+priceDonerFrozen+")";
		final String INSERT_GOUDA = "INSERT INTO " + TABLE_STOCK + " VALUES ("+barcodeForGouda+",'"+nameGouda+"','"+descGouda+"',"
				+quantityGouda+","+priceGouda+")";
		final String INSERT_SALAMI = "INSERT INTO " + TABLE_STOCK + " VALUES ("+barcodeForSalami+",'"+nameSalami+"','"+descSalami+"',"
				+quantitySalami+","+priceSalami+")";

		db.execSQL(INSERT_DROID);
		db.execSQL(INSERT_TACOS);
		db.execSQL(INSERT_DONER);
		db.execSQL(INSERT_GOUDA);
		db.execSQL(INSERT_SALAMI);

		//			
		//			String barcodeForTomato = "555555555555";
		//			String barcodeForRedbull = "666666666666";
		//			String barcodeForOnion = "777777777777";
		//			String barcodeForPizzaFrozen = "888888888888";
		//			String barcodeForCocaCola = "999999999999";

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STOCK);
		onCreate(db);

	}
}
