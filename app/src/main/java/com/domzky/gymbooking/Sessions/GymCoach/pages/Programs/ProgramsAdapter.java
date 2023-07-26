package com.domzky.gymbooking.Sessions.GymCoach.pages.Programs;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.domzky.gymbooking.Helpers.FieldSyntaxes.MoneyTextWatcher;
import com.domzky.gymbooking.Helpers.Firebase.FirebaseHelper;
import com.domzky.gymbooking.Helpers.Things.Program;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.GymCoach.pages.Programs.ModifyProgram.ModifyProgramActivity;
import com.domzky.gymbooking.Sessions.GymOwner.pages.Membership.ModifyMembership.ModifyMembershipActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.ViewHolder> {
    
    public List<Program> list;
    public Context wholeContext;
    
    private DatabaseReference db = new FirebaseHelper().getProgramReference();
    
    public ProgramsAdapter(List<Program> list,Context wholeContext) {
        this.list = list;
        this.wholeContext = wholeContext;
    }
    
    @NonNull
    @Override
    public ProgramsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coach_menu_program_item,parent,false);
        ProgramsAdapter.ViewHolder holder = new ProgramsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramsAdapter.ViewHolder holder, int position) {
        Program program = list.get(position);

        holder.programname.setText(program.name);
//        holder.programdesc.setText(program.description);
        
        holder.delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progress = new ProgressDialog(wholeContext);
                progress.setCancelable(false);
                progress.setMessage("Removing Program");
                AlertDialog.Builder builder = new AlertDialog.Builder(wholeContext);
                builder.setTitle("Delete " + program.name);
                builder.setMessage("Are you sure you want to remove this program?");
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // DO NOTHING
                    }
                });
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        progress.show();
                        db.child(program.program_id).child("deleted").setValue(true)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progress.dismiss();
                                        Toast.makeText(wholeContext,"Program Removed.",Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.e("FIREBASE ERROR",""+ e.getMessage());
                                        Toast.makeText(wholeContext,"Program Removing Failed. Please Try Again",Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
                builder.create().show();
            }
        });
        
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wholeContext.startActivity(new Intent(wholeContext, ModifyProgramActivity.class)
                        .putExtra("program_id",program.program_id)
                        .putExtra("program_name",program.name)
                        .putExtra("program_description",program.description)
                );
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView programname,programdesc;
        ImageButton delBtn,editBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            programname = itemView.findViewById(R.id.coach_program_item_name);
//            programdesc = itemView.findViewById(R.id.coach_program_item_description);
            delBtn = itemView.findViewById(R.id.coach_program_item_btn_delete);
            editBtn = itemView.findViewById(R.id.coach_program_item_btn_edit);
        }
        
    }
}
