package daily49er.android.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ContactTab extends Activity implements OnClickListener{
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.preferences);
		View videoButton = findViewById(R.id.contactButton);
		videoButton.setOnClickListener(this);
	}
	public void onClick(View view){
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 


	}

}
