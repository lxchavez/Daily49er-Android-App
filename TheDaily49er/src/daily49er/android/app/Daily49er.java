package daily49er.android.app;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TabHost;


public class Daily49er extends TabActivity
{
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		//Create a new intent to launch the splash screen
		Intent splashIntent = new Intent();
		splashIntent.setClassName("daily49er.android.app",
                "daily49er.android.app.SplashScreen");
		startActivity(splashIntent);
		
		//Continue on to creat the main instance
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Reusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, NewsTab.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("news").setIndicator("News",
	    		res.getDrawable(R.drawable.ic_tab_home)).setContent(intent);
	    tabHost.addTab(spec);
	        	    
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, MediaTab.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("media").setIndicator("Media",
	    		res.getDrawable(R.drawable.ic_tab_media)).setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, EventsTab.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("events").setIndicator("Events",
	                      res.getDrawable(R.drawable.ic_tab_events))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, SettingsTab.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("settings").setIndicator("Settings",
	                      res.getDrawable(R.drawable.ic_tab_settings))
	                  .setContent(intent);
	    tabHost.addTab(spec);

    }
}