package daily49er.android.app;



public class FeedParserFactory {
	static String feedUrl =  "http://rss.news.yahoo.com/rss/un";
	
	public static FeedParser getParser(){
		return new AndroidSaxFeedParser(feedUrl);
	}

}
