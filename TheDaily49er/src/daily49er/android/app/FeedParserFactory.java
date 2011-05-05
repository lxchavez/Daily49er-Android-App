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

public class FeedParserFactory {
	//static String feedUrl =  "http://rss.news.yahoo.com/rss/un";
	//static String feedUrl = "http://alexchavez.net/daily-49er-rss-1.111.111";
	static String feedUrl =  "http://www.daily49er.com/se/daily-49er-rss-1.111?detailRSS=true";
	
	public static FeedParser getParser(){
		return new AndroidSaxFeedParser(feedUrl);
	}

}
