package com.example.ecommerce.service;

import com.example.ecommerce.model.Pays;
import com.example.ecommerce.model.Ville;

import java.util.List;
import java.util.Optional;

public interface VilleService {
    public List<Ville> getVille(int id);

    public Ville addVille(Ville ville);

    public Optional<Ville> show(int id);

    public Ville checkIfNull(Ville ville);

//    public void deleteville(int i);
}
