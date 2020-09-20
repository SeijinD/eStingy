package com.example.e_stingy.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.e_stingy.Class.User;
import com.example.e_stingy.Fragment.F_Login;
import com.example.e_stingy.Fragment.F_Profile_Sales;
import com.example.e_stingy.Fragment.Room.F_Room_Profile;
import com.example.e_stingy.Fragment.Room.F_Room_Sales;
import com.example.e_stingy.R;

public class SalesActivity extends AppCompatActivity {
    // Create FragmentManager
    public static FragmentManager fragmentManager;

    public SalesActivity(){
        // Required empty public constructor
    }

    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();
        // If fragment_container != null and if not run already, run and open F_Room_Sales

        User user = ProMainActivity.eStingyDatabase.eStingyDao().getUserWithUsername(ProMainActivity.user_username);

        if(findViewById(R.id.fragment_container_sales) != null){
            if(savedInstanceState != null){
                return;
            }
            // Open activity with type
            if (user.getUser_type().equals("Customer"))
            {
                fragmentManager.beginTransaction().add(R.id.fragment_container_sales, new F_Profile_Sales()).commit();
            } else if (user.getUser_type().equals("Admin"))
            {
                fragmentManager.beginTransaction().add(R.id.fragment_container_sales, new F_Room_Sales()).commit();
            }

        }
    }
}
