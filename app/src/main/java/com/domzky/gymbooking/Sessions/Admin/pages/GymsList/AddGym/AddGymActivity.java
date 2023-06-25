package com.domzky.gymbooking.Sessions.Admin.pages.GymsList.AddGym;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.domzky.gymbooking.R;

public class AddGymActivity extends AppCompatActivity {

    private TextView gym_form;
    private EditText gym_name,gym_address,owner_name,owner_email,owner_phoneNum,owner_username,owner_password;
    private Button add_button,delete_button;
    private CheckBox check_password;

    private String gymname,gymaddress,ownername,owneremail,ownerphoneNum,ownerusername,ownerpassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_gym_form);

        gym_form = (TextView) findViewById(R.id.admin_gym_form_textview_gym);
        gym_form.setText("Gym Registration Form");

        gym_name = (EditText) findViewById(R.id.admin_gym_field_gym_name);
        gym_address = (EditText) findViewById(R.id.admin_gym_field_gym_address);
        owner_name = (EditText) findViewById(R.id.admin_gym_field_fullname);
        owner_email = (EditText) findViewById(R.id.admin_gym_field_email);
        owner_phoneNum = (EditText) findViewById(R.id.admin_gym_field_phone);
        owner_username = (EditText) findViewById(R.id.admin_gym_field_username);
        owner_password = (EditText) findViewById(R.id.admin_gym_field_password);

        gymname = gym_name.getText().toString().trim();
        gymaddress = gym_address.getText().toString().trim();
        ownername = owner_name.getText().toString().trim();
        owneremail = owner_email.getText().toString().trim();
        ownerphoneNum = owner_phoneNum.getText().toString().trim();
        ownerusername = owner_username.getText().toString().trim();
        ownerpassword = owner_password.getText().toString().trim();

        add_button = (Button) findViewById(R.id.admin_gym_button_submit);
        delete_button = (Button) findViewById(R.id.admin_gym_button_delete);
        check_password = (CheckBox) findViewById(R.id.admin_gym_checkbox_password);

        check_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (!checked) {
                    owner_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    owner_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        delete_button.setVisibility(View.GONE);
        add_button.setText("Add Gym");

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}