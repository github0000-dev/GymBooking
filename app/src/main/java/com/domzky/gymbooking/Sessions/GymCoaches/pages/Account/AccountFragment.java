package com.domzky.gymbooking.Sessions.GymCoaches.pages.Account;

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
import android.widget.TextView;

import com.domzky.gymbooking.R;

public class AccountFragment extends Fragment {

    private TextView gymNameText,gymAddressText;
    private EditText fullnameField,emailField,phoneField,usernameField,passwordField;
    private Button updateBtn;
    private CheckBox showPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coach_account, container, false);

        gymNameText = view.findViewById(R.id.coach_account_textview_gym_name);
        gymAddressText = view.findViewById(R.id.coach_account_textview_gym_address);

        fullnameField = view.findViewById(R.id.coach_account_update_field_fullname);
        emailField = view.findViewById(R.id.coach_account_update_field_email);
        phoneField = view.findViewById(R.id.coach_account_update_field_phone);
        usernameField = view.findViewById(R.id.coach_account_update_field_username);
        passwordField = view.findViewById(R.id.coach_account_update_field_password);

        updateBtn = view.findViewById(R.id.coach_account_update_button_submit);
        showPassword = view.findViewById(R.id.coach_account_update_checkbox_password);

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