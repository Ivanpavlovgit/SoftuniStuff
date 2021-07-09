package com.example.shamp;

import com.example.shamp.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShampooRepository  extends JpaRepository<Shampoo,Long> {

}
