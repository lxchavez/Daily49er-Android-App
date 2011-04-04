package daily49er.android.app;

import java.util.ArrayList;
import java.util.List;
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
	private List<Message> messageList;
	private Long num;
	String articleTitle = "";
	String articleUrl = "";
	String articleAuthor = "";
	
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
	 * that is being currently viewed via Facebook, Twitter and E-mail
	 * sharing options. 
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch(item.getItemId()) 
		{ 
			case R.id.facebook_share:
				//Implementation:
				//startActivity(new Intent(this, Facebook.class));
				return true;
			case R.id.twitter_share:
				//Implementation:
				//startActivity(new Intent(this, Twitter.class));
				return true;
			case R.id.email_share:
				//Implementation:
				//startActivity(new Intent(this, EmailArticle.class));
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "The Daily 49er: " + articleTitle);
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "\"" + articleTitle + "\"" + 
						" by " + articleAuthor + ": " + articleUrl); 
				startActivity(Intent.createChooser(emailIntent, "Share your article through:"));
				return true;
		}
		return false;
	}
	
	private void loadFeed(){
		try{
			String temp;
			FeedParser parser = FeedParserFactory.getParser();
			messageList = parser.parse();
			List<String> titles = new ArrayList<String>(messageList.size());
			//for (Message msg : message){
			String castLong = Long.toString(num);
			int index = Integer.parseInt(castLong);
			temp = messageList.get(index).getDescription();
			articleTitle = messageList.get(index).getTitle();
			articleUrl = messageList.get(index).getLink().toString();
			articleAuthor = messageList.get(index).getAuthor();
			int dot = temp.indexOf("...");
			temp = temp.replaceAll("&nbsp;", "");
			int disclaimer = temp.indexOf("Disclaimer:");
			temp = temp.substring(dot+3, disclaimer).trim();
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
