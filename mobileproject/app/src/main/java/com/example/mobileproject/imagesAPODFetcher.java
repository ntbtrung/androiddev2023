package com.example.mobileproject;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class imagesAPODFetcher {
    private static final String TAG = imagesAPODFetcher.class.getSimpleName();
    private static final String BASE_URL = "https://api.nasa.gov/planetary/apod";
    private static final String API_KEY = "Ik8WV87VrplVUZ3ehOm7nzSFuh9yaFNafi27MOam"; // Replace with your NASA API key

    public interface ApodDataCallback {
        void onApodDataReceived(JSONObject apodData);
        void onError(String errorMessage);
    }

    public static void fetchApodData(ApodDataCallback callback) {
        new AsyncTask<Void, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... voids) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    String apiUrl = BASE_URL + "?api_key=" + API_KEY;

                    Request request = new Request.Builder()
                            .url(apiUrl)
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
            protected void onPostExecute(JSONObject apodData) {
                if (apodData != null) {
                    callback.onApodDataReceived(apodData);
                } else {
                    callback.onError("Failed to fetch APOD data");
                }
            }
        }.execute();
    }
}
