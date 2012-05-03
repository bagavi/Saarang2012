package com.saarang;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SaarangActivity extends Activity {
	Button Events ;
	Button ProShow ;
	Button Hospitality ;
	Button Sponsors ;
	Button Finance ;
	public String dispval = "" ;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ProShow = (Button)findViewById(R.id.ProShow);
        Events = (Button)findViewById(R.id.Events);
        Finance = (Button)findViewById(R.id.Finance);
        Hospitality = (Button)findViewById(R.id.Hosipitality);
        Sponsors = (Button)findViewById(R.id.Sponsors);

        ProShow.setOnClickListener(ButtonListener);
        Events.setOnClickListener(ButtonListener);
        Finance.setOnClickListener(ButtonListener);
        Hospitality.setOnClickListener(ButtonListener);
        Sponsors.setOnClickListener(ButtonListener);

		
    }
    
	private OnClickListener ButtonListener = new OnClickListener(){
		@Override
		public void onClick(View v){
			Integer id = v.getId();
			dispval = id.toString();
			Log.v("test", dispval);
			Intent intent = new Intent(SaarangActivity.this , DepartmentActivity.class);		
			switch(id){
			case R.id.ProShow:
				intent.putExtra("DEP_NAME", "Proshow");
				intent.putExtra("DEP_ID", 1);
				//startActivity(intent);
				
				break;
			case R.id.Events:
				intent.putExtra("DEP_NAME", "Events");
				intent.putExtra("DEP_ID", 2);
				startActivity(intent);
				break;
				
			case R.id.Finance:
				intent.putExtra("DEP_NAME", "Finance");
				intent.putExtra("DEP_ID", 3);
				//startActivity(intent);
				break;
				
			case R.id.Hosipitality:
				intent.putExtra("DEP_NAME", "Hospitality");
				intent.putExtra("DEP_ID", 4);
				//startActivity(intent);
				break;
				
			case R.id.Sponsors:
				intent.putExtra("DEP_NAME", "Sponsors");
				intent.putExtra("DEP_ID", 5);
				//startActivity(intent);
				break;
				
			}
		}
	};
    
    public void onClick(View v){
    	
    }
	@Override
    public Dialog onCreateDialog(int id) {
		
	    AlertDialog.Builder timeDialog = new AlertDialog.Builder(this);
	    timeDialog.setTitle("Madher");
		timeDialog.setMessage(dispval);
	    return timeDialog.create();

}
 }