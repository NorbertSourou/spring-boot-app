package com.example.ecommerce.service;

import com.example.ecommerce.model.Pays;

import java.util.List;
import java.util.Optional;


public interface PaysService {
    public List<Pays> getPays();

    public Pays addPays(Pays pays);

    public Optional<Pays> show(int id);

    public Pays checkIfNull(Pays pays);

    public void deletepays(int i);
}
