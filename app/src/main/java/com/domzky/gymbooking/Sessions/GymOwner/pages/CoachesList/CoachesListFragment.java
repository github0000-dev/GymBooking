package com.domzky.gymbooking.Sessions.GymOwner.pages.CoachesList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.domzky.gymbooking.Helpers.Firebase.FirebaseHelper;
import com.domzky.gymbooking.Helpers.Users.GymCoach;
import com.domzky.gymbooking.Helpers.Users.GymStaff;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.GymOwner.pages.CoachesList.AddCoach.AddCoachActivity;
import com.domzky.gymbooking.Sessions.GymOwner.pages.StaffsList.AddStaff.AddStaffActivity;
import com.domzky.gymbooking.Sessions.GymOwner.pages.StaffsList.StaffListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CoachesListFragment extends Fragment {

    private DatabaseReference fdb = new FirebaseHelper().getUserReference("Coaches");

    private RecyclerView recView;
    private List<GymCoach> list;
    private FloatingActionButton fab;

    private SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_coaches_list, container, false);

        list = new ArrayList<>();
        preferences = getActivity().getSharedPreferences("owner", Context.MODE_PRIVATE);

        recView = view.findViewById(R.id.coach_list_menu_recview);
        fab = view.findViewById(R.id.coach_list_add_fab);

//        list.add(new GymCoach("1","Dave Cantero","","","","",true,""));

        fdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    if (snap.child("gym_id").getValue(String.class).equals(preferences.getString("userid",""))) {
                        list.add(new GymCoach(
                                snap.getKey(),
                                snap.child("fullname").getValue(String.class),
                                snap.child("email").getValue(String.class),
                                snap.child("phone").getValue(String.class),
                                snap.child("username").getValue(String.class),
                                snap.child("password").getValue(String.class),
                                snap.child("activated").getValue(Boolean.class),
                                snap.child("gym_id").getValue(String.class)
                        ));
                    }
                }
                recView.setAdapter(new CoachListAdapter(list,getActivity()));
                recView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();
                Log.d("FIREBASE ERR", error.getMessage());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddCoachActivity.class));
            }
        });


        return view;
    }
}