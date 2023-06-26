package com.domzky.gymbooking.Sessions.Admin.pages.GymsList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.domzky.gymbooking.Helpers.Users.Gym;
import com.domzky.gymbooking.Helpers.Users.GymOwner;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.Admin.pages.GymsList.ModifyGym.ModifyGymActivity;

import java.util.List;
import java.util.Locale;

public class GymsListAdapter extends RecyclerView.Adapter<GymsListAdapter.ViewHolder> {

    List<Gym> list;
    Context wholeContext;

    public GymsListAdapter(List<Gym> list,Context context) {
        this.list = list;
        this.wholeContext = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gymname,fullname,gymaddress;

        public ViewHolder(View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.owner_item_full_name);
            gymname = itemView.findViewById(R.id.owner_item_gym_name);
            gymaddress = itemView.findViewById(R.id.owner_item_gym_address);
        }
    }

    @NonNull
    @Override
    public GymsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.admin_user_item,parent,false);

        GymsListAdapter.ViewHolder viewHolder = new GymsListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GymsListAdapter.ViewHolder holder, int position) {
        Gym gym = list.get(position);

        holder.gymname.setText(gym.gym_name.toUpperCase(Locale.ROOT));
        holder.fullname.setText(gym.owner.fullname);
        holder.gymaddress.setText(gym.gym_address);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wholeContext.startActivity(new Intent(wholeContext, ModifyGymActivity.class)
                        .putExtra("gymuid",gym.uid)
                        .putExtra("gymname",gym.gym_name)
                        .putExtra("gymaddress",gym.gym_address)
                        .putExtra("gymactivated",gym.gym_activated)
                        .putExtra("gymstatus",gym.gym_status)
                        .putExtra("ownername",gym.owner.fullname)
                        .putExtra("owneremail",gym.owner.email)
                        .putExtra("ownerphone",gym.owner.phone)
                        .putExtra("ownerusername",gym.owner.username)
                        .putExtra("ownerpassword",gym.owner.password)
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
