package daily49er.android.app;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsTab extends ListActivity 
{
	public static List<Message> messageList;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		getListView().setTextFilterEnabled(true);
		loadFeed();
	}
	
	public void loadFeed()
	{
		try
		{
			String title;
			FeedParser parser = FeedParserFactory.getParser();
			messageList = parser.parse();
			List<String> titles = new ArrayList<String>(messageList.size());
	    	for(Message msg : messageList)
	    	{
	    		title = msg.getTitle();
	    		title = title + " \nby " + msg.getAuthor();  
	    		titles.add(title);
	    	}
	   
	    	ArrayAdapter<String> adapter = 
	    		new ArrayAdapter<String>(this, R.layout.row,titles);
	    	this.setListAdapter(adapter);
		}
		catch (Throwable t)
		{
    		Log.e("Daily49er",t.getMessage(),t);
    	}
	}

	//This is what to do when an item from the list is clicked
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		Intent viewMessage = new Intent(this, Article.class);
		viewMessage.putExtra("position", id);
		this.startActivity(viewMessage);
		//Intent viewMessage = new Intent(Intent.ACTION_VIEW, 
		//Uri.parse(message.get(position).getLink().toExternalForm()));
		//this.startActivity(viewMessage);
		//Object o = this.getListAdapter().getItem(position);
		//String name = o.toString();
		//Toast.makeText(this, "Beachin' Software " + " " + name, Toast.LENGTH_LONG).show();
	}
}