package com.domzky.gymbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.domzky.gymbooking.Sessions.Admin.AdminSessionActivity;
import com.domzky.gymbooking.Sessions.GymOwner.OwnerSessionActivity;
import com.domzky.gymbooking.Sessions.UsersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, UsersActivity.class));
        finish();
    }
}