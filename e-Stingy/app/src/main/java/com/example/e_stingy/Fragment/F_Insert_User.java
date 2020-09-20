package com.example.e_stingy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.MainActivity;
import com.example.e_stingy.Activity.MainActivity_2;
import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.User;
import com.example.e_stingy.R;

public class F_Insert_User extends Fragment {
    EditText input_username_user, input_password_user, input_password2_user, input_name_user, input_surname_user, input_phone_user, input_email_user;
    Button submit_user_button;
    RadioButton type_selected;
    RadioGroup type_group;

    public F_Insert_User(){
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.f_insert_user, container, false);
        input_username_user = view.findViewById(R.id.input_username_user);
        input_password_user = view.findViewById(R.id.input_password_user);
        input_password2_user = view.findViewById(R.id.input_password2_user);
        input_name_user = view.findViewById(R.id.input_name_user);
        input_surname_user = view.findViewById(R.id.input_surname_user);
        input_phone_user = view.findViewById(R.id.input_phone_user);
        input_email_user = view.findViewById(R.id.input_email_user);
        type_group = view.findViewById(R.id.type_group);

        submit_user_button = view.findViewById(R.id.submit_user_button);
        // If click button add_user
        submit_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_username_user.getText().toString().equals("")
                        || input_password_user.getText().toString().equals("")
                        || input_password2_user.getText().toString().equals("")
                        || input_name_user.getText().toString().equals("")
                        ||  input_surname_user.getText().toString().equals("")
                        || input_phone_user.getText().toString().equals("")
                        || input_email_user.getText().toString().equals(""))
                {
                    // Show message Fill all fields.
                    Toast.makeText(getActivity(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
                else if(ProMainActivity.eStingyDatabase.eStingyDao().checkExistUser(input_username_user.getText().toString()) != null)
                {
                    // Show username exist already!.
                    Toast.makeText(getActivity(), "Username exist already!", Toast.LENGTH_SHORT).show();
                    input_username_user.setText("");
                    System.out.println("ok");
                }
                else if(!input_password_user.getText().toString().equals(input_password2_user.getText().toString()))
                {
                    // Show message 2 password is not same.
                    Toast.makeText(getActivity(), "Passwords is not same!", Toast.LENGTH_SHORT).show();
                    input_password_user.setText("");
                    input_password2_user.setText("");
                }
                else
                {
                    // Get Selected radio button
                    int selectedId=type_group.getCheckedRadioButtonId();
                    type_selected=(RadioButton) view.findViewById(selectedId);
                    String var_user_type = type_selected.getText().toString();

                    // Get all texts from textfields
                    String var_user_username = input_username_user.getText().toString();
                    String var_user_password = input_username_user.getText().toString();
                    String var_user_name = input_name_user.getText().toString();
                    String var_user_surname = input_surname_user.getText().toString();
                    String var_user_phone = input_phone_user.getText().toString();
                    String var_user_email = input_email_user.getText().toString();

                    User user = new User();
                    user.setUser_username(var_user_username);
                    user.setUser_password(var_user_password);
                    user.setUser_name(var_user_name);
                    user.setUser_surname(var_user_surname);
                    user.setUser_phone(var_user_phone);
                    user.setUser_email(var_user_email);
                    user.setUser_type(var_user_type);

                    // Call method addUser for add user in database
                    ProMainActivity.eStingyDatabase.eStingyDao().addUser(user);
                    // Show message User Added
                    Toast.makeText(getActivity(), "User Added!", Toast.LENGTH_SHORT).show();

                    ProMainActivity.user_username = user.getUser_username();

                    // Open activity with type
                    if (user.getUser_type().equals("Customer")) {
                        Intent i = new Intent(getActivity(), MainActivity_2.class);
                        startActivity(i);
                    } else if (user.getUser_type().equals("Admin")) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                    }

                    // Clean fields
//                    input_username_user.setText("");
//                    input_password_user.setText("");
//                    input_password2_user.setText("");
//                    input_name_user.setText("");
//                    input_surname_user.setText("");
//                    input_phone_user.setText("");
//                    input_email_user.setText("");
//                    onClear(v);
                }
            }
        });
        return view;
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        type_group.clearCheck();
    }
}
