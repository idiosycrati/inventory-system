package com.erovoutika.systems.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import com.erovoutika.systems.DAO.SystemDAO;
import com.erovoutika.systems.DAO.imageDAO;
import com.erovoutika.systems.entities.CartEntity;
import com.erovoutika.systems.entities.ImageEntity;
import com.erovoutika.systems.entities.PostEntity;
import com.erovoutika.systems.entities.ScheduleEntity;
import com.erovoutika.systems.entities.TheCart;
import com.erovoutika.systems.entities.products;
import com.erovoutika.systems.entities.userModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * regServiceImplementation
 */
@Service
public class SystemServiceImplementation implements SystemDAO {

    private SystemDAO systemDAO;

    @Autowired
    public SystemServiceImplementation(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;

    }

    @Override
    public void saveUser(userModel user) {
        // TODO Auto-generated method stub
        systemDAO.saveUser(user);

    }

    @Override
    public void saveProduct(MultipartFile imageFile, products product) {
        try {
            systemDAO.saveProduct(imageFile, product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public boolean isUserExist(userModel user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<products> findAllProducts() {
        // TODO Auto-generated method stub
        return systemDAO.findAllProducts();
    }

    @Override
    public void productDeleteById(int theId) {
        // TODO Auto-generated method stub
        systemDAO.productDeleteById(theId);
    }

    @Override
    public products findProductById(int theId) {
        // TODO Auto-generated method stub
        return systemDAO.findProductById(theId);
        
    }

    @Override
    public userModel findUserByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addToCart(String email, int id,int quantity) {
        // TODO Auto-generated method stub
        systemDAO.addToCart(email, id,quantity);
    }

    @Override
    public List<CartEntity> cartList(String email) {
        // TODO Auto-generated method stub
        return systemDAO.cartList(email);
    }

    @Override
    public void order(int quantity, int productId, String email) {
        // TODO Auto-generated method stub
        systemDAO.order(quantity, productId, email);
    }

    @Override
    public void cOrder(Principal pr) {
        // TODO Auto-generated method stub
        systemDAO.cOrder(pr);
    }

    @Override
    public void addSchedule(ScheduleEntity theSchedule) {
        systemDAO.addSchedule(theSchedule);

    }

    @Override
    public void savePost(MultipartFile imageFile, PostEntity post) throws Exception {
        systemDAO.savePost(imageFile, post);
    }

    @Override
    public boolean existInCart(int productId) {
        // TODO Auto-generated method stub
        systemDAO.existInCart(productId);
        return false;
    }

    @Override
    public CartEntity fetchCart(int productId) {
        // TODO Auto-generated method stub
        systemDAO.fetchCart(productId);
        return null;
    }

    @Override
    public void archivePost(int postId) {
        systemDAO.archivePost(postId);

    }

    @Override
    public List<PostEntity> findAllPost() {
       return systemDAO.findAllPost();
    }

    @Override
    public PostEntity findPostbyId(int Id) {
        return systemDAO.findPostbyId(Id);
    }


}