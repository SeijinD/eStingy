package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.QueryActivity;
import com.example.e_stingy.Fragment.F_Query_All_Products;
import com.example.e_stingy.Fragment.F_Query_All_Sales;
import com.example.e_stingy.Fragment.F_Query_All_Sales_Per_Product;
import com.example.e_stingy.Fragment.F_Query_All_Users;
import com.example.e_stingy.R;

public class F_Room_Query extends Fragment implements View.OnClickListener{
    Button query_all_users_button, query_all_products_button, query_all_sales_button, query_all_sales_per_product_button;

    public F_Room_Query() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_query, container,false);

        // Get all users button
        query_all_users_button = view.findViewById(R.id.query_all_users_button);
        query_all_users_button.setOnClickListener(this);

        // Get all products button
        query_all_products_button = view.findViewById(R.id.query_all_products_button);
        query_all_products_button.setOnClickListener(this);

        // Get all sales button
        query_all_sales_button = view.findViewById(R.id.query_all_sales_button);
        query_all_sales_button.setOnClickListener(this);

        // Get all sales per product button
        query_all_sales_per_product_button = view.findViewById(R.id.query_all_sales_per_product_button);
        query_all_sales_per_product_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.query_all_users_button:
                QueryActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_query, new F_Query_All_Users()).addToBackStack(null).commit();
                break;
            case R.id.query_all_products_button:
                QueryActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_query, new F_Query_All_Products()).addToBackStack(null).commit();
                break;
            case R.id.query_all_sales_button:
                QueryActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_query, new F_Query_All_Sales()).addToBackStack(null).commit();
                break;
            case R.id.query_all_sales_per_product_button:
                QueryActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_query, new F_Query_All_Sales_Per_Product()).addToBackStack(null).commit();
                break;
        }
    }

}
