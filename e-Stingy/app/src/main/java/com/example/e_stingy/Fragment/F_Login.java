package com.example.e_stingy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.MainActivity;
import com.example.e_stingy.Activity.MainActivity_2;
import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.User;
import com.example.e_stingy.R;

public class F_Login extends Fragment {
    EditText input_username_user, input_password_user;
    Button login_button, signin_button_2;

    public F_Login(){
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_login, container, false);
        input_username_user = view.findViewById(R.id.input_username_user);
        input_password_user = view.findViewById(R.id.input_password_user);
        signin_button_2 = view.findViewById(R.id.signin_button_2);
        // If click button add_user
        login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_username_user.getText().toString().equals("")
                        || input_password_user.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try {
                        // Get all texts from textfields
                        String var_user_username = input_username_user.getText().toString();
                        String var_user_password = input_username_user.getText().toString();

                        // Create temp user for login
                        User user = ProMainActivity.eStingyDatabase.eStingyDao().getUser(var_user_username,var_user_password);

                       ProMainActivity.user_username = user.getUser_username();

                       // Open activity with type
                        if (user.getUser_type().equals("Customer")) {
                            Intent i = new Intent(getActivity(), MainActivity_2.class);
                            startActivity(i);
                        } else if (user.getUser_type().equals("Admin")) {
                            Intent i = new Intent(getActivity(), MainActivity.class);
                            startActivity(i);
                        }
                        // Show message Login...
                        Toast.makeText(getActivity(), "Login...", Toast.LENGTH_SHORT).show();

                    }
                    catch (NullPointerException ex)
                    {
                        // Show message Username or Password is wrong!
                        Toast.makeText(getActivity(), "Username or Password is wrong!", Toast.LENGTH_SHORT).show();
                        input_username_user.setText("");
                        input_password_user.setText("");
                    }
                }
            }
        });

        signin_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProMainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_pro_main, new F_Insert_User()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
