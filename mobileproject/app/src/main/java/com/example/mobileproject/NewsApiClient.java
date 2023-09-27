package com.example.mobileproject;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsApiClient {

    private static final String TAG = NewsApiClient.class.getSimpleName();
    private static final String API_URL = "https://www.nasa.gov/api/2/ubernode/489170";

    public interface NewsDataCallback {
        void onNewsDataReceived(JSONObject newsData);
        void onError(String errorMessage);
    }

    public static void fetchNewsData(NewsDataCallback callback) {
        new AsyncTask<Void, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... voids) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(API_URL)
                            .build();

                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String responseData = response.body().string();
                        return new JSONObject(responseData);
                    } else {
                        Log.e(TAG, "API request failed with code: " + response.code());
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(JSONObject newsData) {
                if (newsData != null) {
                    callback.onNewsDataReceived(newsData);
                } else {
                    callback.onError("Failed to fetch news data");
                }
            }
        }.execute();
    }
}

