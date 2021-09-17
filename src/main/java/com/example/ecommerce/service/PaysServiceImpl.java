package com.example.ecommerce.service;

import com.example.ecommerce.model.Pays;
import com.example.ecommerce.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    private PaysRepository paysRepository;

    @Override
    public List<Pays> getPays() {
        return paysRepository.findAll();
    }

    @Override
    public Pays addPays(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public Optional<Pays> show(int id) {
        return paysRepository.findById(id);
    }

    @Override
    public Pays checkIfNull(Pays pays) {
        if (pays.getCode().isBlank() || pays.getNom().isBlank()) {
            return null;
        } else {
            return pays;
        }

    }

    @Override
    public void deletepays(int id) {
        Optional<Pays> deletePays = paysRepository.findById(id);
        paysRepository.delete(deletePays.get());
    }
}
