package com.example.graindetectdb;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "grain_db";
    private Database grain_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        grain_db = Room.databaseBuilder(getApplicationContext(),
                Database.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                HSV one = new HSV();
                one.setHue_higher_B("134");
                one.setHue_lower_B("1134");
                one.setSaturation_higher_B("3445");
                one.setSaturation_lower_B("334555");
                one.setValue_higher_B("9987");
                one.setValue_lower_B("5555");
                grain_db.hsvDao().insertOnlyOne(one);

                System.out.println(one.getSaturation_higher_B());
            }
        }).start();


    }

}
