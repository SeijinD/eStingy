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
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.R;

public class F_Insert_Sale extends Fragment {
    EditText input_u_username, input_p_id, input_quantity_sale;
    Button submit_sale_button;

    public F_Insert_Sale(){
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_insert_sale, container, false);
        input_u_username = view.findViewById(R.id.input_u_username);
        input_p_id = view.findViewById(R.id.input_p_id);
        input_quantity_sale = view.findViewById(R.id.input_quantity_sale);
        // If click button add_user
        submit_sale_button = view.findViewById(R.id.submit_sale_button);
        submit_sale_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_u_username.getText().toString().equals("")
                        ||  input_p_id.getText().toString().equals("")
                        || input_quantity_sale.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Get all texts from textfields
                    int var_p_id = 0;
                    int var_sale_quantity = 0;
                    try {
                        var_p_id = Integer.parseInt(input_p_id.getText().toString());
                        var_sale_quantity = Integer.parseInt(input_quantity_sale.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String var_username = input_u_username.getText().toString();

                    Sale sale = new Sale();
                    sale.setP_id(var_p_id);
                    sale.setQuantity(var_sale_quantity);
                    sale.setU_username(var_username);

                    // Call method addSale for add sale in database
                    ProMainActivity.eStingyDatabase.eStingyDao().addSale(sale);
                    // Show message Add Sale
                    Toast.makeText(getActivity(), "Sale Added!", Toast.LENGTH_SHORT).show();

                    // Clean fields
                    input_p_id.setText("");
                    input_u_username.setText("");
                    input_quantity_sale.setText("");
                }
            }
        });
        return view;
    }
}
