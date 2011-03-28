package daily49er.android.app;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
 
/**
 * The 'Settings' tab for the application.
 * @author Alex Chavez
 */
public class SettingsTab extends PreferenceActivity 
{
	//Option names and default values
	private static final String TWITTER_SHARE_DEF = "enableTwitter";
	private static final boolean TWITTER_SHARE_ENABLE = true;
	private static final String FACEBOOK_SHARE_DEF = "enableFacebook";
	private static final boolean FACEBOOK_SHARE_ENABLE = true;

	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {		
        super.onCreate(savedInstanceState);
        //Reads the settings definition from XML and inflates it
        //into views in the current activity.
        addPreferencesFromResource(R.xml.preferences);
    } //end onCreate()
	
	//Get the current Twitter sharing preference
	public static boolean getTwitterOption(Context context)
	{
		return PreferenceManager.getDefaultSharedPreferences(context)
			.getBoolean(TWITTER_SHARE_DEF, TWITTER_SHARE_ENABLE);
	}
	
	//Get the current Facebook sharing preference
	public static boolean getFacebookOption(Context context)
	{
		return PreferenceManager.getDefaultSharedPreferences(context)
			.getBoolean(FACEBOOK_SHARE_DEF, FACEBOOK_SHARE_ENABLE);
	}
	
	
} //end SettingsTab class