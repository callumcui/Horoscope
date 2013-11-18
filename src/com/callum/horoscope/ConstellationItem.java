package com.callum.horoscope;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ConstellationItem extends Activity {

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	private String a = "aa";
	private ImageView imageView;
	private TextView contentTextView;
	private TextView nameTextView;
	private TextView dateTextView;
	private Spinner spinner;
	private String rssUrl = null;

	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_constellation_item);

		// get constellation name from main activity
		Intent intent = getIntent();
		String constellationName = intent
				.getStringExtra(MainActivity.PARAMETER_TO_ITEM);

		// set constellation basic info
		imageView = (ImageView) this.findViewById(R.id.imageView1);
		imageView.setImageResource(ConstellationModel
				.getImageViewByConstellationName(constellationName));
		contentTextView = (TextView) this
				.findViewById(R.id.constellationContent_TextView);
		nameTextView = (TextView) this
				.findViewById(R.id.constellationName_TextView);
		nameTextView.setText(constellationName);

		dateTextView = (TextView) this
				.findViewById(R.id.constellationDateRange_TextView);
		dateTextView.setText(ConstellationModel
				.getDateByConstellationName(constellationName));

		// set progress dialog
		progressDialog = new ProgressDialog(this);
		progressDialog.setTitle("loading...");
		progressDialog.setMessage("loading, " + constellationName + " message");
		progressDialog.setCancelable(false);

		// fill out the daily horoscope info by category
		spinner = (Spinner) this.findViewById(R.id.dailyCategory_Spinner);
		SimpleAdapter simpleAdapter = new SimpleAdapter(ConstellationItem.this,
				ConstellationModel.getDailyCategoryList(),
				R.layout.daily_category_item, new String[] {
						ConstellationModel.DAILY_CATEGORY_IMAGE,
						ConstellationModel.DAILY_CATEGORY_NAME }, new int[] {
						R.id.dailyCategory_ImageView,
						R.id.dailyCategory_TextView });
		spinner.setAdapter(simpleAdapter);

		rssUrl = ConstellationModel
				.getRSSURLByDailyCategoryName(ConstellationModel.daily_category_horoscope);
		new InvokeHttpTask().execute(rssUrl);

		// get daily horoscope when select category
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				String dailyCategoryName = ((Map<String, Object>) spinner
						.getItemAtPosition(position)).get(
						ConstellationModel.DAILY_CATEGORY_NAME).toString();
				setTitle(dailyCategoryName);
				rssUrl = ConstellationModel
						.getRSSURLByDailyCategoryName(dailyCategoryName);
				new InvokeHttpTask().execute(rssUrl);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.constellation_item, menu);
		return true;
	}

	public class InvokeHttpTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(arg0[0]);
			String content = null;
			try {
				HttpResponse httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity httpEntity = httpResponse.getEntity();
					content = EntityUtils.toString(httpEntity);
					InputStream inputStream = new ByteArrayInputStream(
							content.getBytes("UTF-8"));

					List<ConstellationModel> list = ConstellationModel
							.parseDailyXML(inputStream, "UTF-8");
					if (list != null && list.size() > 0) {
						for (ConstellationModel model : list) {
							if (nameTextView != null
									&& nameTextView.getText().equals(
											model.getName())) {
								content = model.getDescription();
								break;
							}
						}
					}
					inputStream.close();
					// List<HashMap<String,String>> list = handler.getList();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return content;
		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
			contentTextView.setText(result);
			progressDialog.dismiss();
		}

	}

}
