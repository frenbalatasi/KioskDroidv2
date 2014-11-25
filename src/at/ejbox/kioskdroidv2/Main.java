package at.ejbox.kioskdroidv2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Main extends Activity{
	
	SharedPreferences SP;
    SharedPreferences.Editor SPE;
    String buttonClicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		SP = getSharedPreferences("SettingsXML", MODE_PRIVATE);
		
		// Button for Cash In Kiosk
		ImageButton buttoncash = (ImageButton) findViewById(R.id.imagebuttoncash);
		buttoncash.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				//GlobalVariable.setButtonClicked("CashInKiosk");
				SPE = SP.edit();
				SPE.putString("buttonClicked", "CashInKiosk");
				SPE.commit();
				Intent startOne= new Intent(getApplicationContext(), ActivityScan.class);
				startActivity(startOne);
			}
		});
		
		// Button for Goods Received
		ImageButton buttongoods = (ImageButton) findViewById(R.id.imagebuttongoods);
		buttongoods.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				//GlobalVariable.setButtonClicked("GoodsReceived");
				SPE = SP.edit();
				SPE.putString("buttonClicked", "GoodsReceived");
				SPE.commit();
				Intent startTwo= new Intent(getApplicationContext(), ActivityScan.class);
				startActivity(startTwo);
			}
		});
		
		// Button for Goods Returned
		ImageButton buttonreturned = (ImageButton) findViewById(R.id.imagebuttonreturned);
		buttonreturned.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				//GlobalVariable.setButtonClicked("GoodsReturned");
				SPE = SP.edit();
				SPE.putString("buttonClicked", "GoodsReturned");
				SPE.commit();
				Intent startThree= new Intent(getApplicationContext(), ActivityScan.class);
				startActivity(startThree);
			}
		});
		// Button for Check Stock
		ImageButton buttoncheck = (ImageButton) findViewById(R.id.imagebuttoncheck);
		buttoncheck.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				//GlobalVariable.setButtonClicked("CheckStock");
				SPE = SP.edit();
				SPE.putString("buttonClicked", "CheckStock");
				SPE.commit();
				Intent startFour= new Intent(getApplicationContext(), ActivityScan.class);
				startActivity(startFour);
			}
		});		
		
		
		
		
		
		// Button for Info
		ImageButton buttoninfo = (ImageButton) findViewById(R.id.imagebuttoninfo);
		buttoninfo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent startFive= new Intent(getApplicationContext(), ActivityFive.class);
				startActivity(startFive);
			}
		});
		
		// Button for About
		ImageButton buttonabout = (ImageButton) findViewById(R.id.imagebuttonabout);
		buttonabout.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent startSix= new Intent(getApplicationContext(), ActivitySix.class);
				startActivity(startSix);
			}
		});
	}

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
