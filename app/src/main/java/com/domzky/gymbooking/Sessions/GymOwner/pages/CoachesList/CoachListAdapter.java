package com.domzky.gymbooking.Sessions.GymOwner.pages.CoachesList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.domzky.gymbooking.Helpers.Users.GymCoach;
import com.domzky.gymbooking.Helpers.Users.GymStaff;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.GymOwner.pages.CoachesList.ModifyCoach.ModifyCoachActivity;
import com.domzky.gymbooking.Sessions.GymOwner.pages.StaffsList.ModifyStaff.ModifyStaffActivity;

import java.util.List;

public class CoachListAdapter extends RecyclerView.Adapter<CoachListAdapter.ViewHolder> {

    public List<GymCoach> list;
    public Context wholeContext;

    public CoachListAdapter(List<GymCoach> list) {
        this.list = list;
    }
    public CoachListAdapter(List<GymCoach> list, Context wholeContext) {
        this.list = list;
        this.wholeContext = wholeContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView coach_fullname,coach_active;

        public ViewHolder(View itemView) {
            super(itemView);

            coach_fullname = itemView.findViewById(R.id.coach_item_fullname);
            coach_active = itemView.findViewById(R.id.coach_item_activated);

        }

    }

    @NonNull
    @Override
    public CoachListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.owner_coach_item,parent,false);

        CoachListAdapter.ViewHolder holder = new CoachListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoachListAdapter.ViewHolder holder, int position) {
        GymCoach coach = list.get(position);

        holder.coach_fullname.setText(coach.fullname);
        if (coach.activated) {
            holder.coach_active.setText("ACCOUNT ACTIVE");
            holder.coach_active.setTextColor(Color.GREEN);
        } else {
            holder.coach_active.setText("ACCOUNT INACTIVE");
            holder.coach_active.setTextColor(Color.RED);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wholeContext.startActivity(new Intent(wholeContext, ModifyCoachActivity.class)
                        .putExtra("coachuid",coach.uid)
                        .putExtra("gymuid",coach.gym_id)
                        .putExtra("coachfullname",coach.fullname)
                        .putExtra("coachemail",coach.email)
                        .putExtra("coachphone",coach.phone)
                        .putExtra("coachusername",coach.username)
                        .putExtra("coachpassword",coach.password)
                        .putExtra("coachactivated",coach.activated)
                );
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

