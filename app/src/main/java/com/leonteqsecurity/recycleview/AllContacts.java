package com.leonteqsecurity.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.leonteqsecurity.recycleview.Adaptors.ConactAdaptor;
import com.leonteqsecurity.recycleview.Adaptors.Contact;
import com.leonteqsecurity.recycleview.Api.FetchContacts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllContacts extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Contact> contactlist;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactlist = new ArrayList<>();
        adapter=new ConactAdaptor(contactlist,this);
        recyclerView.setAdapter(adapter);

        fetchContacts();


    }


    public void fetchContacts()
    {
        FetchContacts volleyExample = new FetchContacts(this);
        String url = "";
        volleyExample.makeGetRequest(url, new FetchContacts.VolleyCallback() {
            @Override
            public void onSuccess(JSONArray response) throws JSONException {
                System.out.println(response);
                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String phoneNo = jsonObject.getString("phoneNo");
                        String name = jsonObject.getString("fullname");
                        Contact contact=new Contact(phoneNo,name);
                        contactlist.add(contact);
                        adapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onError(VolleyError error) {
                System.out.println(error);
            }
        });

    }
}