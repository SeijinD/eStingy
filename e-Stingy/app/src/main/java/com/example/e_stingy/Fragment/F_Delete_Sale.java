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

public class F_Delete_Sale extends Fragment {
    EditText input_id_sale_delete;
    Button delete_sale_button;

    public F_Delete_Sale() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_delete_sale, container, false);
        input_id_sale_delete = view.findViewById(R.id.input_id_sale_delete);
        delete_sale_button = view.findViewById(R.id.delete_sale_button);
        // If click button delete_sale
        delete_sale_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_id_sale_delete.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int var_sale_id = 0;
                    try {
                        // Get Text from id_sale
                        var_sale_id = Integer.parseInt(input_id_sale_delete.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    Sale sale = new Sale();
                    sale.setId(var_sale_id);

                    // Call method deleteUser for delete sale in database
                    ProMainActivity.eStingyDatabase.eStingyDao().deleteSale(sale);

                    // Show message Deleted
                    Toast.makeText(getActivity(), "Sale Deleted!", Toast.LENGTH_LONG).show();

                    // Clean fields
                    input_id_sale_delete.setText("");
                }
            }
        });
        return view;
    }
}
