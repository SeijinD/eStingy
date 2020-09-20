package com.example.e_stingy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_stingy.Activity.FindProductsActivity;
import com.example.e_stingy.Activity.PersonalCartActivity;
import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.Class.Product;

import java.util.ArrayList;

public class MyAdapter_Product extends RecyclerView.Adapter<MyHolder_Product> {

    // Create Context and ArrayList from products
    Context c;
    ArrayList<Product> products;

    // Constructor
    public MyAdapter_Product(Context c, ArrayList<Product> products)
    {
        this.c = c;
        this.products = products;
    }

    @NonNull
    @Override
    public MyHolder_Product onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Convert xml to view objects
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_product, null);

        return new MyHolder_Product(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder_Product holder, int position) {
        // Bind data to our views
        holder.recyclerViewProductTitle.setText("Title: "+products.get(position).getProduct_name());
        holder.recyclerViewProductInfo.setText("Info: "+products.get(position).getProduct_info());
        holder.recyclerViewProductCost.setText("Cost: "+Double.toString(products.get(position).getProduct_cost())+ "$");
        holder.recyclerViewProductQuantity.setText("Quantity: "+Integer.toString(products.get(position).getProduct_quantity()));
        holder.recyclerViewProductCode.setText(Integer.toString(products.get(position).getProduct_id()));
//        holder.recyclerViewProductImage.setImageResource(products.get(position).getProduct_img());

        // If add cart button
        holder.cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get potition
                int position = Integer.parseInt(holder.recyclerViewProductCode.getText().toString());
                // create temp product
                Product product = ProMainActivity.eStingyDatabase.eStingyDao().getProductById(position);
                // quantity + 1
                product.setProduct_quantity(product.getProduct_quantity()-1);
                // update product
                ProMainActivity.eStingyDatabase.eStingyDao().updateProduct(product);
                // create cart
                Cart cart = new Cart();
                // Set up cart
                cart.setP_id(product.getProduct_id());
                cart.setCart_quantity(1);
                cart.setU_username(ProMainActivity.user_username);
                // Add cart in database
                ProMainActivity.eStingyDatabase.eStingyDao().addCart(cart);
                // update price in carts
                PersonalCartActivity.var_total_cost += product.getProduct_cost();

                // Open again FindProductsActivity
                Intent intent = new Intent(c, FindProductsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(intent);
            }
        });

        // Animation
        Animation animation = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    // Get sie of products
    @Override
    public int getItemCount() {
        return products.size();
    }
}
