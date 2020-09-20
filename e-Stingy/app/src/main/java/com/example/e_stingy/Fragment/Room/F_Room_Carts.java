package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.CartsActivity;
import com.example.e_stingy.Fragment.F_Delete_Cart;
import com.example.e_stingy.Fragment.F_Insert_Cart;
import com.example.e_stingy.Fragment.F_Update_Cart;
import com.example.e_stingy.R;

public class F_Room_Carts extends Fragment implements View.OnClickListener{
    Button add_cart_button, update_cart_button, delete_cart_button;

    public F_Room_Carts() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_carts, container,false);

        // Add Sale
        add_cart_button = view.findViewById(R.id.add_cart_button);
        add_cart_button.setOnClickListener(this);

        // Update Sale
        update_cart_button = view.findViewById(R.id.update_cart_button);
        update_cart_button.setOnClickListener(this);

        // Delete Sale
        delete_cart_button = view.findViewById(R.id.delete_cart_button);
        delete_cart_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_cart_button:
                CartsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_carts, new F_Insert_Cart()).addToBackStack(null).commit();
                break;
            case R.id.update_cart_button:
                CartsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_carts, new F_Update_Cart()).addToBackStack(null).commit();
                break;
            case R.id.delete_cart_button:
                CartsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_carts, new F_Delete_Cart()).addToBackStack(null).commit();
                break;
        }
    }

}
