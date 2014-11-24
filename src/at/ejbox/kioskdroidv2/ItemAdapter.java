package at.ejbox.kioskdroidv2;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdapter extends ArrayAdapter<StockItem>{
	
	Context _context; 
    int _layoutResourceId;    
    ArrayList<StockItem> _data;
    InputMethodManager imm;
    ItemHolder holder;
    int _position;
    StockItem item;
    
    public ItemAdapter(Context context, int layoutResourceId, StockItemList data) {
    	super(context,layoutResourceId, data);
    	
        _layoutResourceId = layoutResourceId;
        _context = context;
        _data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        holder = null;
        _position = position;
        item = _data.get(_position);
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)_context).getLayoutInflater();
            row = inflater.inflate(_layoutResourceId, parent, false);
            
            holder = new ItemHolder();
            //holder.barcode = (TextView)row.findViewById(R.id.textViewBarcode);
            holder.nameOfItem = (TextView)row.findViewById(R.id.textViewNameOfItem);
            holder.numOfItem = (EditText)row.findViewById(R.id.editTextNumberOfItem);
            holder.removeIcon = (ImageView)row.findViewById(R.id.imageViewRemoveIcon);
            holder.removeIcon.setTag(position);
            
//            //item.setQuantity(_data.get(_position).getQuantity());
//            
//            if(GlobalVariable.getButtonClicked() == "CheckStock") {
//            	holder.numOfItem.setText(Integer.toString(item.getQuantity()));
//            	holder.removeIcon.setVisibility(View.INVISIBLE);
//            	holder.numOfItem.setClickable(false);
//            	holder.numOfItem.setCursorVisible(false);
//            	holder.numOfItem.setFocusable(false);
//            	holder.numOfItem.setFocusableInTouchMode(false);
//            }
//            if (GlobalVariable.getButtonClicked() == "CashInKiosk") {
//            	holder.numOfItem.setVisibility(View.INVISIBLE);
//            }
//            
//            if(GlobalVariable.getButtonClicked() == "GoodsReturned" || GlobalVariable.getButtonClicked() == "GoodsReceived") {
//            	holder.removeIcon.setVisibility(View.INVISIBLE);
//            	holder.numOfItem.setText("0");
//            }
           
            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
//            holder.numOfItem.setTag(item);
        }
        
        
        
        holder = (ItemHolder)row.getTag();
        holder.numOfItem.setId(_position);
        holder.removeIcon.setId(_position);
        holder.numOfItem.setTag(position);
       
        
        holder.nameOfItem.setText(item.getName());
        holder.numOfItem.setText(Integer.toString(item.getQuantity()));	
        holder.removeIcon.setImageResource(R.drawable.remove);
        
        holder.removeIcon.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				final int position = view.getId();
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(_context);

	            // Setting Dialog Title
	            alertDialog.setTitle("WARNING!");

	            // Setting Dialog Message
	            alertDialog.setMessage("Are you sure you want to delete this item: "+_data.get(position).getName()+"?");

	            // Setting Icon to Dialog
	            alertDialog.setIcon(R.drawable.remove);

	            // Setting Positive "Yes" Button
	            alertDialog.setPositiveButton("YES",
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog,int which) {
	                        	_data.remove(position);
	            				notifyDataSetChanged();
	                        	//Toast.makeText(_context, "Item has been deleted at the position: "+position, Toast.LENGTH_SHORT).show();
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
        
        
        holder.numOfItem.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    final int position = v.getId();
                    final EditText NumOfItem = (EditText) v;
                    
                    //Toast.makeText(_context, "Selected item in the position: "+position+" and quantity is: "+NumOfItem.getText().toString(), Toast.LENGTH_SHORT).show();
                    _data.get(position).setQuantity(Integer.parseInt(NumOfItem.getText().toString()));
                    //Toast.makeText(_context,"Quantity is changed to "+_data.get(position).getQuantity(), Toast.LENGTH_SHORT).show();
                    
                }
            }
        });
        
        return row;
    }
    
    static class ItemHolder
    {
        TextView barcode;
        TextView nameOfItem;
        EditText numOfItem;
        ImageView removeIcon;
        
    }
}



