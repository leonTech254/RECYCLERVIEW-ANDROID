package com.leonteqsecurity.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public  void  toContacts(View view)
    {
        Intent intent = new Intent(this, AllContacts.class);
        startActivity(intent);
    }
}