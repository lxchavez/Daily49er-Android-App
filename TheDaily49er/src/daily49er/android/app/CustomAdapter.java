package daily49er.android.app;


import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
public class CustomAdapter extends ArrayAdapter<Message>{
	private List<Message> items;
	
	public CustomAdapter(Context context, int textViewResourceId, List<Message> titles) 
	{
		super(context, textViewResourceId, titles);
		this.items = titles;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View v = convertView;
		if (v == null) 
		{
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.article_page, null);
		}
	
		Message o = items.get(position);
		
		if (o != null) 
		{
			TextView tt = (TextView) v.findViewById(R.id.titleview);
			TextView mt = (TextView) v.findViewById(R.id.authorview);
			TextView bt = (TextView) v.findViewById(R.id.categoryview);
			TextView at = (TextView) v.findViewById(R.id.articleview);
			TextView dt = (TextView) v.findViewById(R.id.authorview);	
			
			if (tt != null) 
			{
				tt.setText(o.getTitle());
			}
			if(mt != null)
			{
				mt.setText(o.getAuthor());
			}
			if(dt != null)
			{
				dt.setText(o.getDate());
			}
			if(bt != null)
			{
				bt.setText(o.getCategory());
			}
			if(at != null){
				at.setText(o.getDescription());
			}
		} 
		
		return v;
	}
	

}
