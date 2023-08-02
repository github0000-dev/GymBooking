package com.domzky.gymbooking.Helpers.Things;

public class BMI {
    public String datetime,member_id,coach_id,heightUnit,weightUnit,description;
    public Boolean deleted;
    public Double height,weight,totalBMI;

    public BMI(){}

    public BMI(String member_id,String coach_id,String datetime,String description,Double height,Double weight,Boolean deleted) {
        this.member_id = member_id;
        this.coach_id = coach_id;
        this.datetime = datetime;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.deleted = deleted;
    }

    public BMI(String member_id,String coach_id,String datetime,String description,Double height,Double weight,String heightUnit,String weightUnit,Boolean deleted) {
        this.member_id = member_id;
        this.coach_id = coach_id;
        this.datetime = datetime;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.deleted = deleted;
        this.heightUnit = heightUnit;
        this.weightUnit = weightUnit;
        this.totalBMI = this.convertToBMI_withUnits(height,weight,heightUnit,weightUnit);
    }

    public Double convertToBMI(Double height, Double weight) {
        return weight/(Math.sqrt(height));
    }
    public Double convertToBMI_withUnits(Double height, Double weight, String heightUnit,String weightUnit) {
        Double meters,kilos;
//        if (heightUnit.equals("English")) {
//            meters = height * 0.3048;
//        } else {
//            meters = height;
//        }
//        if (weightUnit.equals("English")) {
//            kilos = weight * 0.45359237;
//        } else {
//            kilos = weight;
//        }
        meters = heightUnit.equals("English")? height * 0.3048 : height;
        kilos = weightUnit.equals("English")? weight * 0.45359237: weight;
        return kilos/Math.pow(meters,2);
    }
}
