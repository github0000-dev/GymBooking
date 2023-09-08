package com.domzky.gymbooking.Sessions.Members.pages.Programs;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager2.widget.ViewPager2;
import com.domzky.gymbooking.R;
import com.google.android.material.tabs.TabLayout;

public class ProgramsFragment extends Fragment {

    private ProgramsViewPagerAdapter adapter;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member_programs, container, false);

        viewPager = view.findViewById(R.id.member_dashboard_viewpager);
        tabLayout = view.findViewById(R.id.member_dashboard_tablayout);
        adapter = new ProgramsViewPagerAdapter(getActivity());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager.setAdapter(adapter);
        viewPager.setUserInputEnabled(false);

        return view;
    }
}