package com.example.e_stingy;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.e_stingy.Class.Cart;
import com.example.e_stingy.Class.Product;
import com.example.e_stingy.Class.Sale;
import com.example.e_stingy.Class.User;

import java.util.List;

// Create Dao and write all methods
@Dao
public interface eStingyDao {

    // For Check SignIn
    @Query("SELECT * FROM users WHERE user_username = :username")
    public User checkExistUser(String username);

    // For Check Login
    @Query("SELECT * FROM users WHERE user_username = :username AND user_password = :password")
    public User getUser(String username, String password);

    // Get User with username
    @Query("SELECT * FROM users WHERE user_username = :username")
    public User getUserWithUsername(String username);

    // Get sales per product.
    @Query("SELECT * FROM sales WHERE p_id = :p_id")
    public List<Sale> getSalesPerProduct(int p_id);

    // Get all sales per user.
    @Query("SELECT * FROM sales WHERE u_username = :username")
    public List<Sale> getSalesPerUser(String username);

    // Get Cart
    @Query("SELECT * FROM carts WHERE u_username = :username AND p_id = :product_id")
    public Cart getCart(String username, int product_id);

    // Get all carts per user.
    @Query("SELECT * FROM carts WHERE u_username = :username")
    public List<Cart> getCartsPerUser(String username);

    // Get all products id.
    @Query("SELECT product_id FROM products")
    public List<Integer> getAllProductsId();

    // Get Product by id.
    @Query("SELECT * FROM products WHERE product_id = :code")
    public Product getProductById(int code);

    // Get Products by category.
    @Query("SELECT * FROM products WHERE product_category = :product_category")
    public List<Product> getAllProductsByCategory(String product_category);

    // If I need..
    // Delete all users
//    @Query("delete from users")
//    public void deleteAllUsers();

    // Delete all products
//    @Query("delete from products")
//    public void deleteAllProducts();

    // Get all users
    @Query("select * from users")
    public List<User> getUsers();

    // Get all products
    @Query("select * from products")
    public List<Product> getProducts();

    // Get all sales
    @Query("select * from sales")
    public List<Sale> getSales();

    // Get all carts
    @Query("select * from carts")
    public List<Cart> getCarts();

    // Insert/Update/Delete User
    @Insert
    public void addUser(User user);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);

    // Insert/Update/Delete Product
    @Insert
    public void addProduct(Product product);

    @Update
    public void updateProduct(Product product);

    @Delete
    public void deleteProduct(Product product);

    // Insert/Update/Delete Sale
    @Insert
    public void addSale(Sale sale);

    @Update
    public void updateSale(Sale sale);

    @Delete
    public void deleteSale(Sale sale);

    // Insert/Update/Delete Cart
    @Insert
    public void addCart(Cart cart);

    @Update
    public void updateCart(Cart cart);

    @Delete
    public void deleteCart(Cart cart);
}
