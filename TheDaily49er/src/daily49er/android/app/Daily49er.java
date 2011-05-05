/*
 *	Copyright 2011 Alex Chavez, Punravee Cherngchaosil, Amanda Nguyen
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

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
		/*Intent splashIntent = new Intent();
		splashIntent.setClassName("daily49er.android.app",
                "daily49er.android.app.SplashScreen");
		startActivity(splashIntent);*/
		
		//Continue on to create the main instance
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
	    intent = new Intent().setClass(this, ContactTab.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("Contact").setIndicator("Contact",
	    		res.getDrawable(R.drawable.ic_tab_contact)).setContent(intent);
	    tabHost.addTab(spec);

    }
}