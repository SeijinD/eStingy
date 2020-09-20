package com.example.e_stingy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.Fragment.F_Login;
import com.example.e_stingy.MyAdapter_Cart;
import com.example.e_stingy.MyHolder_Cart;
import com.example.e_stingy.R;
import java.util.ArrayList;

public class PersonalCartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter_Cart myAdapter;
    Button buy_carts;
    TextView total_cost;

    public static double var_total_cost;

    // Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Load activity xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_cart);

        // Show total cose
        total_cost = findViewById(R.id.total_cost);
        total_cost.setText(String.valueOf(var_total_cost)+"$");

        buy_carts = findViewById(R.id.buy_carts);
        // If buy carts
        buy_carts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get all carts for this user from database
                ArrayList<Cart> carts = new ArrayList<>();
                carts.addAll(ProMainActivity.eStingyDatabase.eStingyDao().getCartsPerUser(ProMainActivity.user_username));
                // Create Sales from carts
                for(int i=0; i<carts.size(); i++)
                {
                    // Create temp sale
                    Sale sale = new Sale();
                    // Set up sale
                    sale.setP_id(carts.get(i).getP_id());
                    sale.setQuantity(carts.get(i).getCart_quantity());
                    sale.setU_username(carts.get(i).getU_username());
                    // Add sale in database
                    ProMainActivity.eStingyDatabase.eStingyDao().addSale(sale);
                }
                // Delete all carts for user
                int size = carts.size();
                for(int i=0; i<size; i++)
                {
                    ProMainActivity.eStingyDatabase.eStingyDao().deleteCart(carts.get(i));
                }
                var_total_cost = 0;
                total_cost.setText(String.valueOf(var_total_cost)+"$");

                // Show Message
                Toast.makeText(PersonalCartActivity.this, "Finished Buy!", Toast.LENGTH_SHORT).show();

                // Go Main Page
                Intent intent = new Intent(PersonalCartActivity.this, MainActivity_2.class);
                startActivity(intent);
            }
        });

        // RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view);
        // Set its properties
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // LinearLayout
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // GridLayout
        // Adapter
        myAdapter = new MyAdapter_Cart(this, getCarts());
        mRecyclerView.setAdapter(myAdapter);
    }

    // Add carts to arraylist
    private ArrayList<Cart> getCarts()
    {
        // Get all carts for this user from database
        ArrayList<Cart> carts = new ArrayList<>();
        carts.addAll(ProMainActivity.eStingyDatabase.eStingyDao().getCartsPerUser(ProMainActivity.user_username));

        return  carts;
    }

    // Go back in main page
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, MainActivity_2.class));
        finish();
    }
}
