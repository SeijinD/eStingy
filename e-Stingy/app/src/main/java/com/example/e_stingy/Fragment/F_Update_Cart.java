package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.R;


public class F_Update_Cart extends Fragment {
    EditText input_cart_id_update, input_u_username_update, input_p_id_update, input_quantity_cart_update;
    Button update_cart_button;

    public F_Update_Cart() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_update_cart, container, false);
        input_cart_id_update = view.findViewById(R.id.input_cart_id_update);
        input_u_username_update = view.findViewById(R.id.input_u_username_update);
        input_p_id_update = view.findViewById(R.id.input_p_id_update);
        input_quantity_cart_update = view.findViewById(R.id.input_quantity_cart_update);
        // If click button add_user
        update_cart_button = view.findViewById(R.id.update_cart_button);
        update_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_u_username_update.getText().toString().equals("")
                        || input_cart_id_update.getText().toString().equals("")
                        || input_p_id_update.getText().toString().equals("")
                        ||  input_quantity_cart_update.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Get all texts from textfields
                    int var_cart_id = 0;
                    int var_id_product = 0;
                    int var_cart_quantity = 0;
                    try {
                        // Get Text from id_product
                        var_cart_id = Integer.parseInt(input_cart_id_update.getText().toString());
                        var_id_product = Integer.parseInt(input_p_id_update.getText().toString());
                        var_cart_quantity = Integer.parseInt(input_quantity_cart_update.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String var_u_username = input_u_username_update.getText().toString();

                    Cart cart = new Cart();
                    cart.setCart_id(var_cart_id);
                    cart.setP_id(var_id_product);
                    cart.setU_username(var_u_username);
                    cart.setCart_quantity(var_cart_quantity);

                    // Call method addUser for update cart in database
                    ProMainActivity.eStingyDatabase.eStingyDao().updateCart(cart);
                    // Show message Update Cart
                    Toast.makeText(getActivity(), "Cart Update!", Toast.LENGTH_SHORT).show();

                    // Clean fields
                    input_cart_id_update.setText("");
                    input_u_username_update.setText("");
                    input_p_id_update.setText("");
                    input_quantity_cart_update.setText("");
                }
            }
        });

        return view;
    }

}
