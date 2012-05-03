package com.saarang;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class DepartmentActivity extends ListActivity {
	String dispval;
	private int eventId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IconAdapter iconadapter = new IconAdapter(this);
		setListAdapter(iconadapter);
		Log.e("List populated", "Adapter set");

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.coordlist:
			Bundle extras = new Bundle();
			extras.putInt("eventId", this.eventId);
			Intent in = new Intent(this, CordListActivity.class);
			in.putExtras(extras);
			startActivity(in);
			break;

		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public Dialog onCreateDialog(int id) {

		AlertDialog.Builder timeDialog = new AlertDialog.Builder(this);
		timeDialog.setTitle("Madher");
		timeDialog.setMessage(dispval);
		return timeDialog.create();
	}
}