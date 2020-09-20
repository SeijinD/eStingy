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


public class F_Update_Profile extends Fragment {
    EditText input_username_profile_update, input_password_profile_update, input_password2_profile_update, input_name_profile_update, input_surname_profile_update, input_phone_profile_update, input_email_profile_update;
    Button update_profile_button;

    public F_Update_Profile() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_update_profile, container, false);
        input_username_profile_update = view.findViewById(R.id.input_username_profile_update);
        input_password_profile_update = view.findViewById(R.id.input_password_profile_update);
        input_password2_profile_update = view.findViewById(R.id.input_password2_profile_update);
        input_name_profile_update = view.findViewById(R.id.input_name_profile_update);
        input_surname_profile_update = view.findViewById(R.id.input_surname_profile_update);
        input_phone_profile_update = view.findViewById(R.id.input_phone_profile_update);
        input_email_profile_update = view.findViewById(R.id.input_email_profile_update);
        // If click button update user
        update_profile_button = view.findViewById(R.id.update_profile_button);
        update_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_username_profile_update.getText().toString().equals("")
                        || input_password_profile_update.getText().toString().equals("")
                        || input_password2_profile_update.getText().toString().equals("")
                        || input_name_profile_update.getText().toString().equals("")
                        ||  input_surname_profile_update.getText().toString().equals("")
                        || input_phone_profile_update.getText().toString().equals("")
                        || input_email_profile_update.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else if(!input_username_profile_update.getText().toString().equals(ProMainActivity.user_username))
                {
                    // Show message Different username.
                    Toast.makeText(getActivity(), "Your Username is different!", Toast.LENGTH_SHORT).show();
                }
                else if(!input_password_profile_update.getText().toString().equals(input_password2_profile_update.getText().toString()))
                {
                    // Show message 2 password is not same.
                    Toast.makeText(getActivity(), "Passwords is not same!", Toast.LENGTH_SHORT).show();
                    input_password_profile_update.setText("");
                    input_password2_profile_update.setText("");
                }
                else
                {
                    // Get all texts from textfields
                    String var_user_username = input_username_profile_update.getText().toString();
                    String var_user_password = input_password_profile_update.getText().toString();
                    String var_user_name = input_name_profile_update.getText().toString();
                    String var_user_surname = input_surname_profile_update.getText().toString();
                    String var_user_phone = input_phone_profile_update.getText().toString();
                    String var_user_email = input_email_profile_update.getText().toString();

                    User user = new User();
                    user.setUser_username(var_user_username);
                    user.setUser_password(var_user_password);
                    user.setUser_name(var_user_name);
                    user.setUser_surname(var_user_surname);
                    user.setUser_phone(var_user_phone);
                    user.setUser_email(var_user_email);
                    user.setUser_type("Customer"); // No Need

                    // Call method updateUser for update user in database
                    ProMainActivity.eStingyDatabase.eStingyDao().updateUser(user);
                    // Show message User Updated
                    Toast.makeText(getActivity(), "User Updated!", Toast.LENGTH_SHORT).show();

                    // Clean fields
                    input_username_profile_update.setText("");
                    input_password_profile_update.setText("");
                    input_password2_profile_update.setText("");
                    input_name_profile_update.setText("");
                    input_surname_profile_update.setText("");
                    input_phone_profile_update.setText("");
                    input_email_profile_update.setText("");
                }
            }
        });

        return view;
    }

}
