package com.saarang;

/*

 * This activtiy displays the coord info..
 * This Activity can be used in various ways.. very versatile
 * Major functions
 * 		It can fetch Coord details for a given evetn( through EventId)
 * 		If not even id is given ,fetches all coord details
 * It fetches the coord details in a cursor and then displays it in a list and
 * each item in the list when clicked opens dialogue box which gives him three options 
 */
import java.io.IOException;

import com.saarang.adapter_database.CordListAdapter;
import com.saarang.adapter_database.DatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CordListActivity extends ListActivity {
	public int eventId;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		eventId = extras.getInt("eventId", -1);
		// Log.e is used for debugging, please use it (Standard method)
		Log.e("Test", "Entered Coord List Activity");
		Log.e("list Activity ", "event Id " + eventId);

		DatabaseHelper myDbHelper = new DatabaseHelper(this);
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("database not created");
		}
		myDbHelper.openDataBase();

		Cursor cursor;
		// Fetch all coords if the event id is -1(implies no event is specified)
		if (eventId == -1) {
			cursor = myDbHelper.fetchAllCords();
		}
		// Fetch Coord details of the given event id
		else {
			cursor = myDbHelper.fetchCordDetails(eventId);
		}
		startManagingCursor(cursor);
		CordListAdapter adapter = new CordListAdapter(this, cursor);
		this.setListAdapter(adapter);

	}

	/*
	 * This is a standard function implermented
	 * When a particular coord name is clicked, a dialogue box opens It gives
	 * option to call , message
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		TextView phoneView = (TextView) v.findViewById(R.id.cordphone);
		String phone = (String) phoneView.getText();

		final String uri = "tel:" + phone;
		final String messageUri = "sms:" + phone;

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to call or message the coordinator?")
				.setCancelable(true).setPositiveButton("Call",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent intent = new Intent(Intent.ACTION_CALL,
										Uri.parse(uri));
								startActivity(intent);
							}
						}).setNegativeButton("Message",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent intent = new Intent(Intent.ACTION_VIEW,
										Uri.parse(messageUri));
								startActivity(intent);
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
