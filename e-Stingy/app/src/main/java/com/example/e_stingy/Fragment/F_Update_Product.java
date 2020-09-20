package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.R;


public class F_Update_Product extends Fragment {
    EditText input_name_product_update, input_info_product_update, input_cost_product_update, input_quantity_product_update;
    Button update_product_button;
    Spinner input_product_category_update;

    public F_Update_Product() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_update_product, container, false);
        input_name_product_update = view.findViewById(R.id.input_name_product_update);
        input_info_product_update = view.findViewById(R.id.input_info_product_update);
        input_cost_product_update = view.findViewById(R.id.input_cost_product_update);
        input_quantity_product_update = view.findViewById(R.id.input_quantity_product_update);
        input_product_category_update = view.findViewById(R.id.input_product_category_update);

        // Set Up Spinner and Adapter for Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.products_category, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        input_product_category_update.setAdapter(adapter);

        input_product_category_update.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                // Showing selected spinner item
                //product_id_title.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // If click button add_product
        update_product_button = view.findViewById(R.id.update_product_button);
        update_product_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_name_product_update.getText().toString().equals("")
                        ||  input_info_product_update.getText().toString().equals("")
                        || input_cost_product_update.getText().toString().equals("")
                        || input_quantity_product_update.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    // Selected product category
                    String selected_product_category = input_product_category_update.getSelectedItem().toString();

                    // Get all texts from textfields
                    double var_product_cost = 0;
                    int var_product_quantity = 0;
                    try {
                        var_product_cost = Double.parseDouble(input_cost_product_update.getText().toString());
                        var_product_quantity = Integer.parseInt(input_quantity_product_update.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String var_product_name = input_name_product_update.getText().toString();
                    String var_product_info = input_info_product_update.getText().toString();
                    String var_product_category = selected_product_category;

                    Product product = new Product();
                    product.setProduct_name(var_product_name);
                    product.setProduct_info(var_product_info);
                    product.setProduct_cost(var_product_cost);
                    product.setProduct_quantity(var_product_quantity);
                    product.setProduct_category(var_product_category);

                    // Call method updateProduct for update product in database
                    ProMainActivity.eStingyDatabase.eStingyDao().updateProduct(product);
                    // Show message Product Updated
                    Toast.makeText(getActivity(), "Product Updated!", Toast.LENGTH_SHORT).show();

                    // Clean fields
                    input_name_product_update.setText("");
                    input_info_product_update.setText("");
                    input_cost_product_update.setText("");
                    input_quantity_product_update.setText("");
                }
            }
        });
        return view;
    }

}
