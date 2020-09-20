package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.UsersActivity;
import com.example.e_stingy.Fragment.F_Delete_User;
import com.example.e_stingy.Fragment.F_Insert_User;
import com.example.e_stingy.Fragment.F_Update_User;
import com.example.e_stingy.R;

public class F_Room_Users extends Fragment implements View.OnClickListener{
    Button add_user_button, update_user_button, delete_user_button;

    public F_Room_Users() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_users, container,false);

        // Add User
        add_user_button = view.findViewById(R.id.add_user_button);
        add_user_button.setOnClickListener(this);

        // Update User
        update_user_button = view.findViewById(R.id.update_user_button);
        update_user_button.setOnClickListener(this);

        // Delete User
        delete_user_button = view.findViewById(R.id.delete_user_button);
        delete_user_button.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_user_button:
                UsersActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_users, new F_Insert_User()).addToBackStack(null).commit();
                break;
            case R.id.update_user_button:
                UsersActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_users, new F_Update_User()).addToBackStack(null).commit();
                break;
            case R.id.delete_user_button:
                UsersActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_users, new F_Delete_User()).addToBackStack(null).commit();
                break;
        }
    }
}
