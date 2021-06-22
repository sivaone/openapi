package com.sivaone.openapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

  private String id;
  private String name;
  private Double price;
  private boolean available;
}
