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