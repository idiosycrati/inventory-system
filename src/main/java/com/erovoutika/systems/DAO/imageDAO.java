package com.erovoutika.systems.DAO;

import com.erovoutika.systems.entities.ImageEntity;
import com.erovoutika.systems.entities.products;

import org.springframework.web.multipart.MultipartFile;

/**
 * imageDAO
 */
public interface imageDAO {
    void saveImage(MultipartFile imageFile, products product) throws Exception;
}