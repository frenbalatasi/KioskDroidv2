package at.ejbox.kioskdroidv2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class Checkout extends Activity {

    public void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_checkout);
            
            Bundle bundle = getIntent().getExtras();
            //StockItemList list = bundle.getParcelable("listOfGoodsToBeShown");
            StockItemList list = getIntent().getParcelableExtra("listOfGoodsToBeShown");
            
            ListView listViewToBeShown = new ListView(getApplicationContext());
            listViewToBeShown = (ListView) findViewById(R.id.listViewKiosk);
            
            
            ItemAdapter adapter = new ItemAdapter(Checkout.this, R.layout.listview_item_row, list);
            listViewToBeShown.setAdapter(adapter);
                     
     		// Button Return
     		ImageButton returnButton= (ImageButton) findViewById(R.id.imageButtonBack);
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
		getMenuInflater().inflate(R.menu.checkout, menu);
		return true;
	}

}

