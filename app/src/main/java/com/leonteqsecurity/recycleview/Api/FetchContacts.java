package com.leonteqsecurity.recycleview.Api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchContacts {

    private RequestQueue requestQueue;

    public FetchContacts(Context context) {
        // Instantiate the RequestQueue using Volley.newRequestQueue()
        requestQueue = Volley.newRequestQueue(context);
    }

    public interface VolleyCallback {
        void onSuccess(JSONArray response) throws JSONException;
        void onError(VolleyError error);
    }

    public void makeGetRequest(String url, final VolleyCallback callback) {
        // Create a JsonObjectRequest with GET method
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            callback.onSuccess(response);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        callback.onError(error);
                    }
                });

        requestQueue.add(request);
    }
}
