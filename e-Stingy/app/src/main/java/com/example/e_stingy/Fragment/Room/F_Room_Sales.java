package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.SalesActivity;
import com.example.e_stingy.Fragment.F_Delete_Sale;
import com.example.e_stingy.Fragment.F_Insert_Sale;
import com.example.e_stingy.Fragment.F_Update_Sale;
import com.example.e_stingy.R;

public class F_Room_Sales extends Fragment implements View.OnClickListener{
    Button add_sale_button, update_sale_button, delete_sale_button;

    public F_Room_Sales() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_sales, container,false);

        // Add Sale
        add_sale_button = view.findViewById(R.id.add_sale_button);
        add_sale_button.setOnClickListener(this);

        // Update Sale
        update_sale_button = view.findViewById(R.id.update_sale_button);
        update_sale_button.setOnClickListener(this);

        // Delete Sale
        delete_sale_button = view.findViewById(R.id.delete_sale_button);
        delete_sale_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_sale_button:
                SalesActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_sales, new F_Insert_Sale()).addToBackStack(null).commit();
                break;
            case R.id.update_sale_button:
                SalesActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_sales, new F_Update_Sale()).addToBackStack(null).commit();
                break;
            case R.id.delete_sale_button:
                SalesActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_sales, new F_Delete_Sale()).addToBackStack(null).commit();
                break;
        }
    }

}
