package com.example.roomdoctores;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_table")
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="specialization")
    //General physician, dental surgeon
    public String specialization;


    @ColumnInfo(name = "experience")
    //years
    public String experience;


    @ColumnInfo(name="eductaion")
    //MBBS_
    public String eductaion;

    public Doctor(int uid, String name, String specialization, String experience, String eductaion) {
        this.uid = uid;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.eductaion = eductaion;
    }

    @Ignore
    public Doctor(String name, String specialization, String experience, String eductaion) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.eductaion = eductaion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEductaion() {
        return eductaion;
    }

    public void setEductaion(String eductaion) {
        this.eductaion = eductaion;
    }
}
