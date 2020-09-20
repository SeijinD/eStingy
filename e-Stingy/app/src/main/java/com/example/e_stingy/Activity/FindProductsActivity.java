package com.example.e_stingy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_stingy.Class.Product;
import com.example.e_stingy.MyAdapter_Product;
import com.example.e_stingy.R;

import java.util.ArrayList;

public class FindProductsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter_Product myAdapter;
    Spinner product_category_spinner;
    Button search_button;

    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_products);

        // Set Up Spinner and Adapter for Spinner
        product_category_spinner = findViewById(R.id.product_category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products_category, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        product_category_spinner.setAdapter(adapter);
        product_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view);
        // Set its properties
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // LinearLayout
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // GridLayout
        // Adapter
        myAdapter = new MyAdapter_Product(this, getProducts());
        mRecyclerView.setAdapter(myAdapter);

        // Search Button
        search_button = findViewById(R.id.search_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Selected product category
                String selected_product_category = product_category_spinner.getSelectedItem().toString();

                // RecyclerView
                mRecyclerView = findViewById(R.id.recycler_view);
                // Set its properties
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // LinearLayout
                //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // GridLayout
                // Adapter
                myAdapter = new MyAdapter_Product(getApplicationContext(), getProductsByCategory(selected_product_category));
                mRecyclerView.setAdapter(myAdapter);
            }
        });
    }

    // Add products to arraylist
    private ArrayList<Product> getProducts()
    {
        // Create temp list products
        ArrayList<Product> products = new ArrayList<>();

        // Add all products from database
        products.addAll(ProMainActivity.eStingyDatabase.eStingyDao().getProducts());

        return  products;
    }

    // Add products by category to arraylist
    private ArrayList<Product> getProductsByCategory(String selected_product_category)
    {
        // Create temp list products
        ArrayList<Product> products2 = new ArrayList<>();

        // Add all products by category from database
        products2.addAll(ProMainActivity.eStingyDatabase.eStingyDao().getAllProductsByCategory(selected_product_category));

        return  products2;
    }

    // Go back in main page
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, MainActivity_2.class));
        finish();
    }
}
