package com.domzky.gymbooking.Sessions.Admin.pages.GymsList.ModifyGym;

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


public class ModifyGymActivity extends AppCompatActivity {

    private TextView gym_form;
    private EditText gym_name,gymress,owner_name,owner_email,owner_phoneNum,owner_username,owner_password;
    private Button modify_button,delete_button;
    private CheckBox check_password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_gym_form);

        gym_form = (TextView) findViewById(R.id.admin_gym_form_textview_gym);
        gym_form.setText("Modify Gym Form");

        gym_name = (EditText) findViewById(R.id.admin_gym_field_gym_name);
        gymress = (EditText) findViewById(R.id.admin_gym_field_gym_address);
        owner_name = (EditText) findViewById(R.id.admin_gym_field_fullname);
        owner_email = (EditText) findViewById(R.id.admin_gym_field_email);
        owner_phoneNum = (EditText) findViewById(R.id.admin_gym_field_phone);
        owner_username = (EditText) findViewById(R.id.admin_gym_field_username);
        owner_password = (EditText) findViewById(R.id.admin_gym_field_password);

        modify_button = (Button) findViewById(R.id.admin_gym_button_submit);
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

        modify_button.setText("Modify Gym");
        delete_button.setText("Delete this Gym");

        modify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}