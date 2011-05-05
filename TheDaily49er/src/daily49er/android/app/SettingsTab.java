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

	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {		
        super.onCreate(savedInstanceState);
        //Reads the settings definition from XML and inflates it
        //into views in the current activity.
        //addPreferencesFromResource(R.xml.preferences);
    } //end onCreate()
} //end SettingsTab class