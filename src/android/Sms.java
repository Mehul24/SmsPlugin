package com.discotech.sms;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;

public class Sms extends CordovaPlugin{
	public static final  String ACTION_SEND_SMS = "openSmsView";
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
		    if (ACTION_SEND_SMS.equals(action)) { 
		             JSONObject arg_object = args.getJSONObject(0);
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
