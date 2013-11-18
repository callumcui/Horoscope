package com.callum.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnItemClickListener {

	
	public final static String PARAMETER_TO_ITEM = "com.callum.horoscope.item";
	
	private GridView gridView;
	private ImageView imageView;
	private TextView textView;
	private MainHoroGridViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridView = (GridView) this.findViewById(R.id.gridview_constellations);
		mAdapter = new MainHoroGridViewAdapter(this,
				ConstellationModel.getConstellationImageList(),
				ConstellationModel.getConstellationNameList());

		gridView.setAdapter(mAdapter);

		gridView.setOnItemClickListener(this);
		gridView.setOnItemSelectedListener(this);
		
		String a = "1";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(this, ConstellationItem.class);
		String constellationName = ConstellationModel.getConstellationNameList().get(position);
		intent.putExtra(PARAMETER_TO_ITEM, constellationName);
		startActivity(intent);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
