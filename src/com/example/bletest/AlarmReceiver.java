package com.example.bletest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;
public class AlarmReceiver extends BroadcastReceiver {
	/*Context mContext;
	Vibrator mVibrator;
	public  AlarmReceiver (Context mcontext){
		this.mContext=mcontext;
	}*/
	
	@Override
	public void onReceive(Context context , Intent intent)
	{
		
		if(intent.getAction().equalsIgnoreCase("Repeat"));
			Toast.makeText(context, "該換點滴架了", Toast.LENGTH_SHORT).show();
			/*mVibrator= (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);
			mVibrator.vibrate(1000);*/
	}

}
