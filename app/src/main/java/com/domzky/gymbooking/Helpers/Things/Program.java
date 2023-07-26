package com.domzky.gymbooking.Helpers.Things;

public class Program {
    public String name,description,program_id,coach_id;
    public boolean deleted;

    public Program(String name,String coach_id,String description,Boolean deleted) {
        this.name = name;
        this.coach_id = coach_id;
        this.description = description;
        this.deleted = deleted;
    }
    public Program(String program_id,String coach_id,String name,String description,Boolean deleted) {
        this.program_id = program_id;
        this.coach_id = coach_id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }
}
