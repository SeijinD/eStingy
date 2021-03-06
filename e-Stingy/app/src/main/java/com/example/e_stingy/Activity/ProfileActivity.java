package com.example.e_stingy.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.e_stingy.Fragment.Room.F_Room_Profile;
import com.example.e_stingy.Fragment.Room.F_Room_Users;
import com.example.e_stingy.R;

public class ProfileActivity extends AppCompatActivity {
    // Create FragmentManager
    public static FragmentManager fragmentManager;

    public ProfileActivity(){
        // Required empty public constructor
    }

    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();
        // If fragment_container != null and if not run already, run and open F_Room_Users
        if(findViewById(R.id.fragment_container_profile) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container_profile, new F_Room_Profile()).commit();
        }
    }
}
