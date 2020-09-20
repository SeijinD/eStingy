package com.example.e_stingy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.e_stingy.EStingyDatabase;
import com.example.e_stingy.Fragment.F_Login;
import com.example.e_stingy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity_2 extends AppCompatActivity {
    TextView view_username_user;

    // Create toolbar, drawerLayout and naviagationView
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    // Create FragmentManager and EStingyDatabase
    public static FragmentManager fragmentManager;
    public static EStingyDatabase eStingyDatabase;


    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();

        // Set up toolbar, drawerLayout and naviagationView
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        view_username_user = findViewById(R.id.view_username_user);
        // Show username from user
        view_username_user.setText(ProMainActivity.user_username);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.open_room_profile_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Profile.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent profileRoom = new Intent(MainActivity_2.this, ProfileActivity.class);
                        startActivity(profileRoom);
                        break;
                    case R.id.open_room_find_products_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Products Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent productsRoom = new Intent(MainActivity_2.this, FindProductsActivity.class);
                        startActivity(productsRoom);
                        break;
                    case R.id.open_room_history_sales_button:
                        menuItem.setChecked(true);
                        displayMessage("Open History Sales Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent salesRoom = new Intent(MainActivity_2.this, SalesActivity.class);
                        startActivity(salesRoom);
                        break;
                    case R.id.open_room_cart_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Cart.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent cartsRoom = new Intent(MainActivity_2.this, PersonalCartActivity.class);
                        startActivity(cartsRoom);
                        break;
                    case R.id.open_room_info_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Info Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent infoRoom = new Intent(MainActivity_2.this, InfoActivity.class);
                        startActivity(infoRoom);
                        break;
                    case R.id.logout_button:
                        menuItem.setChecked(true);
                        displayMessage("Logout...");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent logout = new Intent(MainActivity_2.this, ProMainActivity.class);
                        startActivity(logout);
                        break;
                }
                return  false;
            }
        });
    }

    void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // Overdide this method because I have not back if you login in app without click logout
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, MainActivity_2.class));
        finish();
    }
}
