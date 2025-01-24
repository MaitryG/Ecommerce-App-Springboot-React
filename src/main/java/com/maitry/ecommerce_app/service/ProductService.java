package com.maitry.ecommerce_app.service;

import com.maitry.ecommerce_app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maitry.ecommerce_app.repo.ProductRepo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProduct(int id){
        return repo.findById(id).orElse(null);

    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }
}
