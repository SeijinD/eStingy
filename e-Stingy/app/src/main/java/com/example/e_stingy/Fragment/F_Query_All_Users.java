package com.example.e_stingy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Class.User;
import com.example.e_stingy.R;

import java.util.List;


public class F_Query_All_Users extends Fragment {
    TextView txt_query_all_users;

    public F_Query_All_Users() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_query_all_users, container, false);

        //
        txt_query_all_users = view.findViewById(R.id.txt_query_all_users);
        List<User> users = ProMainActivity.eStingyDatabase.eStingyDao().getUsers();
        String result = "";
        for (User i: users){
            String username = i.getUser_username();
            String name = i.getUser_name();
            String surname = i.getUser_surname();
            String phone = i.getUser_phone();
            String email = i.getUser_email();
            String type = i.getUser_type();
            result = result + "\n Username: "+username+"\n Name: "+name+"\n Surname: "+surname+"\n Phone: "+phone+"\n Email: "+email+"\n Type: "+type+"\n";
        }
        txt_query_all_users.setText(result);

        return view;
    }
}
