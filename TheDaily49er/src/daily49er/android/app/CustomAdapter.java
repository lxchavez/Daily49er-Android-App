/*
 *	Copyright 2011 Alex Chavez, Punravee Cherngchaosil, Amanda Nguyen
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

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
				dt.setText(o.getDate() + "\n");
			}
			if(bt != null)
			{
				bt.setText("Category: " + o.getCategory() + "\n");
			}
			if(at != null){
				at.setText("\t" + o.getDescription());
			}
		} 
		
		return v;
	}
	

}
