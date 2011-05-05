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
