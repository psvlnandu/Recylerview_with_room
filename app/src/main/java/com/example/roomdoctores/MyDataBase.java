package com.example.roomdoctores;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Doctor.class, exportSchema = false,version = 1)
public abstract class MyDataBase extends RoomDatabase {
    public abstract DoctorDao doctorDao();

    private static final String DB_NAME="DoctorDB";
    private static MyDataBase instance;

    public static synchronized MyDataBase getInstance(Context context)
    {
        if(instance==null)
        {
            instance=Room.databaseBuilder(context,MyDataBase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
