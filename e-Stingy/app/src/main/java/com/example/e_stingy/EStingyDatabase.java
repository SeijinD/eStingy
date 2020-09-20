package com.example.e_stingy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.Class.User;

// Create Database, add class in database and version
@Database(entities = {User.class, Product.class, Sale.class, Cart.class}, version = 2, exportSchema = false)
public abstract class EStingyDatabase extends RoomDatabase {

    // Add Dao
    public abstract eStingyDao eStingyDao();
}
