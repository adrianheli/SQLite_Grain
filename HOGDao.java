package com.example.graindetectdb;

import android.provider.FontsContract;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface HOGDao {
    /*@Insert
    void insertOnlySingleMovie (Movies movies);
    @Insert
    void insertMultipleMovies (List<Movies> moviesList);
    @Query (“SELECT * FROM Movies WHERE movieId = :movieId“)
    Movies fetchOneMoviesbyMovieId (int movieId);
    @Update
    void updateMovie (Movies movies);
    @Delete
    void deleteMovie (Movies movies);*/

    @Query("SELECT * FROM HOG")
    List<HOG> getAll();

    @Query("SELECT * FROM HOG WHERE uid IN (:userIds)")
    List<HOG> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM HOG WHERE win_SizeHeight LIKE :first AND " + "win_SizeHeight LIKE :second AND" +
            " win_SizeWidth LIKE :third AND" + " blockSizeHeight LIKE :third AND" + " blockSizeWidth" +
            " LIKE :fourth AND" + " blockStrideHeight LIKE :fifth AND" + " blockStrideWidth LIKE :sixth AND"
            + " cellSizeHeight LIKE :seventh AND" + " cellSizeWidth LIKE :eigth AND" +
            " nbins LIKE :last LIMIT 1")
    List<HOG> findByName(String first, String second, String third, String fourth, String fifth,
                   String sixth, String seventh, String eigth, String last);

    @Insert
    void insertMultipleHog(List<HOG> users);

    @Insert
    void insertOneHOG(HOG hog);

    @Delete
    void delete(HOG hog);

    @Update
    void update(HOG hog);
}

