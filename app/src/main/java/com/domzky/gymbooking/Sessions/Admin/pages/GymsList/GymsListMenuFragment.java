package com.domzky.gymbooking.Sessions.Admin.pages.GymsList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domzky.gymbooking.Helpers.Users.GymOwner;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.Admin.pages.GymsList.AddGym.AddGymActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GymsListMenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton add_fab;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_owners_list, container, false);

        recyclerView = view.findViewById(R.id.gym_list_menu_recview);
        add_fab = view.findViewById(R.id.gym_list_add_fab);

        List<GymOwner> owners = new ArrayList<>();

        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));
        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));
        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));
        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));
        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));

        recyclerView.setAdapter(new GymsListAdapter(owners,getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddGymActivity.class));
            }
        });

        return view;
    }
}