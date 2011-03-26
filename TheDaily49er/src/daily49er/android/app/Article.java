package daily49er.android.app;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import daily49er.android.app.NewsTab;
public class Article extends ListActivity {
	//private List<Message> message;
	private List<Message> messageList;
	private Long num;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		num = this.getIntent().getExtras().getLong("position");
		loadFeed();
	}
	private void loadFeed(){
		try{
			FeedParser parser = FeedParserFactory.getParser();
			messageList = parser.parse();
			List<String> titles = new ArrayList<String>(messageList.size());
			//for (Message msg : message){
			String castLong = Long.toString(num);
			int index = Integer.parseInt(castLong);
			titles.add(messageList.get(index).getDescription());
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
