package com.example.e_stingy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.e_stingy.EStingyDatabase;
import com.example.e_stingy.Fragment.Room.F_Room_Login_Signin;
import com.example.e_stingy.R;

public class ProMainActivity extends AppCompatActivity {

    // public static variable for use in app for I know the user
    public static String user_username;

    // Create toolbar
    Toolbar toolbar;

    // Create FragmentManager and EStingyDatabase
    public static FragmentManager fragmentManager;
    public static EStingyDatabase eStingyDatabase;


    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_main);
        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();
        // Create eStingyDatabase with disk database name userDB
        // When upgrading versions, kill the original tables by using fallbackToDestructiveMigration()
        eStingyDatabase = Room.databaseBuilder(getApplicationContext(),EStingyDatabase.class, "userDB").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        // Clear all Tables
        //MainActivity.eStingyDatabase.clearAllTables();

        // Set up toolbar, drawerLayout and naviagationView
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // If fragment_container != null and if not run already, run and open F_RoomUI
        if(findViewById(R.id.fragment_container_pro_main) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container_pro_main, new F_Room_Login_Signin()).commit();
        }
    }

    void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // Go back in main page
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, ProMainActivity.class));
        finish();
    }
}
