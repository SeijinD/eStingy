package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.R;

import java.util.List;


public class F_Query_All_Sales_Per_Product extends Fragment{
    TextView txt_query_all_sales_per_product, product_id_title;
    Spinner product_id_spinner;
    Button query_run;

    public F_Query_All_Sales_Per_Product() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_query_all_sales_per_product, container, false);

        txt_query_all_sales_per_product = view.findViewById(R.id.txt_query_all_sales_per_product);
        product_id_title = view.findViewById(R.id.product_id_title);
        query_run = view.findViewById(R.id.query_run);
        product_id_spinner = view.findViewById(R.id.product_id_spinner);

        // Load Products Id
        List<Integer> items = ProMainActivity.eStingyDatabase.eStingyDao().getAllProductsId();

        // Set Up Spinner and Adapter for Spinner
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(super.getContext(), R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        product_id_spinner.setAdapter(adapter);

        product_id_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                // Showing selected spinner item
                product_id_title.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // If click button to run
        query_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get product_id
                int selected_product_id = Integer.parseInt(product_id_spinner.getSelectedItem().toString());

                // Call method getSalesPerProduct with selected_product_id and show sales for this product_id
                List<Sale> sales = ProMainActivity.eStingyDatabase.eStingyDao().getSalesPerProduct(selected_product_id);
                String result = "";
                for (Sale i: sales){
                    int code = i.getId();
                    int Product_Id = i.getP_id();
                    String u_username = i.getU_username();
                    int quantity = i.getQuantity();
                    result = result + "\n Id: "+code+"\n Product Id: "+Product_Id+"\n User Username: "+u_username+"\n Quantity: "+quantity+"\n";
                }
                txt_query_all_sales_per_product.setText(result);
            }
        });

        return view;
    }
}
