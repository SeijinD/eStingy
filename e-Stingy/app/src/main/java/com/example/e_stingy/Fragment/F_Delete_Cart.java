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

public class F_Delete_Cart extends Fragment {
    EditText input_cart_id;
    Button delete_cart_button;

    public F_Delete_Cart() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_delete_cart, container, false);
        input_cart_id = view.findViewById(R.id.input_cart_id);
        delete_cart_button = view.findViewById(R.id.delete_cart_button);
        // If click button delete_cart
        delete_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_cart_id.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int var_cart_id = 0;
                    try {
                        // Get Text from id_product
                        var_cart_id = Integer.parseInt(input_cart_id.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }

                    Cart cart = new Cart();
                    cart.setCart_id(var_cart_id);

                    // Call method deleteUser for delete cart in database
                    ProMainActivity.eStingyDatabase.eStingyDao().deleteCart(cart);

                    // Show message Deleted
                    Toast.makeText(getActivity(), "Cart Deleted!", Toast.LENGTH_LONG).show();

                    // Clean fields
                    input_cart_id.setText("");
                }
            }
        });
        return view;
    }
}
