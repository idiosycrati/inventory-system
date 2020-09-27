package com.erovoutika.systems.DAO;

import java.security.Principal;
import java.util.List;

import com.erovoutika.systems.entities.CartEntity;
import com.erovoutika.systems.entities.PostEntity;
import com.erovoutika.systems.entities.ScheduleEntity;
import com.erovoutika.systems.entities.TheCart;
import com.erovoutika.systems.entities.products;
import com.erovoutika.systems.entities.userModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

/**
 * loginInterface
 */
public interface SystemDAO  {

    // Users DAO's
    public void saveUser(userModel user);
    public boolean isUserExist(userModel user);
    public userModel findUserByEmail(String email);


    // Product DAO's
    public void saveProduct(MultipartFile imageFile, products product) throws Exception ;
    public List<products> findAllProducts();
    public products findProductById(int theId);
    public void productDeleteById(int theId);

    // Cart DAO's
    public void updateCart(String email,int id,int quantity);
    public List<TheCart> cartList(String email);
    public void order(int quantity,int productId, String email);
    public void cOrder(Principal pr);
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