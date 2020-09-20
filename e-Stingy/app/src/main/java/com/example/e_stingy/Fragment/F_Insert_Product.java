package com.example.e_stingy.Fragment;

import android.content.ContentProvider;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.R;

public class F_Insert_Product extends Fragment {
    EditText input_name_product, input_info_product, input_cost_product, input_quantity_product;
    Button submit_product_button;
    Spinner input_category_product;

    public F_Insert_Product(){
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_insert_product, container, false);
        input_name_product = view.findViewById(R.id.input_name_product);
        input_info_product = view.findViewById(R.id.input_info_product);
        input_cost_product = view.findViewById(R.id.input_cost_product);
        input_quantity_product = view.findViewById(R.id.input_quantity_product);
        input_category_product = view.findViewById(R.id.input_category_product);

        // Set Up Spinner and Adapter for Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.products_category, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        input_category_product.setAdapter(adapter);

        input_category_product.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // If click button add_product
        submit_product_button = view.findViewById(R.id.submit_product_button);
        submit_product_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_name_product.getText().toString().equals("")
                        ||  input_info_product.getText().toString().equals("")
                        || input_cost_product.getText().toString().equals("")
                        || input_quantity_product.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Selected product category
                    String selected_product_category = input_category_product.getSelectedItem().toString();

                    // Get all texts from textfields
                    double var_product_cost = 0;
                    int var_product_quantity = 0;
                    try {
                        var_product_cost = Double.parseDouble(input_cost_product.getText().toString());
                        var_product_quantity = Integer.parseInt(input_quantity_product.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String var_product_name = input_name_product.getText().toString();
                    String var_product_info = input_info_product.getText().toString();
                    String var_product_category = selected_product_category;


                    Product product = new Product();
                    product.setProduct_name(var_product_name);
                    product.setProduct_info(var_product_info);
                    product.setProduct_cost(var_product_cost);
                    product.setProduct_quantity(var_product_quantity);
                    product.setProduct_category(var_product_category);

                    // Call method addProduct for add product in database
                    ProMainActivity.eStingyDatabase.eStingyDao().addProduct(product);
                    // Show message Add it
                    Toast.makeText(getActivity(), "Product Added!", Toast.LENGTH_SHORT).show();

                    // Clean fields
                    input_name_product.setText("");
                    input_info_product.setText("");
                    input_cost_product.setText("");
                    input_quantity_product.setText("");
                }
            }
        });
        return view;
    }
}
