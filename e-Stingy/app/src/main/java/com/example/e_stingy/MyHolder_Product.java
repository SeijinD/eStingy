package com.example.e_stingy;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class MyHolder_Product extends RecyclerView.ViewHolder {

    // Set up my products for MyHolder
    TextView recyclerViewProductCode, recyclerViewProductTitle, recyclerViewProductInfo, recyclerViewProductCost, recyclerViewProductQuantity;
    Button cart_button;
    ImageView recyclerViewProductImage;

    public MyHolder_Product(View itemView)
    {
        super(itemView);
        recyclerViewProductCode = itemView.findViewById(R.id.recycler_view_product_code);
        recyclerViewProductTitle = itemView.findViewById(R.id.recycler_view_product_title);
        recyclerViewProductInfo = itemView.findViewById(R.id.recycler_view_product_info);
        recyclerViewProductCost = itemView.findViewById(R.id.recycler_view_product_cost);
        recyclerViewProductQuantity = itemView.findViewById(R.id.recycler_view_product_quantity);
        cart_button = itemView.findViewById(R.id.cart_button);
//        recyclerViewProductImage = itemView.findViewById(R.id.recycler_view_product_image);
    }
}
