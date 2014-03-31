package com.discotech.sms;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class SmsPlugin extends CordovaPlugin{
	public static final  String ACTION_SEND_SMS = "openSmsView";
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Log.d("SMS Plugin", "Hello, this is a native function called from PhoneGap/Cordova!"); 
		try {
		    if (ACTION_SEND_SMS.equals(action)) { 
		        Intent calIntent = new Intent(Intent.ACTION_VIEW)
		        .setData(Uri.parse("sms:"))
		        .putExtra("sms_body", "Testing"); 
		             
		       this.cordova.getActivity().startActivity(calIntent);
		       callbackContext.success();
		       return true;
		    }
		    callbackContext.error("Invalid action");
		    return false;
		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage());
		    return false;
		} 
	}

}
