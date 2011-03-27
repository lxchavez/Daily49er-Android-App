package daily49er.android.app;

import android.webkit.WebViewClient;
import android.webkit.WebView;

public class RedirectHandling extends WebViewClient 
{
	RedirectHandling(WebView calendarView, String url)
	{
        shouldOverrideUrlLoading(calendarView, url);	
	}
	@Override
    public boolean shouldOverrideUrlLoading(WebView view, String theUrl)
    {
    	view.loadUrl(theUrl);
    	return true;
    }
}
