package com.example.api.controller;

import com.example.api.model.Image;
import com.example.api.model.Product;
import com.example.api.repository.ImageRepository;
import com.example.api.repository.ProductRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public Iterable<Product> getProducts (){
       return productRepository.findAll();
    }
    @GetMapping("/images")
    public Iterable<Image> getImages (){
        return imageRepository.findAll();
    }
    @GetMapping("/images/{id}")
    public Optional<Image> getImage (@PathVariable("id")Long id){
        return imageRepository.findById(id);
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProduct (@PathVariable("id")Long id){
        return productRepository.findById(id);
    }
    @PutMapping("/products/edit/{id}")
    public Product putImage (@RequestBody Product newProduct,@PathVariable("id")Long id){
        return productRepository.findById(id).map(product ->{
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setImages(newProduct.getImages());
            return productRepository.save(product);



        })
                .orElseGet(()-> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }
    @PutMapping("/products/{id}")
    public Optional<Product> putProduct (@PathVariable("id")Long id){
        return productRepository.findById(id);
    }
    @DeleteMapping("/images/{id}")
    public void deleteImage (@PathVariable("id")Long id){
         imageRepository.deleteById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deletetProduct (@PathVariable("id")Long id){
         productRepository.deleteById(id);
    }

    @PostMapping("products/new")
    Product showAllProduct(@RequestBody Product product){
        return productRepository.save(product);
    }



}
