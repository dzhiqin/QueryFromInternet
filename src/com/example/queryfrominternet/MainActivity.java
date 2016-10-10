package com.example.queryfrominternet;

import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tvText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvText=(TextView)findViewById(R.id.tv_text);
		HttpUtil.queryFromInternet("http://www.baidu.com", new HttpCallbackListener(){

			@Override
			public void onFinish(String string) {
				// TODO 自动生成的方法存根
				tvText.setText(string);
			}

			@Override
			public void onError(Exception e) {
				// TODO 自动生成的方法存根
				tvText.setText("Error!");
				e.printStackTrace();
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
