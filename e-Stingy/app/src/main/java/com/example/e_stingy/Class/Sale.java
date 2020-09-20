package com.example.e_stingy.Class;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "sales",
        foreignKeys = {
                @ForeignKey(entity = User.class, parentColumns = "user_username",
                        childColumns = "u_username",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = Product.class, parentColumns = "product_id",
                        childColumns = "p_id",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        },
        indices = {@Index("u_username"), @Index("p_id")})
public class Sale {

    // @Primary Key for Id
    // @NonNull = Not Null Value
    // ColumnInfo(name) = call variable with this name
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @NonNull
    private String u_username;
    @NonNull
    private int p_id;
    @NonNull
    private int quantity;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getU_username() {
        return u_username;
    }

    public void setU_username(@NonNull String u_username) {
        this.u_username = u_username;
    }

    @NonNull
    public int getP_id() {
        return p_id;
    }

    public void setP_id(@NonNull int p_id) {
        this.p_id = p_id;
    }

    @NonNull
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull int quantity) {
        this.quantity = quantity;
    }
}
