package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProductsActivity;
import com.example.e_stingy.Fragment.F_Delete_Product;
import com.example.e_stingy.Fragment.F_Insert_Product;
import com.example.e_stingy.Fragment.F_Update_Product;
import com.example.e_stingy.R;

public class F_Room_Products extends Fragment implements View.OnClickListener{
    Button add_product_button, update_product_button, delete_product_button;

    public F_Room_Products() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_products, container,false);

        // Add Product
        add_product_button = view.findViewById(R.id.add_product_button);
        add_product_button.setOnClickListener(this);

        // Update Product
        update_product_button = view.findViewById(R.id.update_product_button);
        update_product_button.setOnClickListener(this);

        // Delete Product
        delete_product_button = view.findViewById(R.id.delete_product_button);
        delete_product_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_product_button:
                ProductsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_products, new F_Insert_Product()).addToBackStack(null).commit();
                break;
            case R.id.update_product_button:
                ProductsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_products, new F_Update_Product()).addToBackStack(null).commit();
                break;
            case R.id.delete_product_button:
                ProductsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_products, new F_Delete_Product()).addToBackStack(null).commit();
                break;
        }
    }

}
