package daily49er.android.app;

import com.facebook.android.Facebook;

import android.app.Activity;
import android.os.Bundle;

import winterwell.jtwitter.*;
import oauth.signpost.*;

public class TwitterShare extends Activity
{
	private final String JTWITTER_OAUTH_KEY = "";
	private final String JTWITTER_OAUTH_SECRET = "";
	
    /** Called when the activity is first created. **/
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Make an oauth client
    	OAuthSignpostClient oauthClient = new OAuthSignpostClient(JTWITTER_OAUTH_KEY, 
    			JTWITTER_OAUTH_SECRET, "oob");
    	
    	oauthClient.authorizeDesktop();	
    	
    	System.out.println("");
    } //end onCreate()

}