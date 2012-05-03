package com.saarang;



import com.saarang.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IconView extends LinearLayout{
	public ImageButton icon ;
	public TextView   iconText ;
	
	public IconView(Context context)
	{
		this(context,null);
	}

	public IconView(Context context , AttributeSet attr) {
		super(context,attr);
		LayoutInflater inflater = LayoutInflater.from(context);
		inflater.inflate(R.layout.basic_icon, this);
		loadViews();
		
	}

	private void loadViews() {
		icon = (ImageButton)findViewById(R.id.icon);
		iconText = (TextView)findViewById(R.id.iconDescription);
		icon.setFocusable(false);
		icon.setFocusableInTouchMode(false);
		iconText.setFocusable(false);
		iconText.setFocusableInTouchMode(false);
	}
	
	
	public void setIconImage(int resId){
		icon.setImageResource(resId);
	}
	
	public void setIconDescriptionText(String description){
		iconText.setText(description);
	}
	
}
