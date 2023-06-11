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

import com.domzky.gymbooking.Helpers.Users.GymOwner;
import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.Admin.pages.GymsList.ModifyGym.ModifyGymActivity;

import java.util.List;
import java.util.Locale;

public class GymsListAdapter extends RecyclerView.Adapter<GymsListAdapter.ViewHolder> {

    List<GymOwner> list;
    Context wholeContext;

//    public GymsListAdapter(List<GymOwner> list) {
//        this.list = list;
//    }

    public GymsListAdapter(List<GymOwner> list,Context context) {
        this.list = list;
        this.wholeContext = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gymname,fullname,gymaddress;
        public View thisView;

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
        GymOwner owner = list.get(position);

        holder.gymname.setText(owner.getGymName().toUpperCase(Locale.ROOT));
        holder.fullname.setText(owner.getOwnerFullname());
        holder.gymaddress.setText(owner.getGymAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wholeContext.startActivity(new Intent(wholeContext, ModifyGymActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
