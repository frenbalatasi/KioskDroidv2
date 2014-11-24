package at.ejbox.kioskdroidv2;


import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityScan extends Activity {
	
	Button enterBarcodeButton;
	EditText editTextGoodsID;
	EditText editTextQuantity;
	StockItemList listOfGoodsToBeShown;
    ListView listViewGoods;
    ItemAdapter adapter;
    DatabaseHandler dbHandler;
    StockItemList items;
    Button checkout;
    InputMethodManager imm;
    boolean isBarcodeInDatabase;
	boolean flag;
	SharedPreferences SP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_scan);
		
		// Database initiation
		dbHandler = new DatabaseHandler(getApplicationContext());
	    dbHandler.open();
	    items = dbHandler.getAllItems();
	    SP = getSharedPreferences("SettingsXML", MODE_PRIVATE);

	
	    String buttonClicked = SP.getString("buttonClicked", "default value");
	    
	    // Adapter, List to be shown, ListView
	    listOfGoodsToBeShown = new StockItemList();
	    listViewGoods = (ListView) findViewById(R.id.listViewGoods);
	    listViewGoods.setFocusable(true);
		adapter = new ItemAdapter(ActivityScan.this, R.layout.listview_item_row, listOfGoodsToBeShown);
		listViewGoods.setAdapter(adapter);
		
		for(int i = 0; i < items.size(); i++)
		{
			listOfGoodsToBeShown.add(items.get(i));
		}
		
		// EditText - Enter Barcode  button - Checkout button
		enterBarcodeButton = (Button) findViewById(R.id.buttonEnterBarcode);
		editTextGoodsID = (EditText) findViewById(R.id.editTextGoodID);
		ImageButton checkout = (ImageButton) findViewById(R.id.imageButton4);
		editTextQuantity = (EditText) findViewById(R.id.editTextNumberOfItem);
		
		
//		// If Check Stock is clicked
//		if(buttonClicked == "CheckStock") {
//			// Hide the virtual keyboard
//			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//			
//			// Disable EditText box
//			editTextGoodsID.setEnabled(false);
//			
//			// Disable Enter Barcode button
//			enterBarcodeButton.setEnabled(false);
//			enterBarcodeButton.setTextColor(Color.GRAY);
//			
//			checkout.setEnabled(false);
//			//checkout.setTextColor(Color.GRAY);
//			
//			for(int i = 0; i < items.size(); i++)
//			{
//				listOfGoodsToBeShown.add(items.get(i));
//				adapter.notifyDataSetChanged();
//			}
//		}
//		
//		if(buttonClicked == "GoodsReturned" || buttonClicked == "GoodsReceived"){
//			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//			
//			editTextGoodsID.setEnabled(false);
//			
//			enterBarcodeButton.setEnabled(false);
//			enterBarcodeButton.setTextColor(Color.GRAY);
//			
//			for(int i = 0; i < items.size(); i++)
//			{
//				listOfGoodsToBeShown.add(items.get(i));
//				listOfGoodsToBeShown.get(i).setQuantity(0);
//				adapter.notifyDataSetChanged();
//			}
//		}
//		
		// Button - Back
		ImageButton backButton= (ImageButton) findViewById(R.id.imageButton3);
		backButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityScan.this);

	            // Setting Dialog Title
	            alertDialog.setTitle("WARNING!");

	            // Setting Dialog Message
	            alertDialog.setMessage("Are you sure you want to abort the process?\nAll pending process here will be lost and this action cannot be undone!");

	            // Setting Icon to Dialog
	            alertDialog.setIcon(R.drawable.remove);

	            // Setting Positive "Yes" Button
	            alertDialog.setPositiveButton("YES",
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog,int which) {
	            				finish();
	                        }
	                    });
	            // Setting Negative "NO" Button
	            alertDialog.setNegativeButton("NO",
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int which) {
	                            dialog.cancel();
	                        }
	                    });

	            // Showing Alert Message
	            alertDialog.show();
			}
		});
		
		
		
		// clickListener for Enter Barcode button
//		enterBarcodeButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
//				imm.hideSoftInputFromWindow(editTextGoodsID.getWindowToken(), 0);
//				 
//				if(editTextGoodsID.getText().length() == 0){
//					Toast.makeText(getApplicationContext(), "You didn't enter any barcode! Please enter a valid barcode with 9-digits.", 
//							Toast.LENGTH_SHORT).show();
//				}
//				
//				if(editTextGoodsID.getText().length() < 9 && editTextGoodsID.getText().length() >= 1) {
//					Toast.makeText(getApplicationContext(), editTextGoodsID.getText().toString()+
//							" is invalid barcode! Please enter a valid barcode with 9-digits.", Toast.LENGTH_SHORT).show();
//				}
//				
//				if(editTextGoodsID.getText().length() == 9){
//					
//					for(int i = 0; i < items.size(); i++){
//						if(Integer.parseInt(editTextGoodsID.getText().toString()) == items.get(i).getBarcode()) {
//							Item itemToBeAdded = items.get(i);
//							itemToBeAdded.setQuantity(1);
//							//Toast.makeText(getApplicationContext(),"Quantity of item is: "+itemToBeAdded.getQuantity(), Toast.LENGTH_SHORT).show();
//							listOfGoodsToBeShown.add(itemToBeAdded);
//							adapter.notifyDataSetChanged();
//							//Toast.makeText(getApplicationContext(),"Totally new item is added!", Toast.LENGTH_SHORT).show();
//							break;
//						}
//					}				
//				}
//			}
//		});
		
		
		checkout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
//				Bundle bundle = new Bundle();
//				bundle.putParcelable("listOfGoodsToBeShown", listOfGoodsToBeShown);
				
				Intent checkout = new Intent(getApplicationContext(),Checkout.class);
				//checkout.putExtras(bundle);
				checkout.putParcelableArrayListExtra("listOfGoodsToBeShown", listOfGoodsToBeShown);
				startActivity(checkout);
			}
		});			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_scan, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
	    // Open the database again after resuming
		dbHandler.open();
	    super.onResume();
	  }
	
	@Override
	protected void onPause() {
		// Close the database before quitting the app
		dbHandler.close();
		super.onPause();
	  }
}
