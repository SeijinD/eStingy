package com.example.e_stingy.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.e_stingy.EStingyDatabase;
import com.example.e_stingy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        // Create fragmentManager
        fragmentManager = getSupportFragmentManager();

        // Set up toolbar, drawerLayout and naviagationView
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.open_room_users_button:
                        menuItem.setChecked(true);
                        displayMessage("Open User Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent usersRoom = new Intent(MainActivity.this, UsersActivity.class);
                        startActivity(usersRoom);
                        break;
                    case R.id.open_room_products_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Product Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent productsRoom = new Intent(MainActivity.this, ProductsActivity.class);
                        startActivity(productsRoom);
                        break;
                    case R.id.open_room_sales_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Sale Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent salesRoom = new Intent(MainActivity.this, SalesActivity.class);
                        startActivity(salesRoom);
                        break;
                    case R.id.open_room_carts_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Carts Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent cartsRoom = new Intent(MainActivity.this, CartsActivity.class);
                        startActivity(cartsRoom);
                        break;
                    case R.id.open_room_query_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Query Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent queryRoom = new Intent(MainActivity.this, QueryActivity.class);
                        startActivity(queryRoom);
                        break;
                    case R.id.open_room_info_button:
                        menuItem.setChecked(true);
                        displayMessage("Open Info Room.");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent infoRoom = new Intent(MainActivity.this, InfoActivity.class);
                        startActivity(infoRoom);
                        break;
                    case R.id.logout_button:
                        menuItem.setChecked(true);
                        displayMessage("Logout...");
                        drawerLayout.closeDrawers();
                        // Create a Intent for open new activity
                        Intent logout = new Intent(MainActivity.this, ProMainActivity.class);
                        startActivity(logout);
                        break;
                }
                return  false;
            }
        });
    }

    // Overdide this method because I have not back if you login in app without click logout
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
