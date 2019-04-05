package com.example.graindetection;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        DataObject dataObject1 = new DataObject(1, 123, 222, 123, 123, 133,
                123,1334, 1234, 233);
        DataObject dataObject2 = new DataObject(1, 123, 222, 123, 123, 133,
                1423);
        DataObject dataObject3 = new DataObject(2, 134 , 134, 134,333,11, 235);

        //db.addDataObjectHSV(dataObject2);


        List<DataObject> data = db.allDataHOG();
        List<DataObject> data1 = db.allDataHSV();
        for(DataObject obj : data1){
            obj.get_All_Info_HSV();
        }

    }


}
