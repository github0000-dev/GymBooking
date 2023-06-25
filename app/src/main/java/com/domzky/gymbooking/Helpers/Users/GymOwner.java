package com.domzky.gymbooking.Helpers.Users;

public class GymOwner {
    
    public String gym_name,gym_address,owner_fullname,owner_email,owner_password;
    public Boolean activated;
    public int age;

    public GymOwner(String gym_name,String gym_address,String owner_fullname) {
        this.gym_name = gym_name;
        this.gym_address = gym_address;
        this.owner_fullname = owner_fullname;
    }
    public GymOwner(String gym_name,String gym_address,String owner_fullname,Boolean activated) {
        this.gym_name = gym_name;
        this.gym_address = gym_address;
        this.owner_fullname = owner_fullname;
        this.activated = activated;
    }

    public GymOwner(String gym_name,String gym_address,String owner_fullname,String owner_password,Boolean activated) {
        this.gym_name = gym_name;
        this.gym_address = gym_address;
        this.owner_fullname = owner_fullname;
        this.owner_password = owner_password;
        this.activated = activated;
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
