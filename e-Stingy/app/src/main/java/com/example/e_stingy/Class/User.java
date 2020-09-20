package com.example.e_stingy.Class;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "users")
public class User {

    // @Primary Key for Id
    // @NonNull = Not Null Value
    // ColumnInfo(name) = call variable with this name
    @PrimaryKey
    @NonNull
    private String user_username;
    @NonNull
    private String user_password;
    @NonNull
    private String user_name;
    @NonNull
    private String user_surname;
    @NonNull
    private String user_phone;
    @NonNull
    private String user_email;
    @NonNull
    private String user_type;

    @NonNull
    public String getUser_type() { return user_type; }

    public void setUser_type(@NonNull String user_type) { this.user_type = user_type; }

    @NonNull
    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(@NonNull String user_username) {
        this.user_username = user_username;
    }

    @NonNull
    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(@NonNull String user_password) {
        this.user_password = user_password;
    }

    @NonNull
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(@NonNull String user_name) {
        this.user_name = user_name;
    }

    @NonNull
    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(@NonNull String user_surname) {
        this.user_surname = user_surname;
    }

    @NonNull
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(@NonNull String user_phone) {
        this.user_phone = user_phone;
    }

    @NonNull
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(@NonNull String user_email) {
        this.user_email = user_email;
    }
}
