package com.example.e_stingy.Fragment.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.e_stingy.Activity.InfoActivity;
import com.example.e_stingy.Fragment.F_Info_For_App;
import com.example.e_stingy.Fragment.F_Info_For_Me;
import com.example.e_stingy.R;

public class F_Room_Info extends Fragment implements View.OnClickListener{
    Button info_for_me, info_for_app;

    public F_Room_Info() {
        // Required empty public constructor
    }

    // Method for create view for items in layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.f_room_info, container,false);

        // Info me
        info_for_me = view.findViewById(R.id.info_for_me);
        info_for_me.setOnClickListener(this);

        // Info app
        info_for_app = view.findViewById(R.id.info_for_app);
        info_for_app.setOnClickListener(this);

        return view;
    }

    // Method if click any button
    public void onClick(View v){
        switch (v.getId()){
            case R.id.info_for_me:
                InfoActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_info, new F_Info_For_Me()).addToBackStack(null).commit();
                break;
            case R.id.info_for_app:
                InfoActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container_info, new F_Info_For_App()).addToBackStack(null).commit();
                break;
        }
    }

}
