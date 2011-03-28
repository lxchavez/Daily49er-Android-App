package daily49er.android.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * The 'Settings' tab for the application.
 * @author Alex Chavez
 */
public class SettingsTab extends PreferenceActivity 
{
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        //Reads the settings definition from XML and inflates it into views in the current activity
        addPreferencesFromResource(R.xml.preferences);
    } //end onCreate
} //end SettingsTab class