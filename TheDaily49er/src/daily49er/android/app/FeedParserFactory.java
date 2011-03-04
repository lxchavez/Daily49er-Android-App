package daily49er.android.app;



public class FeedParserFactory {
	//static String feedUrl =  "http://rss.news.yahoo.com/rss/un";
	static String feedUrl =  "http://www.daily49er.com/se/daily-49er-rss-1.111?detailRSS=true";
	
	public static FeedParser getParser(){
		return new AndroidSaxFeedParser(feedUrl);
	}

}
