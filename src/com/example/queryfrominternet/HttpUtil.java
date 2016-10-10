package com.example.queryfrominternet;

import java.io.IOException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static void queryFromInternet(final String address,final HttpCallbackListener listener){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				try{
					HttpClient hc=new DefaultHttpClient();
					HttpGet hg=new HttpGet(address);
					HttpResponse httpResponse=hc.execute(hg);
					if(httpResponse.getStatusLine().getStatusCode()==200){
						//响应和请求都成功了
						HttpEntity entity=httpResponse.getEntity();
						String response=EntityUtils.toString(entity,"utf-8");
						if(listener!=null){
							listener.onFinish(response);
						}						
					}
				}catch(ClientProtocolException e){
					if(listener!=null){
						listener.onError(e);
					}
				}catch(IOException e){
					if(listener!=null){
						listener.onError(e);
					}
				}
			}}).start();
		
	}
}
