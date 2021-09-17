package com.example.ecommerce.repository;

import com.example.ecommerce.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface VilleRepository extends JpaRepository<Ville, Integer> {
}
