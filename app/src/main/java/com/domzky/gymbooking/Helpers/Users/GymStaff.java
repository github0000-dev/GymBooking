package com.domzky.gymbooking.Helpers.Users;

public class GymStaff {
    public String gym_id,fullname,email,phone,username,password;
    public Boolean activated;
    public Gym gym;

    public GymStaff(String fullname,String email,String phone,String username,String password,Boolean activated,String gym_id) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.gym_id = gym_id;
    }
}
