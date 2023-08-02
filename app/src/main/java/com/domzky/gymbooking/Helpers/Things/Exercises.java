package com.domzky.gymbooking.Helpers.Things;

public class Exercises {
    public String name,description,exercise_id,coach_id;
    public boolean deleted;

    public Exercises(String name, String coach_id, String description, Boolean deleted) {
        this.name = name;
        this.coach_id = coach_id;
        this.description = description;
        this.deleted = deleted;
    }
    public Exercises(String exercise_id, String coach_id, String name, String description, Boolean deleted) {
        this.exercise_id = exercise_id;
        this.coach_id = coach_id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }
}
