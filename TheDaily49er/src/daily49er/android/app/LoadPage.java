package daily49er.android.app;

import android.webkit.WebViewClient;
import android.webkit.WebView;

/**
 * Opens the URL for a WebView page.
 * @author Alex Chavez
 */
public class LoadPage extends WebViewClient 
{
	LoadPage(WebView calendarView, String url)
	{
        shouldOverrideUrlLoading(calendarView, url);	
	}
	

	/**
	 * Gives the application control of the WebView intent to stay in the application and
	 * not open a seperate page.
	 * @param view - The WebView object that will load a web page.
	 * @param theUrl - The URL of the web page to be loaded.
	 */
	@Override
    public boolean shouldOverrideUrlLoading(WebView view, String theUrl)
    {
    	view.loadUrl(theUrl);
    	return true;
    }
}
