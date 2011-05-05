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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseFeedParser implements FeedParser {
	// names of the XML tags
	static final String CHANNEL = "channel";
	static final String PUB_DATE = "pubDate";
	static final String DESCRIPTION = "description";
	static final String LINK = "link";
	static final String TITLE = "title";
	static final String ITEM = "item";
	static final String AUTHOR = "author";
	static final String CATEGORY = "category";
	
	private final URL feedUrl;
	
	protected BaseFeedParser(String feedUrl){
		try {
			//set the URL link by the parameter string.
			this.feedUrl = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	protected InputStream getInputStream() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
