package com.domzky.gymbooking.Sessions.Members.pages.Dashboard.DashboardDesk.tabs.Booking;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.domzky.gymbooking.R;

public class BookingFragment extends Fragment {

    private LayoutInflater layoutInflater;
    private ViewGroup viewGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member_dashboard_booking, container, false);



        return view;
    }
}