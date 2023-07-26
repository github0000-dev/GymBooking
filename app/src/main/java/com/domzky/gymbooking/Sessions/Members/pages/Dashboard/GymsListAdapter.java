package com.domzky.gymbooking.Sessions.Members.pages.Dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.domzky.gymbooking.Helpers.Users.Gym;
import com.domzky.gymbooking.R;

import java.util.List;

public class GymsListAdapter extends RecyclerView.Adapter<GymsListAdapter.ViewHolder> {

    List<Gym> list;

    public GymsListAdapter(List<Gym> list){
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gymname,gymaddress;

        public ViewHolder(View itemView) {
            super(itemView);
            gymname = itemView.findViewById(R.id.member_gym_item_name);
            gymaddress = itemView.findViewById(R.id.member_gym_item_address);
        }

    }

    @NonNull
    @Override
    public GymsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.member_gym_item, parent, false);
        GymsListAdapter.ViewHolder viewHolder = new GymsListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GymsListAdapter.ViewHolder holder, int position) {
        Gym gym = list.get(position);

        holder.gymname.setText(gym.gym_name);
        holder.gymaddress.setText(gym.gym_address);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
