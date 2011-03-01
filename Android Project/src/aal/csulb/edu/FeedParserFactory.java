package aal.csulb.edu;

public abstract class FeedParserFactory {
	//static String feedUrl = "http://rss.news.yahoo.com/rss/un";
	static String feedUrl = "http://www.daily49er.com/se/daily-49er-rss-1.111?detailRSS=true";
	
	public static FeedParser getParser(){
		return getParser(ParserType.ANDROID_SAX);
	}
	
	public static FeedParser getParser(ParserType type){
		switch (type){
			case SAX:
				return new SaxFeedParser(feedUrl);
			case DOM:
				return new DomFeedParser(feedUrl);
			case ANDROID_SAX:
				return new AndroidSaxFeedParser(feedUrl);
			case XML_PULL:
				return new XmlPullFeedParser(feedUrl);
			default: return null;
		}
	}
	

}
