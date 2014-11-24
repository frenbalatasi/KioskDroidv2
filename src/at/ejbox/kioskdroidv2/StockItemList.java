package at.ejbox.kioskdroidv2;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class StockItemList extends ArrayList<StockItem> implements Parcelable{
	
	private static final long serialVersionUID = 663585476779879096L;
	
	public StockItemList() {
		
	}
	
	@SuppressWarnings("unused")
    public StockItemList(Parcel in) {
        this();
        readFromParcel(in);
    }
	
	private void readFromParcel(Parcel in) {
        this.clear();

        // First we have to read the list size
        int size = in.readInt();

        for (int i = 0; i < size; i++) {
            StockItem si = new StockItem(in.readInt(),in.readString(),in.readString(),in.readInt(),in.readDouble());
            this.add(si);
        }
    }
	
	public static final Parcelable.Creator<StockItemList> CREATOR = new Parcelable.Creator<StockItemList>() {
        public StockItemList createFromParcel(Parcel in) {
            return new StockItemList(in);
        }

        public StockItemList[] newArray(int size) {
            return new StockItemList[size];
        }
    };

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		int size = this.size();

        // We have to write the list size, we need him recreating the list
        dest.writeInt(size);

        for (int i = 0; i < size; i++) {
            StockItem si = this.get(i);
            
            dest.writeInt(si.getBarcode());
            dest.writeString(si.getName());
            dest.writeString(si.getDescription());
            dest.writeInt(si.getQuantity());
            dest.writeDouble(si.getPrice());

        }
		
	}

}
