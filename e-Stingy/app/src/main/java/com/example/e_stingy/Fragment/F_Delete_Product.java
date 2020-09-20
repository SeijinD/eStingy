package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.MainActivity;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.R;

public class F_Delete_Product extends Fragment {
    EditText input_id_product_delete;
    Button delete_product_button;

    public F_Delete_Product() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_delete_product, container, false);
        input_id_product_delete = view.findViewById(R.id.input_id_product_delete);
        delete_product_button = view.findViewById(R.id.delete_product_button);
        // If click button delete_user
        delete_product_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_id_product_delete.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int var_product_id = 0;
                    try {
                        // Get Text from id_user
                        var_product_id = Integer.parseInt(input_id_product_delete.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    Product product = new Product();
                    product.setProduct_id(var_product_id);

                    // Call method deleteProduct for delete product in database
                    MainActivity.eStingyDatabase.eStingyDao().deleteProduct(product);

                    // Show message Deleted
                    Toast.makeText(getActivity(), "Product Deleted!", Toast.LENGTH_LONG).show();

                    // Clean fields
                    input_id_product_delete.setText("");
                }
            }
        });
        return view;
    }
}
