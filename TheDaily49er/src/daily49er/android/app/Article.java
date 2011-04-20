package daily49er.android.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.widget.ArrayAdapter;
import daily49er.android.app.NewsTab;
import java.util.ArrayList;
import java.util.List;

public class Article extends ListActivity
{
	NewsTab newsTab = new NewsTab();
	private Long articlePosition;
	String articleBody;
	String articleTitle;
	String articleUrl;
	String articleAuthor;
	String articleDate;
	String articleCategory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		articlePosition = this.getIntent().getExtras().getLong("position");
		loadFeed();
	} //end onCreate()
	
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
	} //end onCreateOptionsMenu()
	

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
				FacebookShare.setUrl(articleUrl);
				startActivity(new Intent(this, FacebookShare.class));
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
	} //end onOptionsSelected()
	
	
	/**
	 * Parse, format, and display title, category, publication date, and content of the article.
	 */
	private void loadFeed()
	{
		try
		{
			
			String castLong = Long.toString(articlePosition);
			int index = Integer.parseInt(castLong);
			
			articleBody = newsTab.messageList.get(index).getDescription();
			articleTitle = newsTab.messageList.get(index).getTitle();
			articleUrl = newsTab.messageList.get(index).getLink().toString();
			articleAuthor = newsTab.messageList.get(index).getAuthor();
			articleDate = newsTab.messageList.get(index).getDate();
			articleCategory = newsTab.messageList.get(index).getCategory();
			
			int dotDotDot = articleBody.indexOf("...");
			articleBody = articleBody.replaceAll("&nbsp;", "");
			int disclaimer = articleBody.indexOf("Disclaimer:");
			articleBody = "\n\n\t" + articleBody.substring(dotDotDot + 3, disclaimer).trim();

			Message newMessage = new Message();
			List<Message> titles = new ArrayList<Message>(newsTab.messageList.size());
			newMessage.setTitle(articleTitle);
			newMessage.setAuthor(articleAuthor);
			newMessage.setCategory(articleCategory);
			newMessage.setDescription(articleBody);
			newMessage.setDate(articleDate);
			titles.add(newMessage);
			ArrayAdapter<Message> adapter = new CustomAdapter(this, R.layout.article_page,titles);
			this.setListAdapter(adapter);

		}catch(Throwable t)
		{
			Log.e("AndroidNews",t.getMessage(),t);
		} //end try-catch
	} //end loadFeed()
} //end Article
