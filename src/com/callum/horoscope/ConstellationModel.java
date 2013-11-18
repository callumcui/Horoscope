package com.callum.horoscope;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ConstellationModel {

	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description = null;

	public static final String mainConstellationImageview = "mainConstellationImageview";
	public static final String mainConstellationTextview = "mainConstellationTextview";

	//constellation name
	public static final String aries = "Aries";
	public static final String taurus = "Taurus";
	public static final String gemini = "Gemini";
	public static final String cancer = "Cancer";
	public static final String leo = "Leo";
	public static final String virgo = "Virgo";
	public static final String libra = "Libra";
	public static final String scorpio = "Scorpio";
	public static final String sagittarius = "Sagittarius";
	public static final String capricorn = "Capricorn";
	public static final String aquarius = "Aquarius";
	public static final String pisces = "Pisces";
	
	//daily category name
	public static final String daily_category_horoscope ="Daily Horoscope";
	public static final String daily_category_extended ="Daily Extended Horoscopes";
	public static final String daily_category_singles ="Daily Single's LoveScopes";
	public static final String daily_category_couples ="Daily Couple's LoveScopes";
	public static final String daily_category_quickie ="Daily Quickie";
	public static final String daily_category_finance ="Daily FinanceScopes";
	public static final String daily_category_business ="Daily CareerScopes";
	public static final String daily_category_chinese ="Daily ChineseScopes";
	public static final String daily_category_food ="Daily FoodScopes";
	public static final String daily_category_beauty ="Daily BeautyScopes";
	public static final String daily_category_mom ="Daily MomScopes";
	public static final String daily_category_teen ="Daily TeenScopes";
	public static final String daily_category_flirt ="Daily Flirt";
	public static final String daily_category_home_and_garden ="Daily HomeScopes";
	public static final String daily_category_green ="Daily GreenScopes";
	public static final String daily_category_astro_slam ="Daily AstroSlam";
	public static final String daily_category_gay ="Daily GayScopes";
	public static final String daily_category_lesbian ="Daily LesbianScopes";
	public static final String daily_category_dog ="Daily DogScopes";
	public static final String daily_category_cat ="Daily CatScopes";
	public static final String daily_category_love ="Cosmic Calendar";
	
	public static final String DAILY_CATEGORY_NAME = "DailyCategoryName";
	public static final String DAILY_CATEGORY_IMAGE = "DailyCategoryImage";
	
	public static String getRSSURLByDailyCategoryName(String name)
	{
		String url = null;
		
		if (name.equals(daily_category_horoscope))
		{
			url = "http://www.astrology.com/horoscopes/daily-horoscope.rss";
		}else if (name.equals(daily_category_extended ))
		{
			url="http://www.astrology.com/horoscopes/daily-extended.rss";
		}else if (name.equals(daily_category_singles ))
		{
			url="http://www.astrology.com/horoscopes/daily-singles.rss";
		}else if (name.equals(daily_category_couples ))
		{
			url="http://www.astrology.com/horoscopes/daily-couples.rss";
		}else if (name.equals(daily_category_quickie ))
		{
			url="http://www.astrology.com/horoscopes/daily-quickie.rss";
		}else if (name.equals(daily_category_finance ))
		{
			url="http://www.astrology.com/horoscopes/daily-finance.rss";
		}else if (name.equals(daily_category_business ))
		{
			url="http://www.astrology.com/horoscopes/daily-work.rss";
		}else if (name.equals(daily_category_chinese ))
		{
			url="http://www.astrology.com/horoscopes/daily-chinese.rss";
		}else if (name.equals(daily_category_food ))
		{
			url="http://www.astrology.com/horoscopes/daily-food.rss";
		}else if (name.equals(daily_category_beauty ))
		{
			url="http://www.astrology.com/horoscopes/daily-beauty.rss";
		}else if (name.equals(daily_category_mom ))
		{
			url="http://www.astrology.com/horoscopes/daily-mom.rss";
		}else if (name.equals(daily_category_teen ))
		{
			url="http://www.astrology.com/horoscopes/daily-teen.rss";
		}else if (name.equals(daily_category_flirt ))
		{
			url="http://www.astrology.com/horoscopes/daily-flirt.rss";
		}else if (name.equals(daily_category_home_and_garden ))
		{
			url="http://www.astrology.com/horoscopes/daily-home-and-garden.rss";
		}else if (name.equals(daily_category_green ))
		{
			url="http://www.astrology.com/horoscopes/daily-green.rss";
		}else if (name.equals(daily_category_astro_slam ))
		{
			url="http://www.astrology.com/horoscopes/daily-astro-slam.rss";
		}else if (name.equals(daily_category_gay ))
		{
			url="http://www.astrology.com/horoscopes/daily-gay.rss";
		}else if (name.equals(daily_category_lesbian ))
		{
			url="http://www.astrology.com/horoscopes/daily-lesbian.rss";
		}else if (name.equals(daily_category_dog ))
		{
			url="http://www.astrology.com/horoscopes/daily-dog.rss";
		}else if (name.equals(daily_category_cat ))
		{
			url="http://www.astrology.com/horoscopes/daily-cat.rss";
		}else if (name.equals(daily_category_love ))
		{
			url="http://www.astrology.com/horoscopes/cosmic-calendar.rss";
		}
		
		return url;
		
	}
	
		public static List<Map<String,Object>> getDailyCategoryList()
	{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
		
		//name map
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put(DAILY_CATEGORY_NAME, daily_category_horoscope );
		map1.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_horoscope );
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put(DAILY_CATEGORY_NAME, daily_category_extended );
		map2.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_extended );
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put(DAILY_CATEGORY_NAME, daily_category_singles );
		map3.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_singles );
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put(DAILY_CATEGORY_NAME, daily_category_couples );
		map4.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_couples );
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put(DAILY_CATEGORY_NAME, daily_category_quickie );
		map5.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_quickie );

		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put(DAILY_CATEGORY_NAME, daily_category_finance );
		map6.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_finance );
		
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put(DAILY_CATEGORY_NAME, daily_category_business );
		map7.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_business );
		
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put(DAILY_CATEGORY_NAME, daily_category_chinese );
		map8.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_chinese );
		
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put(DAILY_CATEGORY_NAME, daily_category_food );
		map9.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_food );
		
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put(DAILY_CATEGORY_NAME, daily_category_beauty );
		map10.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_beauty );
		
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put(DAILY_CATEGORY_NAME, daily_category_mom );
		map11.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_mom );
		
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put(DAILY_CATEGORY_NAME, daily_category_teen );
		map12.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_teen );

		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put(DAILY_CATEGORY_NAME, daily_category_flirt );
		map13.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_flirt );
		
		Map<String, Object> map14 = new HashMap<String, Object>();
		map14.put(DAILY_CATEGORY_NAME, daily_category_home_and_garden );
		map14.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_home_and_garden );
		
		Map<String, Object> map15 = new HashMap<String, Object>();
		map15.put(DAILY_CATEGORY_NAME, daily_category_green );
		map15.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_green );
		
		Map<String, Object> map16 = new HashMap<String, Object>();
		map16.put(DAILY_CATEGORY_NAME, daily_category_astro_slam);
		map16.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_astro_slam);
		
		Map<String, Object> map17 = new HashMap<String, Object>();
		map17.put(DAILY_CATEGORY_NAME, daily_category_gay );
		map17.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_gay );
		
		Map<String, Object> map18 = new HashMap<String, Object>();
		map18.put(DAILY_CATEGORY_NAME, daily_category_lesbian );
		map18.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_lesbian );
		
		Map<String, Object> map19 = new HashMap<String, Object>();
		map19.put(DAILY_CATEGORY_NAME, daily_category_dog );
		map19.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_dog );
		
		Map<String, Object> map20 = new HashMap<String, Object>();
		map20.put(DAILY_CATEGORY_NAME, daily_category_cat );
		map20.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_cat );

		Map<String, Object> map21 = new HashMap<String, Object>();
		map21.put(DAILY_CATEGORY_NAME, daily_category_love );
		map21.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_love );
		//==============================================================
		
		/*Map<String, Object> map18 = new HashMap<String, Object>();
		map18.put(DAILY_CATEGORY_NAME, daily_category_man );
		map18.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_man );

		
		Map<String, Object> map22 = new HashMap<String, Object>();
		map22.put(DAILY_CATEGORY_NAME, daily_category_sun );
		map22.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_sun );

		
		Map<String, Object> map24 = new HashMap<String, Object>();
		map24.put(DAILY_CATEGORY_NAME, daily_category_woman );
		map24.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_woman );

		Map<String, Object> map25 = new HashMap<String, Object>();
		map25.put(DAILY_CATEGORY_NAME, daily_category_work );
		map25.put(DAILY_CATEGORY_IMAGE, R.drawable.daily_category_work );*/
		
		
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		list.add(map6);
		list.add(map7);
		list.add(map8);
		list.add(map9);
		list.add(map10);
		list.add(map11);
		list.add(map12);
		list.add(map13);
		list.add(map14);
		list.add(map15);
		list.add(map16);
		list.add(map17);
		list.add(map18);
		list.add(map19);
		list.add(map20);
		list.add(map21);
		
		return list;
	}

	public static List<ConstellationModel> parseDailyXML(
			InputStream inputStream, String encode)
			throws XmlPullParserException, IOException {
		List<ConstellationModel> list = null;
		ConstellationModel model = null;

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser();
		parser.setInput(inputStream, encode);
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				list = new ArrayList<ConstellationModel>();
				break;
			case XmlPullParser.START_TAG:
				if ("item".equals(parser.getName())) {
					model = new ConstellationModel();
				} else if ("title".equals(parser.getName()) && model != null) {
					String currentName = parser.nextText();
					// constellationDailyList.add(new
					// constellationModel(currentName, null));
					int endIndex = currentName.indexOf(" ");
					if (endIndex != -1) {
						currentName = currentName.substring(0, endIndex);
					}
					model.setName(currentName);
				} else if ("description".equals(parser.getName())
						&& model != null) {
					String description = parser.nextText();
					int start = description.indexOf("<p>") + "<p>".length();
					int end = description.indexOf("</p>");
					if (start != -1 && end != -1) {
						description = description.substring(start, end);
					}
					model.setDescription(description);
				}
				break;
			case XmlPullParser.END_TAG:
				if ("item".equals(parser.getName()) && model != null) {
					list.add(model);
					model = null;
				}
				break;

			}
			eventType = parser.next();
		}

		return list;
	}

	public static int getImageViewByConstellationName(String name)
	{
		if (name.equals(aries)) {
			return R.drawable.m_aries;
		} else if (name.equals(taurus)) {
			return R.drawable.m_taurus;
		} else if (name.equals(gemini)) {
			return R.drawable.m_gemini;
		} else if (name.equals(cancer)) {
			return R.drawable.m_cancer;
		} else if (name.equals(leo)) {
			return R.drawable.m_leo;
		} else if (name.equals(virgo)) {
			return R.drawable.m_virgo;
		} else if (name.equals(libra)) {
			return R.drawable.m_libra;
		} else if (name.equals(scorpio)) {
			return R.drawable.m_scorpio;
		} else if (name.equals(sagittarius)) {
			return R.drawable.m_sagittarius;
		} else if (name.equals(capricorn)) {
			return R.drawable.m_capricorn;
		} else if (name.equals(aquarius)) {
			return R.drawable.m_aquarius;
		} else if (name.equals(pisces)) {
			return R.drawable.m_pisces;
		} else {
			return R.drawable.m_aries;
		}
	}
	
	
	public static String getDateByConstellationName(String name) {
		if (name.equals(aries)) {
			return "March 21 - April 19";
		} else if (name.equals(taurus)) {
			return "April 20 - May 20";
		} else if (name.equals(gemini)) {
			return "May 21 - June 20";
		} else if (name.equals(cancer)) {
			return "June 21 - July 22";
		} else if (name.equals(leo)) {
			return "July 23 - August 22";
		} else if (name.equals(virgo)) {
			return "August 23 - September 22";
		} else if (name.equals(libra)) {
			return "September 23 - October 22";
		} else if (name.equals(scorpio)) {
			return "October 23 - November 21";
		} else if (name.equals(sagittarius)) {
			return "November 22 - December 21";
		} else if (name.equals(capricorn)) {
			return "December 22 - January 19";
		} else if (name.equals(aquarius)) {
			return "January 20 - February 18";
		} else if (name.equals(pisces)) {
			return "February 19 - March 20";
		} else {
			return null;
		}

	}

	public static ArrayList<Integer> getConstellationImageList() {

		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(R.drawable.m_aries);
		data.add(R.drawable.m_taurus);
		data.add(R.drawable.m_gemini);
		data.add(R.drawable.m_cancer);
		data.add(R.drawable.m_leo);
		data.add(R.drawable.m_virgo);
		data.add(R.drawable.m_libra);
		data.add(R.drawable.m_scorpio);
		data.add(R.drawable.m_sagittarius);
		data.add(R.drawable.m_capricorn);
		data.add(R.drawable.m_aquarius);
		data.add(R.drawable.m_pisces);

		return data;
	}

	public static ArrayList<String> getConstellationNameList() {
		ArrayList<String> data = new ArrayList<String>();

		data.add(aries);
		data.add(taurus);
		data.add(gemini);
		data.add(cancer);
		data.add(leo);
		data.add(virgo);
		data.add(libra);
		data.add(scorpio);
		data.add(sagittarius);
		data.add(capricorn);
		data.add(aquarius);
		data.add(pisces);

		return data;

	}

}
