package com.example.e_stingy;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class MyHolder_Cart extends RecyclerView.ViewHolder {

    // Set up my products for MyHolder
    TextView recyclerViewCartP_Id, recyclerViewCartQuantity, recyclerViewCartUsername, recycler_view_cart_id;
    Button delete_cart_button;

    public MyHolder_Cart(View itemView)
    {
        super(itemView);
        recycler_view_cart_id = itemView.findViewById(R.id.recycler_view_cart_id);
        recyclerViewCartP_Id = itemView.findViewById(R.id.recycler_view_cart_p_id);
        recyclerViewCartUsername = itemView.findViewById(R.id.recycler_view_cart_username);
        recyclerViewCartQuantity = itemView.findViewById(R.id.recycler_view_cart_quantity);
        delete_cart_button = itemView.findViewById(R.id.delete_cart_button);
    }
}
