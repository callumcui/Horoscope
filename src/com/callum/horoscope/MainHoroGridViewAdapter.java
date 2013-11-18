package com.callum.horoscope;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainHoroGridViewAdapter extends BaseAdapter {

	private ArrayList<Integer> constellationImageList;
	private ArrayList<String> constellationTextList;
	private Activity activity;

	public MainHoroGridViewAdapter(Activity activity,
			ArrayList<Integer> constellationImageList,
			ArrayList<String> constellationTextList) {
		super();
		this.constellationImageList = constellationImageList;
		this.constellationTextList = constellationTextList;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return constellationImageList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return constellationImageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static class ViewHolder
	{
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		LayoutInflater inflator = activity.getLayoutInflater();
		
		if (convertView==null)
		{
			viewHolder = new ViewHolder();
			convertView = inflator.inflate(R.layout.cell, null);
			
			viewHolder.textView =(TextView) convertView.findViewById(R.id.textView_constellationName);
			viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView_constellation);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (ViewHolder)convertView.getTag();
			
		}
		
		viewHolder.textView.setText(constellationTextList.get(position));
		viewHolder.imageView.setImageResource(constellationImageList.get(position));
		
		return convertView;
	}

}
