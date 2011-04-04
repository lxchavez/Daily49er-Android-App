package daily49er.android.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * This  is the implementation  for will handle sharing an article via 
 * e-mail by creating a new e-mail intent and launching the default 
 * e-mail application as set by the user. 
 * @author Alex Chavez
 */
public class EmailArticle extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Test subject");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "The message body."); 
		startActivity(Intent.createChooser(emailIntent, "Share your article through:"));
	}
	
}
