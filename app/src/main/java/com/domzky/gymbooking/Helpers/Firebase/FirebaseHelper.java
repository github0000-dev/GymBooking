package com.domzky.gymbooking.Helpers.Firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FirebaseHelper {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference getRootReference() {
        return ref;
    }
    public DatabaseReference getGymReference() {
        return ref.child("Gyms");
    }

    public DatabaseReference getWholeUserReference() {
        return ref.child("Users");
    }

    public DatabaseReference getGetGymReference() {
        return ref.child("Gyms");
    }

    public DatabaseReference getUserReference(String usertype) {
        return ref.child("Users").child(usertype);
    }



}
