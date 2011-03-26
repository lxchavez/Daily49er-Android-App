package daily49er.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * The Events Tab is composed of the Daily49er's "Diversions" calendar.
 * @author Alex Chavez
 */
public class EventsTab extends Activity 
{
	/**
	 * Creates a new instance of a WebView and opens ir 
	 */
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        WebView calendarView = new WebView(this);
        calendarView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.google.com/calendar/embed?src=alexchavez.net_3fv5fjm0lgiimhlfpook3uicao@group.calendar.google.com&showTitle=0&showPrint=0&showTabs=0&showCalendars=0&showTz=0&mode=AGENDA&pvttk=ea92bc8b7d59b0c16c464239ea4325ce&gsessionid=OK";
        Toast.makeText(getApplicationContext(), "Loading Events Calendar...", Toast.LENGTH_SHORT).show();
        calendarView.setWebViewClient(new RedirectHandling(calendarView, url));
        setContentView(calendarView);
    }
}