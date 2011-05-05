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

import java.io.IOException;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * The media tab contains two buttons selection, "Video" and "Podcast".
 * When a button is clicked, it redirects the user to the phone's default media viewer application
 * for the user to view the respective content.
 */
public class MediaTab extends Activity implements OnClickListener
{

	//almost done, just have to change UI to make it more interesting.
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.media);
        
        //set up click listeners for all the buttons
        View videoButton = findViewById(R.id.videoButton);
        videoButton.setOnClickListener(this);
        View podcastButton = findViewById(R.id.podcastButton);
        podcastButton.setOnClickListener(this);
                
    }
    
    public void onClick(View view){
    	if(view.getId() == R.id.videoButton){
    	       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/user/videod49er")));
    	}
    	else{
 	       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/user/audiod49er")));

    	}
    }
    
	    
}
