package com.domzky.gymbooking.Sessions.GymCoach.pages.Programs.AddProgram;

import android.annotation.SuppressLint;
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

public class AddProgramActivity extends AppCompatActivity {

    private DatabaseReference dbread = new FirebaseHelper().getProgramReference();
    private DatabaseReference dbwrite = new FirebaseHelper().getProgramReference();

    private TextView banner;
    private EditText nameField,descriptionField;
    private Button addBtn,resetBtn;

    private String name,description;

    private SharedPreferences preferences;
    private FieldValidations fieldVal = new FieldValidations();
    private ProgressDialog progress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_program_form);

        preferences = this.getSharedPreferences("coach",MODE_PRIVATE);
        progress = new ProgressDialog(AddProgramActivity.this);
        progress.setCancelable(false);
        progress.setMessage("Adding Program".toUpperCase(Locale.ROOT));

        banner = findViewById(R.id.program_form_banner);

        nameField = findViewById(R.id.program_form_field_name);
        descriptionField = findViewById(R.id.program_form_field_description);

        addBtn = findViewById(R.id.program_form_button_submit);
        resetBtn = findViewById(R.id.program_form_button_reset);

        resetBtn.setVisibility(View.GONE);
        addBtn.setText("Add to Program List");

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllFieldValidations();
                progress.show();
                name = nameField.getText().toString().trim();
                description = descriptionField.getText().toString().trim();

                if (name.isEmpty()) {
                    nameField.setError("This Field is Required.");
                    progress.dismiss();
                    return;
                }


                dbread.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (fieldVal.isProgramNameExists(snapshot,name,preferences.getString("userid",""))) {
                            nameField.setError("This Program Exists.");
                            progress.dismiss();
                            return;
                        }
                        dbwrite.push().setValue(new Program(
                                name,
                                preferences.getString("userid",""),
                                description,
                                false
                        )).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progress.dismiss();
                                Toast.makeText(AddProgramActivity.this,"Program Added Successfully.",Toast.LENGTH_SHORT).show();
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

    private void clearAllFieldValidations() {
        nameField.setError(null);
    }

}