package com.example.e_stingy.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.e_stingy.Fragment.Room.F_Room_Query;
import com.example.e_stingy.R;

public class QueryActivity extends AppCompatActivity {
    // Create FragmentManager
    public static FragmentManager fragmentManager;

    public QueryActivity(){
        // Required empty public constructor
    }

    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();
        // If fragment_container != null and if not run already, run and open F_Room_Query
        if(findViewById(R.id.fragment_container_query) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container_query, new F_Room_Query()).commit();
        }
    }


}
