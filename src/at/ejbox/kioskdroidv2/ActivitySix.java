package at.ejbox.kioskdroidv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivitySix extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_six);
		// Button Return
		 		ImageButton returnButton= (ImageButton) findViewById(R.id.imageButton2);
		 		returnButton.setOnClickListener(new View.OnClickListener() {
		 			public void onClick(View view) {
		 				Intent startMain= new Intent(getApplicationContext(), Main.class);
		 				startActivity(startMain);
		 			}
		 		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_six, menu);
		return true;
	}

}