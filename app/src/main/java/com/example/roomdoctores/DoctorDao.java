package com.example.roomdoctores;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    void insert(Doctor doctor);

    @Query("select * from my_table")
    List<Doctor> getAllDoctors();

}
