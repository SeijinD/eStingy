package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.R;

import java.util.List;


public class F_Profile_Sales extends Fragment {
    TextView txt_query_profile_sales;

    public F_Profile_Sales() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_profile_sales, container, false);

        //
        txt_query_profile_sales = view.findViewById(R.id.txt_query_profile_sales);
        List<Sale> sales = ProMainActivity.eStingyDatabase.eStingyDao().getSalesPerUser(ProMainActivity.user_username);
        String result = "";
        for (Sale i: sales){
            int code = i.getId();
            int Product_Id = i.getP_id();
            int quantity = i.getQuantity();
            result = result + "\n Id: "+code+"\n Product Id: "+Product_Id+"\n Quantity: "+quantity+"\n";
        }
        txt_query_profile_sales.setText(result);

        return view;
    }
}
