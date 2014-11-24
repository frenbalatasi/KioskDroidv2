package at.ejbox.kioskdroidv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler {
	// Database fields
	  private SQLiteDatabase db;
	  private MySQLiteOpenHelper dbHelper;
	  private String[] allColumns = { 
			  MySQLiteOpenHelper.KEY_BARCODE,
			  MySQLiteOpenHelper.KEY_NAME,
			  MySQLiteOpenHelper.KEY_DESCRIPTION,
			  MySQLiteOpenHelper.KEY_QUANTITY,
			  MySQLiteOpenHelper.KEY_PRICE
			  };

	  public DatabaseHandler(Context context) {
		  dbHelper = new MySQLiteOpenHelper(context);
	  }

	  public void open() throws SQLException {
		  db = dbHelper.getWritableDatabase();
	  }

	  public void close() {
		  dbHelper.close();
	  }
	  
	  // Updating quantity information of item in the database
	  public void updateQuantity(int barcode, int newQuantity) {
		  ContentValues values = new ContentValues();
		  values.put(MySQLiteOpenHelper.KEY_QUANTITY, newQuantity);

		  // updating row
		  db.update(MySQLiteOpenHelper.TABLE_STOCK, values, MySQLiteOpenHelper.KEY_BARCODE + " =?",
				  new String[] { String.valueOf(barcode) });
		}
	  
	  // Getting all items in the database
	  public StockItemList getAllItems() {
		    StockItemList items = new StockItemList();

		    Cursor cursor = db.query(MySQLiteOpenHelper.TABLE_STOCK,
		        allColumns, null, null, null, null, null);

		    cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
		      StockItem item = cursorToStockItem(cursor);
		      items.add(item);
		      cursor.moveToNext();
		    }
		    // make sure to close the cursor
		    cursor.close();
		    return items;
		    
	  }
	  
	  private StockItem cursorToStockItem(Cursor cursor) {
		    StockItem item = new StockItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getDouble(4));
		    return item;
	  }
	
}
