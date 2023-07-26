package com.domzky.gymbooking.Sessions.GymCoach.pages.Programs.ModifyProgram;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.domzky.gymbooking.Helpers.FieldSyntaxes.FieldValidations;
import com.domzky.gymbooking.Helpers.Firebase.FirebaseHelper;
import com.domzky.gymbooking.Helpers.Things.Program;
import com.domzky.gymbooking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class ModifyProgramActivity extends AppCompatActivity {


    private DatabaseReference dbread = new FirebaseHelper().getProgramReference();
    private DatabaseReference dbwrite = new FirebaseHelper().getProgramReference();

    private TextView banner;
    private EditText nameField,descriptionField;
    private Button addBtn,resetBtn;

    private String name,description,reset_name,reset_description,reset_uid;

    private SharedPreferences preferences;
    private FieldValidations fieldVal = new FieldValidations();
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_program_form);

        preferences = this.getSharedPreferences("coach",MODE_PRIVATE);
        progress = new ProgressDialog(ModifyProgramActivity.this);
        progress.setCancelable(false);
        progress.setMessage("Changing Program");


        reset_uid = getIntent().getStringExtra("program_id");
        reset_name = getIntent().getStringExtra("program_name");
        reset_description = getIntent().getStringExtra("program_description");

        banner = findViewById(R.id.program_form_banner);
        banner.setText("Modify Program Form".toUpperCase(Locale.ROOT));

        nameField = findViewById(R.id.program_form_field_name);
        descriptionField = findViewById(R.id.program_form_field_description);

        addBtn = findViewById(R.id.program_form_button_submit);
        resetBtn = findViewById(R.id.program_form_button_reset);

        resetFieldsByDefault();

        addBtn = findViewById(R.id.program_form_button_submit);
        resetBtn = findViewById(R.id.program_form_button_reset);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFieldsByDefault();
            }
        });

        addBtn.setText("update Program");

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllFieldValidations();
                progress.show();
                name = nameField.getText().toString().trim();
                description = descriptionField.getText().toString().trim();


                if (checkIfFieldsAreNotDefaultState(name,description)) {
                    Toast.makeText(ModifyProgramActivity.this,"No Changes been Made.",Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                    return;
                }

                if (name.isEmpty()) {
                    nameField.setError("This Field is Required.");
                    progress.dismiss();
                    return;
                }


                dbread.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (
                                fieldVal.isProgramNameExists(snapshot,name,preferences.getString("userid",""))
                                && !name.equals(reset_name)
                        ) {
                            nameField.setError("This Program Exists.");
                            progress.dismiss();
                            return;
                        }
                        dbwrite.child(reset_uid).setValue(new Program(
                                name,
                                preferences.getString("userid",""),
                                description,
                                false
                        )).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progress.dismiss();
                                Toast.makeText(ModifyProgramActivity.this,"Program Added Successfully.",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.e("FIREBASE ERROR",""+ e.getMessage());
                                Toast.makeText(getBaseContext(),"Program Adding Failed. Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("FIREBASE ERROR",""+ error.getMessage());
                        Toast.makeText(getBaseContext(),"Program Adding Failed. Please Try Again",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }


    private void resetFieldsByDefault() {
        nameField.setText(reset_name);
        descriptionField.setText(reset_description);
    }

    private void clearAllFieldValidations() {
        nameField.setError(null);
    }

    private boolean checkIfFieldsAreNotDefaultState(String nameGet,String descriptionGet) {
        return reset_name.equals(nameGet)
                && reset_description.equals(descriptionGet);
    }



}