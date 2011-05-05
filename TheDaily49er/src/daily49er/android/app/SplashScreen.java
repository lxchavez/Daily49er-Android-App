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

import android.app.Activity;
import android.os.Bundle;

/**
 * This class creates a new thread for running the splash screen on the start
 * of the application.
 * @author Alex Chavez
 */
public class SplashScreen extends Activity
{
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.splash);
      Thread splashThread = new Thread() 
      {
         
          /**
           * Run the splash screen for a total of 3 seconds. We should improve this
           * to stay in the splash screen while loading/parsing the RSS feed.
           */
    	  @Override
          public void run() 
          {
             try 
             {
                int waited = 0;
                while (waited < 3000) 
                {
                   sleep(100);
                   waited += 100;
                }
             } 
             catch (InterruptedException e) 
             {
                //Do nothing
             } 
             finally 
             {
                finish();
             }
          }
       };
       splashThread.start();
   } //end onCreate()
} //end SplashScreen class