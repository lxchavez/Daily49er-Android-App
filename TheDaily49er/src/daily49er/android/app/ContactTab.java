package daily49er.android.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ContactTab extends Activity implements OnClickListener{
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.contact_tab);
		View videoButton = findViewById(R.id.contactButton);
		videoButton.setOnClickListener(this);
	}
	
	public void onClick(View view)
	{
		String aEmailList[] = {"alex@alexchavez.net"};
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "The Daily 49er App Issues/Comments");
		//Create a launcher to select which e-mail app to use in the case that there is more than one installed
		startActivity(Intent.createChooser(emailIntent, "Share your article through:")); 
	}
}
