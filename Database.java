package com.example.graindetectdb;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {HSV.class, HOG.class}, version = 2, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database INSTANCE;
    public abstract HSVDao hsvDao();
    public abstract HOGDao hogDao();
}
