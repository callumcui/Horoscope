package com.callum.horoscope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HoroDailyXMLHandler extends DefaultHandler {

	private HashMap<String, String> map = null;
	private List<HashMap<String, String>> list = null;

	
	private List<ConstellationModel> constellationDailyList = new ArrayList<ConstellationModel>();
	// item-> title, item->description
	private String itemNode = "item";
	private String itemTitleNode = "title";
	private String itemDescriptionNode = "pubDate";

	private Boolean isReachedItemNode = false;
	private Boolean isReachedItemTitleNode = false;
	private Boolean isReachedItemDescriptionNode = false;

	private String currentName = null;
	private String currentContent = null;

	public List<ConstellationModel> getList() {
		return constellationDailyList;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		// super.startDocument();
		constellationDailyList = new ArrayList<ConstellationModel>();

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equals(itemNode)) {
			isReachedItemNode = true;
		}
		if (isReachedItemNode && qName.equals(itemTitleNode)) {
			isReachedItemTitleNode = true;
		}
		if (isReachedItemNode && qName.equals(itemDescriptionNode)) {
			isReachedItemDescriptionNode = true;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (isReachedItemNode) {
			
			if (isReachedItemTitleNode) {
				currentName = new String(ch, start, length);
				//constellationDailyList.add(new constellationModel(currentName, null));
				int endIndex = currentName.indexOf(" ");
				if (endIndex!=-1)
				{
					currentName = currentName.substring(0, endIndex);
				}
			}
			if (isReachedItemDescriptionNode && currentName!=null)
			{
				currentContent = new String(ch, start, length);
				//constellationDailyList.add(new ConstellationModel(currentName, currentContent));
				currentName = null;
				currentContent= null;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (qName.equals(itemNode)) {
			isReachedItemNode = false;
		}
		if (qName.equals(itemTitleNode)) {
			isReachedItemTitleNode = false;
		}
		if (qName.equals(itemDescriptionNode)) {
			isReachedItemDescriptionNode = false;
		}
	}

}
