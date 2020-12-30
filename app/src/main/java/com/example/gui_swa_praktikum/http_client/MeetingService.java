package com.example.gui_swa_praktikum.http_client;

import com.example.gui_swa_praktikum.model.Meeting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MeetingService {

    private static final String URL = "http://10.0.2.2:8080/EJB_Backend/api/meeting";

    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.create();

    private java.net.URL url;
    private URLConnection connection;
    private HttpURLConnection httpConnection;
    private OkHttpClient client = new OkHttpClient();
    private String urlString;

    public ArrayList<Meeting> listMeeting() throws IOException {
        urlString = URL + "/list";
        Request request = new Request.Builder().url(urlString).build();
        Response response = client.newCall(request).execute();
        String output;
        Meeting[] meeting = null;
        if ((output = response.body().string()) != null)
            meeting = gson.fromJson(output, Meeting[].class);
        return new ArrayList<Meeting>(Arrays.asList(meeting));
    }

    public Response saveMeeting(Meeting meeting) {
        urlString = URL + "/save";
        RequestBody body = RequestBody.create(gson.toJson(meeting), MediaType.parse("application/json; charset=utf-8"));
        System.out.println(gson.toJson(meeting));
        Request request = new Request.Builder()
                .url(urlString)
                .post(body)
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
