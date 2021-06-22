package com.sivaone.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable String id) {
    return ResponseEntity.ok(new Product(id, "iPhone", 699.0d, true));
  }
}
