package daily49er.android.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.facebook.android.*;
import com.facebook.android.Facebook.*;

/**
 * Implementation for posting an article to the user's Facebook "wall".
 * In order to make this class work, you'll need to create a new project that contains facebook SDK files
 * and reference it to this project.
 * @author Alex Chavez
 */
public class FacebookShare extends Activity
{	
	private static final String APP_ID = "152474111482866";	
	private static final String TOKEN = "access_token";
    private static final String EXPIRES = "expires_in";
    private static final String KEY = "facebook-credentials";
    private static final String[] PERMISSIONS = new String[] {"publish_stream"};
    private static String articleUrl;
	
    //Declare a new facebook object
	Facebook facebook;
	
	/**
	 * The URL is set in Article.java as it is the ciurrent article being viewed.
	 * @param url - the URL that will be posted in the user's Facebook wall.
	 */
    public static void setUrl(String url)
    {
    	articleUrl = url;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        facebook = new Facebook(APP_ID);
        //Restore the previously stored credentials, if any, from the SharedPreferences of the app
        restoreCredentials(facebook);
        updateStatus();
    }
    
	/**
     * Creates and displays a Facebook dialog with the URL set; the dialog gives
     * the user the option to enter a message into the text field.
     */
    public void updateStatus()
    {
        saveCredentials(facebook);
        Bundle bundle = new Bundle();
        bundle.putString("link", articleUrl);
        facebook.dialog(this, "stream.publish", bundle, new WallPostDialogListener());
    }

    /**
     * No clue what this does, it's used by the Facebook API.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
        super.onActivityResult(requestCode, resultCode, data);
        facebook.authorizeCallback(requestCode, resultCode, data);
    }
    
    /**
     * A custom listener for all wall post dialogues created and displayed to the user.
     * @author Steffen Luypaert (http://integratingstuff.com/category/web-services/facebook/)
     */
	class WallPostDialogListener implements DialogListener 
	{
		/**
		 * If there is a post ID (meaning a post was successfully posted to the user's facebook wall), then display
		 * a toast message with confirmation; else state otherwise.
		 * @param values - any values set for the dialogue; consists of the user's entered message (may be null)
		 * and the article URL.
		 */
		public void onComplete(Bundle values) 
		{
			final String postId = values.getString("post_id");
    		if (postId != null) showToast("Message posted to your facebook wall!"); 
    		else showToast("Wall post cancelled.");
            finish();
        }
		
	    /**
	     * Display the user a toast message that that something went wrong with the
	     * Facebook API and end the FacebookShare activity.
	     * @param e - Error given by the Facebook API
	     */
		public void onFacebookError(FacebookError e) 
		{
			showToast("Failed to post to wall!");
			finish();
		}
		
	    /**
	     * Display the user a toast message that the posting of a dialogue has failed
	     * and end the FacebookShare activity.
	     * @param e - Error given by the dialogue
	     */
		public void onError(DialogError e) 
		{
			showToast("Failed to post to wall!");
			finish();
		}
		
		/**
		 * Display the user a toast message that the posting of a dialogue has registered
		 * the dialogue cancellation and end the FacebookShare activity.
		 */
		public void onCancel() 
		{
			showToast("Wall post cancelled!");
			finish();
		}
    } //end class WallPostDialogListener()
	
	/**
	 * A custom listener for all events related to facebook authentication.
	 * @author Steffen Luypaert (http://integratingstuff.com/category/web-services/facebook/)
	 */
	class LoginDialogListener implements DialogListener 
	{
		/**
		 * Saves the user's authenticated Facebook credentials for later use and posts the
		 * article URL to the user's Facebook "wall".
		 * @param values - any values that have been set (at this point, there aren't any set)
		 */
	    public void onComplete(Bundle values) 
	    {
	    	saveCredentials(facebook);
	    	updateStatus();
		}

	    /**
	     * Display the user a toast message that authentication has failed and end the
	     * FacebookShare activity.
	     * @param error - Error given by the Facebook API
	     */
	    public void onFacebookError(FacebookError error) 
	    {
	    	showToast("Authentication with Facebook failed!");
	        finish();
	    }
	    
	    /**
	     * Display the user a toast message that authentication has failed and end the
	     * FacebookShare activity.
	     * @param error - Error given by the facebook dialogue.
	     */
	    public void onError(DialogError error) 
	    {
	    	showToast("Authentication with Facebook failed!");
	        finish();
	    }
	    
	    /**
	     * Display the user a toast message that authentication has been cancelled by
	     * the user of Facebook API and end the FacebookShare activity.
	     * @param error - Error given by the cancellation of an authentication session
	     */
	    public void onCancel() 
	    {
	    	showToast("Authentication with Facebook cancelled!");
	        finish();
	    }
	} //end class LoginDialogListener()

	/**
	 * Display a custom toast message (a popup message) to the user.
	 * @param message - a message that the toast message will consist of.
	 */
	private void showToast(String message)
	{
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * Saves the user's authenticated Facebook login credentials.
	 * @param facebook - an instantiated facebook object
	 * @return the saved credentials
	 */
	public boolean saveCredentials(Facebook facebook) 
	{
    	Editor editor = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
    	editor.putString(TOKEN, facebook.getAccessToken());
    	editor.putLong(EXPIRES, facebook.getAccessExpires());
    	return editor.commit();
	}
	
	/**
	 * Retrieve and restore the user's Facebook login credentials from the app's shared preferences.
	 * @param facebook - an instantiated facebook object
	 * @return a boolean indicating if the stored login credentials are valid
	 */
	public boolean restoreCredentials(Facebook facebook) 
	{
    	SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY, Context.MODE_PRIVATE);
    	facebook.setAccessToken(sharedPreferences.getString(TOKEN, null));
    	facebook.setAccessExpires(sharedPreferences.getLong(EXPIRES, 0));
    	return facebook.isSessionValid();
	}
	
} //end FacebookShare class