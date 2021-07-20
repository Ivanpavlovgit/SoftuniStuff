package com.example.exc_xml.repository;

import com.example.exc_xml.model.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

}
