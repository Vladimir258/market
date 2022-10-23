package ru.geekbrains.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.market.entities.Product;
import ru.geekbrains.spring.market.exceptions.AppError;
import ru.geekbrains.spring.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.market.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<?> findProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.findById(id);
//        if(!product.isPresent()) {
//            ResponseEntity<AppError> err = new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "Продукт не найден, id:" + id), HttpStatus.NOT_FOUND);
//            return err;
//        }
//        return new ResponseEntity<>(product.get(), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> exceptionHandler(ResourceNotFoundException e) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
