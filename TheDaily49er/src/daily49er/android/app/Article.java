package daily49er.android.app;

import java.util.ArrayList;
import java.util.List;

/*import com.facebook.android.*;
import com.facebook.android.Facebook.*;*/

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.widget.ArrayAdapter;
import daily49er.android.app.NewsTab;

public class Article extends ListActivity {
	//private List<Message> message;
//	private List<Message> messageList;
	NewsTab newsTab = new NewsTab();
	private Long num;
	String articleTitle;
	String articleUrl;
	String articleAuthor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		num = this.getIntent().getExtras().getLong("position");
		loadFeed();
	}
	
	/**
	 * Creates a context menu from /res/layout/menu_button.xml; the
	 * context menu will present the user options to share an article
	 * that is being currently viewed through Facebook, Twitter 
	 * and e-mail. 
	 * @param menu - the menu that will be created through the
	 * menu inflater.
	 * @return true - if menu has been inflated and shown.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		super.onCreateOptionsMenu(menu);
		/*
		 * Returns an instance of MenuInflater that we use to read
		 * the menu definition from menu_button.xml and turns it 
		 * into a "real view".
		 */
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu_button, menu);
		return true;
	}
	

	/**
	 * Perform the respective sharing actions for each type of service
	 * selected from the sharing context menu. 
	 * @param item - the button selected from the menu button.
	 * @return true - once the case's action has been completed (if applicable).
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch(item.getItemId()) 
		{ 
			case R.id.facebook_share:
				//Implementation:
				//
				return true;
			case R.id.twitter_share:
				//Implementation:
				//startActivity(new Intent(this, Twitter.class));
				return true;
			case R.id.email_share:
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "The Daily 49er: " + articleTitle);
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "\"" + articleTitle + "\"" + 
						" by " + articleAuthor + ": " + articleUrl);
				//Create a launcher to select which e-mail app to use in the case that there is more than one installed
				startActivity(Intent.createChooser(emailIntent, "Share your article through:"));
				return true;
		}
		return false;
	}
	
	private void loadFeed(){
		try{
			String temp;
			//FeedParser parser = FeedParserFactory.getParser();
			//messageList = parser.parse();
			List<String> titles = new ArrayList<String>(newsTab.messageList.size());
			//for (Message msg : message){
			String castLong = Long.toString(num);
			int index = Integer.parseInt(castLong);
			temp = newsTab.messageList.get(index).getDescription();
			articleTitle = newsTab.messageList.get(index).getTitle();
			articleUrl = newsTab.messageList.get(index).getLink().toString();
			articleAuthor = newsTab.messageList.get(index).getAuthor();
			int dotDotDot = temp.indexOf("...");
			temp = temp.replaceAll("&nbsp;", "");
			int disclaimer = temp.indexOf("Disclaimer:");
			temp = temp.substring(dotDotDot +3, disclaimer).trim();
			temp = "\t" + temp;
			titles.add(temp);
			//titles.add(n.messageList.get(n.messageList.).getDescription());
			//titles.add(Integer.toString(n.messageList.get(0).getOrder() - n.messageList.size()));
			//}
			ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, R.layout.row,titles);
			this.setListAdapter(adapter);

		}catch(Throwable t){
			Log.e("AndroidNews",t.getMessage(),t);
		}
	}
}
