package com.example.roomdoctores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdoctores.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);



       new bgthread().start();
        while (new bgthread().isAlive())
        {
            Log.d("Thread  waitimg","waitigggggggg: ");
        }



    }
    class bgthread extends Thread
    {
        public void run()
        {
            super.run();
            db = MyDataBase.getInstance(MainActivity.this);

            db.doctorDao().insert(new Doctor("Dr. Mernedezz","surgeon","4yrs","MBBS"));
            db.doctorDao().insert(new Doctor("Dr. Kim","surgeon","4yrs","MBBS"));
            db.doctorDao().insert(new Doctor("Dr. Glassman","surgeon","4yrs","MBBS"));
            db.doctorDao().insert(new Doctor("Dr. Shaun","surgeon","4yrs","MBBS"));
            db.doctorDao().insert(new Doctor("Dr. Nana","surgeon","4yrs","MBBS"));
            db.doctorDao().insert(new Doctor("Mernedezz","surgeon","4yrs","MBBS"));

            List<Doctor> doctorArrayList=new ArrayList<>();
            doctorArrayList=db.doctorDao().getAllDoctors();

            for(int i=0;i<doctorArrayList.size();i++)
            {
                Log.e("TAG","exected "+db.doctorDao().getAllDoctors().get(i).getName() );
                //Log.d("Data", ": "+ doctorArrayList.get(i).getName()+"-"+doctorArrayList.get(i).getSpecialization());
            }

            MyAdapter adapter = new MyAdapter(doctorArrayList);
            mainBinding.rv.setAdapter(adapter);
            mainBinding.rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        }
    }

}