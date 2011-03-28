package daily49er.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

/**
 * The Events Tab is composed of the Daily49er's "Diversions" calendar which is
 * implemented via an embedded WebView.
 * @author Alex Chavez
 */
public class EventsTab extends Activity 
{
	//Create a new WebView object
	WebView calendarView;
	
	/**
	 * Creates a new instance of a WebView and opens the URL to the Daily49er's 
	 * "Diversions" Google Calendar.
	 * @param saveInstance - the saved instance of the application if it's been launched before
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        calendarView = new WebView(this);
        calendarView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.google.com/calendar/embed?src=alexchavez.net_3fv5fjm0lgiim" + 
        	"hlfpook3uicao@group.calendar.google.com&showTitle=0&showPrint=0&showTabs=0" + 
        	"&showCalendars=0&showTz=0&mode=AGENDA&pvttk=ea92bc8b7d59b0c16c464239ea4325ce" + 
        	"&gsessionid=OK";
        calendarView.setWebViewClient(new LoadPage(calendarView, url));
        setContentView(calendarView);
    }
    
    /**
     * This callback method will be called anytime a button is pressed while in the Events tab 
     * WebView; it will go back to a previous page in the webview.
     * @param keyCode - the key code that is passed whenever any of the standard device buttons are 
     * pressed.
     * @param keyEvent - the event that is triggered by the button press.
     * @return true - if the "back" button has been pressed; else return the event and keycode for
     * the button that was pressed.
     */
     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && calendarView.canGoBack()) 
        {
            calendarView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}