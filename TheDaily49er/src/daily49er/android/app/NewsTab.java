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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsTab extends ListActivity 
{
	private static List<Message> messageList;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	
		//setContentView(android.R.layout.simple_list_item_1);
		//setListAdapter(new ArrayAdapter<String>(this,
				//android.R.layout.simple_list_item_1, VIDEOS));
		
		getListView().setTextFilterEnabled(true);
		loadFeed();
	}
	
	//leave it here for debugging purposes.
	static final String[] VIDEOS = new String[]{
    	"Preview of Video 1", 
    	"Preview of Video 2", 
    	"Preview of Video 3",
    	"Preview of Video 4",
    	"Preview of Video 5",
    	"Preview of Video 6",
    	"Preview of Video 7",
    	"Preview of Video 8",
    	"Preview of Video 9",
    	"Preview of Video 10"};

	public void loadFeed(){
		try{
		FeedParser parser = FeedParserFactory.getParser();
		messageList = parser.parse();
		List<String> titles = new ArrayList<String>(messageList.size());
    	for (Message msg : messageList){
    		//titles.add(msg.getDescription());
    		 titles.add(msg.getTitle());
    		 //titles.add(Integer.toString(msg.getOrder()));
    		//titles.add(msg.getDate());
    		//titles.add(msg.getAuthor());
    		//titles.add(msg.getP());
    	}
   
    	ArrayAdapter<String> adapter = 
    		new ArrayAdapter<String>(this, R.layout.row,titles);
    	this.setListAdapter(adapter);
		}
		catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}

	}

	//This is what to do when an item from the list is clicked
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		Intent viewMessage = new Intent(this,Article.class);
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
