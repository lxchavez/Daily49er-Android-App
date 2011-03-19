package daily49er.android.app;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;


public class Article extends ListActivity{
	//private List<Message> message;
	private List<Message> message;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		loadFeed();

	}
	private void loadFeed(){
		try{
			FeedParser parser = FeedParserFactory.getParser();
			message = parser.parse();
			List<String> titles = new ArrayList<String>(message.size());
			//for (Message msg : message){
			Message msg = message.get(0);
			titles.add(msg.getDescription());
			//}
			ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, R.layout.row,titles);
			this.setListAdapter(adapter);

		}catch(Throwable t){
			Log.e("AndroidNews",t.getMessage(),t);
		}
	}

}
