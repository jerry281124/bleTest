package com.example.bletest;

import java.security.PublicKey;






import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button bcallout, bsp, callAlarm,closeAlarm;
	NumberPicker picker;
	AlarmManager alarmManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		Toast.makeText(getApplicationContext(), "oncreate(1)", 100).show();
		bcallout = (Button) findViewById(R.id.button1);
		bsp = (Button) findViewById(R.id.button2);
		callAlarm = (Button) findViewById(R.id.button3);
		closeAlarm = (Button) findViewById(R.id.button4);
		picker = (NumberPicker)findViewById(R.id.numberPicker1);
		alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		
		picker.setMaxValue(60); 
		picker.setMinValue(0);
		picker.setValue(1);
		
		callAlarm.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				Intent intent;
				PendingIntent pendingIntent;
				intent =new Intent();
				intent.setClass(MainActivity.this, AlarmReceiver.class);
				intent.setAction("Repeat");
				pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+
						picker.getValue()*1000, picker.getValue()*1000 , pendingIntent);
			}
		});
		closeAlarm.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent;
				PendingIntent pendingIntent;
				intent =new Intent();
				intent.setClass(MainActivity.this, AlarmReceiver.class);
				intent.setAction("Repeat");
				pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
				alarmManager.cancel(pendingIntent);
			}
		});
		bcallout.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri number = Uri.parse("tel:0933759770");
                Intent dial = new Intent(Intent.ACTION_DIAL,number);
                startActivity(dial);
			}

		});
		bsp.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
                Intent callsecond = new Intent();
                callsecond.setClass(MainActivity.this, SecondActivity.class /*com.elecfreaks.bleexample.MainActivity.class*/);
                startActivity(callsecond);
			}

		});
	}

	protected void onDestory() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(),"onDestory(1)", 100).show();
	}
	protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(),"onPause(1)", 100).show();
	}
	protected void onRestart() {
        super.onRestart();;
        //Toast.makeText(getApplicationContext(),"onRestart(1)", 100).show();
	}
	protected void onResume() {
        super.onResume();;
        //Toast.makeText(getApplicationContext(),"onResume(1)", 100).show();
	}
	protected void onStart() {
        super.onStart();
        //Toast.makeText(getApplicationContext(),"onstart(1)", 100).show();
	}
	protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(),"onStop(1)", 100).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			//return true;
		}*/
		return super.onOptionsItemSelected(item);
	}
}
