package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.R;

import java.util.List;


public class F_Query_All_Products extends Fragment {
    TextView txt_query_all_products;

    public F_Query_All_Products() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_query_all_products, container, false);

        //
        txt_query_all_products = view.findViewById(R.id.txt_query_all_products);
        List<Product> products = ProMainActivity.eStingyDatabase.eStingyDao().getProducts();
        String result = "";
        for (Product i: products){
            int code = i.getProduct_id();
            String name = i.getProduct_name();
            double cost = i.getProduct_cost();
            String info = i.getProduct_info();
            int quantity = i.getProduct_quantity();
            String category = i.getProduct_category();
            result = result + "\n Id: "+code+"\n Name: "+name+"\n Info: "+info+"\n Category: "+category+"\n Cost: "+cost+ "$" +"\n Quantity: "+quantity+"\n";
        }
        txt_query_all_products.setText(result);

        return view;
    }
}
