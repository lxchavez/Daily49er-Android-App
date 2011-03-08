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
	private List<Message> message;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		getListView().setTextFilterEnabled(true);
		setContentView(R.layout.list);
		loadFeed();
	}


	public void loadFeed(){
		try{
		FeedParser parser = FeedParserFactory.getParser();
		message = parser.parse();
		List<String> titles = new ArrayList<String>(message.size());
    	for (Message msg : message){
    		//titles.add(msg.getDescription());
    		titles.add(msg.getTitle());
    		//titles.add(msg.getDate());
    		//titles.add(msg.getAuthor());
    		//titles.add(msg.getP());
    	}
   
    	//String xml = writeXml();
    	//Log.i("AndroidNews", xml);
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

		//Intent viewMessage = new Intent(Intent.ACTION_VIEW, 
		//Uri.parse(message.get(position).getLink().toExternalForm()));
		//this.startActivity(viewMessage);
		
	}
	
	private String writeXml(){
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
			serializer.startDocument("UTF-8", true);
			serializer.startTag("", "messages");
			serializer.attribute("", "number", String.valueOf(message.size()));
			for (Message msg: message){
				serializer.startTag("", "message");
				serializer.attribute("", "date", msg.getDate());
				serializer.startTag("", "title");
				serializer.text(msg.getTitle());
				serializer.endTag("", "title");
				serializer.startTag("", "url");
				serializer.text(msg.getLink().toExternalForm());
				serializer.endTag("", "url");
				serializer.startTag("", "body");
				serializer.text(msg.getDescription());
				serializer.endTag("", "body");
				serializer.endTag("", "message");
			}
			serializer.endTag("", "messages");
			serializer.endDocument();
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

}
