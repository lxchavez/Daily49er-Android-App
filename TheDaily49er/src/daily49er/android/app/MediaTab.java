package daily49er.android.app;

	import android.app.ListActivity;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.ArrayAdapter;
	import android.widget.ListView;
	import android.widget.Toast;

	public class MediaTab extends ListActivity 
	{
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        
	        //this is what the layout of each item in the list will look like
	        setListAdapter(new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, VIDEOS)); 
	        getListView().setTextFilterEnabled(true);
	    }
	    
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
	    
	    //This is what to do when an item from the list is clicked
	    protected void onListItemClick(ListView l, View v, int position, long id) 
	    {
	    	super.onListItemClick(l, v, position, id);
	    	Object o = this.getListAdapter().getItem(position);
	    	String name = o.toString();
	    	Toast.makeText(this, "Beachin' Software " + " " + name, Toast.LENGTH_LONG).show();
	    }
	    
}