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

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Message implements Comparable<Message>{
	static SimpleDateFormat FORMATTER = 
		new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
	private String title;
	private URL link;
	private String description;
	private String author;
	private String category;
	private Date date;
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author = author.trim();
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category.trim();
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title.trim();
	}
	// getters and setters omitted for brevity 
	public URL getLink() {
		return link;
	}
	
	public void setLink(String link) {
		try {
			this.link = new URL(link);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim().replaceAll("\\<.*?>", "");
	}

	public String getDate() {
		return FORMATTER.format(this.date);
	}

	public void setDate(String date) {
		// pad the date if necessary
		while (!date.endsWith("00")){
			date += "0";
		}
		try {
			this.date = FORMATTER.parse(date.trim());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: ");
		sb.append(title);
		sb.append('\n');
		sb.append("Date: ");
		sb.append(this.getDate());
		sb.append('\n');
		sb.append("Link: ");
		sb.append(link);
		sb.append('\n');
		sb.append("Description: ");
		sb.append(description);
		sb.append('\n');
		sb.append("Author :");
		sb.append(author);
		sb.append('\n');
		sb.append("Paragraph: ");
		sb.append("Category: ");
		sb.append('\n');
		return sb.toString();
	}
	
	public Message copy(){
		Message copy = new Message();
		copy.title = title;
		copy.link = link;
		copy.description = description;
		copy.date = date;
		copy.author = author;
		copy.category = category;
		return copy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0: author.hashCode());
		result = prime * result + ((category == null) ? 0: category.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if(author == null){
			if(other.author != null)
				return false;
		}else if(!author.equals(other.author))
			return false;
		if(category == null){
			if(other.category != null)
				return false;
		}else if(!category.equals(other.category))
			return false;
		return true;
	}

	public int compareTo(Message another){
		if(another == null) return 1;
		return another.date.compareTo(date);
	}
}
