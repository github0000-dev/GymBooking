package com.domzky.gymbooking.Sessions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.Admin.AdminLoginActivity;
import com.domzky.gymbooking.Sessions.Admin.AdminSessionActivity;
import com.domzky.gymbooking.Sessions.GymCoaches.CoachSessionActivity;
import com.domzky.gymbooking.Sessions.GymOwner.OwnerLoginActivity;
import com.domzky.gymbooking.Sessions.GymOwner.OwnerSessionActivity;
import com.domzky.gymbooking.Sessions.GymStaff.StaffSessionActivity;
import com.domzky.gymbooking.Sessions.Members.MemberLoginActivity;
import com.domzky.gymbooking.Sessions.Members.MemberSessionActivity;

public class UsersActivity extends AppCompatActivity {

    Button btn_admin,btn_owner,btn_coach,btn_staff,btn_member;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);


        btn_admin = (Button) findViewById(R.id.btn_admin_login);
        btn_coach = (Button) findViewById(R.id.btn_coach_login);
        btn_owner = (Button) findViewById(R.id.btn_owner_login);
        btn_staff = (Button) findViewById(R.id.btn_staff_login);
        btn_member = (Button) findViewById(R.id.btn_member_login);

        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersActivity.this, AdminLoginActivity.class));
            }
        });

        btn_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersActivity.this, OwnerLoginActivity.class));
            }
        });


        btn_coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersActivity.this, CoachSessionActivity.class));
            }
        });

        btn_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersActivity.this, StaffSessionActivity.class));
            }
        });

        btn_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersActivity.this, MemberLoginActivity.class));
            }
        });

    }


}