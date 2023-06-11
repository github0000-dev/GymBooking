package com.domzky.gymbooking.Sessions.GymOwner.pages.Account;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.domzky.gymbooking.R;

public class AccountFragment extends Fragment {

    private EditText gymnameField,gymaddressField,fullnameField,emailField,phoneField,usernameField,passwordField;
    private Button updateBtn;
    private CheckBox showPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_account, container, false);


        gymnameField = view.findViewById(R.id.owner_account_update_field_gym_name);
        gymaddressField = view.findViewById(R.id.owner_account_update_field_gym_address);

        fullnameField = view.findViewById(R.id.owner_account_update_field_fullname);
        emailField = view.findViewById(R.id.owner_account_update_field_email);
        phoneField = view.findViewById(R.id.owner_account_update_field_phone);
        usernameField = view.findViewById(R.id.owner_account_update_field_username);
        passwordField = view.findViewById(R.id.owner_account_update_field_password);

        updateBtn = view.findViewById(R.id.owner_account_update_button_submit);
        showPassword = view.findViewById(R.id.owner_account_update_checkbox_password);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (!checked) {
                    passwordField.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    passwordField.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });



        return view;
    }
}