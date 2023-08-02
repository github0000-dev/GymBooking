package com.domzky.gymbooking.Sessions.Members.pages.Programs;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domzky.gymbooking.Helpers.Things.BMI;
import com.domzky.gymbooking.R;

import java.util.ArrayList;
import java.util.List;

public class ProgramsFragment extends Fragment {

    private RecyclerView recview;
    private List<BMI> list;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member_programs, container, false);

        recview = view.findViewById(R.id.member_programs_recview);
        list = new ArrayList<>();

        return view;
    }
}