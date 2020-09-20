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
import com.example.e_stingy.Class.User;
import com.example.e_stingy.R;

public class F_Delete_User extends Fragment {
    EditText input_username_user_delete;
    Button delete_user_button;

    public F_Delete_User() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_delete_user, container, false);
        input_username_user_delete = view.findViewById(R.id.input_username_user_delete);
        delete_user_button = view.findViewById(R.id.delete_user_button);
        // If click button delete_user
        delete_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_username_user_delete.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String var_user_username = input_username_user_delete.getText().toString();
                    User user = new User();
                    user.setUser_username(var_user_username);

                    // Call method deleteUser for delete user in database
                    ProMainActivity.eStingyDatabase.eStingyDao().deleteUser(user);

                    // Show message Deleted
                    Toast.makeText(getActivity(), "User Deleted!", Toast.LENGTH_LONG).show();

                    // Clean fields
                    input_username_user_delete.setText("");
                }
            }
        });
        return view;
    }
}
