package com.example.e_stingy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_stingy.Activity.PersonalCartActivity;
import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.Fragment.F_Login;

import java.util.ArrayList;

public class MyAdapter_Cart extends RecyclerView.Adapter<MyHolder_Cart> {

    // Create Context and ArrayList from products
    Context c;
    ArrayList<Cart> carts;

    // Constructor
    public MyAdapter_Cart(Context c, ArrayList<Cart> carts) {
        this.c = c;
        this.carts = carts;
    }

    @NonNull
    @Override
    public MyHolder_Cart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Convert xml to view objects
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_cart, null);
        return new MyHolder_Cart(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder_Cart holder, int position) {
        // Bind data to our views
        holder.recycler_view_cart_id.setText(Integer.toString(carts.get(position).getCart_id()));
        holder.recyclerViewCartP_Id.setText(Integer.toString(carts.get(position).getP_id()));
        holder.recyclerViewCartUsername.setText(carts.get(position).getU_username());
        holder.recyclerViewCartQuantity.setText(Integer.toString(carts.get(position).getCart_quantity()));

        // If click delete cart button
        holder.delete_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get potition
                int position = Integer.parseInt(holder.recyclerViewCartP_Id.getText().toString());
                // create temp product
                Product product = ProMainActivity.eStingyDatabase.eStingyDao().getProductById(position);
                // quantity - 1
                product.setProduct_quantity(product.getProduct_quantity() + 1);
                // update product
                ProMainActivity.eStingyDatabase.eStingyDao().updateProduct(product);
                // create cart
                Cart cart = ProMainActivity.eStingyDatabase.eStingyDao().getCart(ProMainActivity.user_username, product.getProduct_id());
                // Delete cart in database
                ProMainActivity.eStingyDatabase.eStingyDao().deleteCart(cart);
                // update price in carts
                PersonalCartActivity.var_total_cost -= product.getProduct_cost();

                // Open again PersonalCartAvcivity
                Intent intent = new Intent(c, PersonalCartActivity.class);
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
        return carts.size();
    }

}
