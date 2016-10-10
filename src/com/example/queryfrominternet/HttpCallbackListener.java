package com.example.queryfrominternet;

public interface HttpCallbackListener {
	public void onFinish(String string);
	public void onError(Exception e);
}
