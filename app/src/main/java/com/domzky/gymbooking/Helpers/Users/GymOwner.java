package com.domzky.gymbooking.Helpers.Users;

public class GymOwner {
    
    public String gym_name,gym_address,owner_fullname,owner_email,password;
    
    public GymOwner(String gym_name,String gym_address,String owner_fullname) {
        this.gym_name = gym_name;
        this.gym_address = gym_address;
        this.owner_fullname = owner_fullname;
    }

    public String getGymName() {
        return this.gym_name;
    }

    public String getGymAddress() {
        return this.gym_address;
    }

    public String getOwnerFullname() {
        return this.owner_fullname;
    }

    public String getOwnerEmail() {
        return this.owner_email;
    }
    
    

}
