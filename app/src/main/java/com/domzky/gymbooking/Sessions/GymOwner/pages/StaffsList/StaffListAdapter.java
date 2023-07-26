package com.domzky.gymbooking.Sessions.GymOwner.pages.StaffsList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.domzky.gymbooking.Helpers.Users.GymStaff;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.GymOwner.pages.StaffsList.ModifyStaff.ModifyStaffActivity;

import java.util.List;

public class StaffListAdapter extends RecyclerView.Adapter<StaffListAdapter.ViewHolder> {

    public List<GymStaff> list;
    public Context wholeContext;

    public StaffListAdapter(List<GymStaff> list) {
        this.list = list;
    }

    public StaffListAdapter(List<GymStaff> list,Context wholeContext) {
        this.list = list;
        this.wholeContext = wholeContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView staff_fullname,staff_active;

        public ViewHolder(View itemView) {
            super(itemView);

            staff_fullname = itemView.findViewById(R.id.staff_item_fullname);
            staff_active = itemView.findViewById(R.id.staff_item_activated);

        }

    }

    @NonNull
    @Override
    public StaffListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.owner_staff_item,parent,false);

        StaffListAdapter.ViewHolder holder = new StaffListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaffListAdapter.ViewHolder holder, int position) {
        GymStaff staff = list.get(position);

        holder.staff_fullname.setText(staff.fullname);
        if (staff.activated) {
            holder.staff_active.setText("ACCOUNT ACTIVE");
            holder.staff_active.setTextColor(Color.GREEN);
        } else {
            holder.staff_active.setText("ACCOUNT INACTIVE");
            holder.staff_active.setTextColor(Color.RED);
        }
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wholeContext.startActivity(new Intent(wholeContext, ModifyStaffActivity.class)
                        .putExtra("staffuid",staff.uid)
                        .putExtra("gymuid",staff.gym_id)
                        .putExtra("stafffullname",staff.fullname)
                        .putExtra("staffemail",staff.email)
                        .putExtra("staffphone",staff.phone)
                        .putExtra("staffusername",staff.username)
                        .putExtra("staffpassword",staff.password)
                        .putExtra("staffactivated",staff.activated)
                );
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
