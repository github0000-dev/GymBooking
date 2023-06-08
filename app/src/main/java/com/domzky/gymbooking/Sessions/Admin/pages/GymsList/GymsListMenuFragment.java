package com.domzky.gymbooking.Sessions.Admin.pages.GymsList;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domzky.gymbooking.Helpers.Users.GymOwner;
import com.domzky.gymbooking.R;

import java.util.ArrayList;
import java.util.List;

public class GymsListMenuFragment extends Fragment {

    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_owners_list, container, false);

        recyclerView = view.findViewById(R.id.user_list_menu_recview);
        List<GymOwner> owners = new ArrayList<>();

        owners.add(new GymOwner("Gymers","Bohol","Phil Adlaon"));
        owners.add(new GymOwner("Suello Gym","Tagbilaran","Jun Suello"));

        recyclerView.setAdapter(new GymsListAdapter(owners));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}