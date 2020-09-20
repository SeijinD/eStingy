package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.ProMainActivity;
import com.example.e_stingy.Activity.ProfileActivity;
import com.example.e_stingy.Activity.UsersActivity;
import com.example.e_stingy.Class.User;
import com.example.e_stingy.Fragment.F_Delete_Profile;
import com.example.e_stingy.Fragment.F_Delete_User;
import com.example.e_stingy.Fragment.F_Insert_User;
import com.example.e_stingy.Fragment.F_Login;
import com.example.e_stingy.Fragment.F_Update_Profile;
import com.example.e_stingy.Fragment.F_Update_User;
import com.example.e_stingy.R;

public class F_Room_Profile extends Fragment implements View.OnClickListener{
    Button update_profile_button, delete_profile_button;
    TextView view_username_user, view_name_user, view_surname_user, view_phone_user, view_email_user, view_type_user;

    public F_Room_Profile() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_profile, container,false);

        view_username_user = view.findViewById(R.id.view_username_user);
        view_name_user = view.findViewById(R.id.view_name_user);
        view_surname_user = view.findViewById(R.id.view_surname_user);
        view_phone_user = view.findViewById(R.id.view_phone_user);
        view_email_user = view.findViewById(R.id.view_email_user);
        view_type_user = view.findViewById(R.id.view_type_user);

        // Update User
        update_profile_button = view.findViewById(R.id.update_profile_button);
        update_profile_button.setOnClickListener(this);

        // Delete User
        delete_profile_button = view.findViewById(R.id.delete_profile_button);
        delete_profile_button.setOnClickListener(this);

        // Get User with Username
        User user = ProMainActivity.eStingyDatabase.eStingyDao().getUserWithUsername(ProMainActivity.user_username);

        // View Profile Data
        view_username_user.setText("Username: "+user.getUser_username());
        view_name_user.setText("Name: "+user.getUser_name());
        view_surname_user.setText("Surname: "+user.getUser_surname());
        view_phone_user.setText("Phone: "+user.getUser_phone());
        view_email_user.setText("Email: "+user.getUser_email());
        view_type_user.setText("Type: "+user.getUser_type());

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.update_profile_button:
                ProfileActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_profile, new F_Update_Profile()).addToBackStack(null).commit();
                break;
            case R.id.delete_profile_button:
                ProfileActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_profile, new F_Delete_Profile()).addToBackStack(null).commit();
                break;
        }
    }
}
