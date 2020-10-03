package com.erovoutika.systems.DAO;

import java.security.Principal;
import java.util.List;

import com.erovoutika.systems.entities.CartEntity;
import com.erovoutika.systems.entities.PostEntity;
import com.erovoutika.systems.entities.Products;
import com.erovoutika.systems.entities.ScheduleEntity;
// import com.erovoutika.systems.entities.TheCart;
// import com.erovoutika.systems.entities.products;
import com.erovoutika.systems.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

/**
 * loginInterface
 */
public interface SystemDAO  {

    // Users DAO's
    public void saveUser(UserEntity user);
    public boolean isUserExist(UserEntity user);
    public UserEntity findUserByEmail(String email);


    // Product DAO's
    public void saveProduct(MultipartFile imageFile, Products product) throws Exception ;
    public List<Products> findAllProducts();
    public Products findProductById(int theId);
    public void productDeleteById(int theId);

    // Cart DAO's
    public void addToCart(String email,int id,int quantity);
    public List<CartEntity> cartList(String email);
    public void order(int quantity,int productId, String email);
    public void cartCustomerOrder(Principal pr);
    public boolean existInCart(int productId);
    public CartEntity fetchCart(int productId);

    // Schedule DAO's
    public void addSchedule(ScheduleEntity theSchedule);

    // Post DAO's
    public void savePost(MultipartFile imageFile, PostEntity post)throws Exception;
    public void archivePost(int postId);
    public List<PostEntity> findAllPost();
    public PostEntity findPostbyId(int Id);


}