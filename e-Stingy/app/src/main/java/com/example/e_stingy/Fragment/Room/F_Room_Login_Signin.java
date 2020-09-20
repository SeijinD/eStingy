package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Fragment.F_Insert_User;
import com.example.e_stingy.Fragment.F_Login;
import com.example.e_stingy.R;

public class F_Room_Login_Signin extends Fragment implements View.OnClickListener{
    Button login_button, signin_button;

    public F_Room_Login_Signin() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_login_signin, container,false);

        // Login
        login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

        // SignIn
        signin_button = view.findViewById(R.id.signin_button);
        signin_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_button:
                ProMainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_pro_main, new F_Login()).addToBackStack(null).commit();
                break;
            case R.id.signin_button:
                ProMainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_pro_main, new F_Insert_User()).addToBackStack(null).commit();
                break;
        }
    }
}
