package com.saarang;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.saarang.gallery_manager;


public class IconAdapter extends BaseAdapter{
	
	public Context c;
	public ImageButton icon;
	public TextView iconText ;
	public int eventId ;
	gallery_manager IconData = new gallery_manager();	
	public IconAdapter(Context c)
	{
		this(c,0);
		this.c = c;
	}
	public IconAdapter(Context c , int event_id)
	{
		eventId = event_id;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		
		IconView iconview = new IconView(c);
		iconview.setIconImage(IconData.EventCategoryID[position]);
		iconview.setIconDescriptionText(IconData.EventCategoryText[position]);
		iconview.setOnClickListener(new OnItemClickListener(position)); 
		return iconview ;
	}
	
	
	@Override
	public int getCount() {
    	return IconData.EventCategoryID.length;
	}
	@Override
	public Object getItem(int arg0) {

		return arg0;
	}
	@Override
	public long getItemId(int arg0) {

		return arg0;
	}
	
	private class  OnItemClickListener implements OnClickListener {
		
		private int mposition;
		
		public OnItemClickListener(int position) {
			mposition = position;
		}	
		
		@Override
		public void onClick(View arg0) {
			Log.e("click problems",""+mposition);
		}
		
	}
}

