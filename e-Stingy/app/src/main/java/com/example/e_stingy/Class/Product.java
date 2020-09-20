package com.example.e_stingy.Class;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity (tableName = "products")
public class Product {

    // @Primary Key for Id
    // @NonNull = Not Null Value
    // ColumnInfo(name) = call variable with this name
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int product_id;
    @NonNull
    private String product_name;
    @NonNull
    private String product_info;
    @NonNull
    private double product_cost;
    @NonNull
    private int product_quantity;
    @NonNull
    private String product_category;
//    @NonNull
//    private int product_img;


    @NonNull
    public int getProduct_id() { return product_id; }

//    @NonNull
//    public int getProduct_img() { return product_img; }

    @NonNull
    public String getProduct_name() {
        return product_name;
    }

    @NonNull
    public String getProduct_info() {
        return product_info;
    }

    @NonNull
    public double getProduct_cost() {
        return product_cost;
    }

    @NonNull
    public int getProduct_quantity() {
        return product_quantity;
    }

    @NonNull
    public String getProduct_category() { return product_category; }


    public void setProduct_id(@NonNull int product_id) { this.product_id = product_id; }

//    public void setProduct_img(@NonNull int product_img) { this.product_img = product_img; }

    public void setProduct_name(@NonNull String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_info(@NonNull String product_info) {
        this.product_info = product_info;
    }

    public void setProduct_cost(@NonNull double product_cost) {
        this.product_cost = product_cost;
    }

    public void setProduct_quantity(@NonNull int product_quantity) { this.product_quantity = product_quantity; }

    public void setProduct_category(@NonNull String product_category) { this.product_category = product_category; }
}
