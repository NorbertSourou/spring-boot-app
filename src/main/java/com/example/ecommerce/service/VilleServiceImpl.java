package com.example.ecommerce.service;

import com.example.ecommerce.model.Ville;
import com.example.ecommerce.repository.PaysRepository;
import com.example.ecommerce.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleServiceImpl implements VilleService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private PaysService paysService;

    @Override
    public List<Ville> getVille(int id) {
        return paysService.show(id).get().getVilles();
    }

    @Override
    public Ville addVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public Optional<Ville> show(int id) {
        return Optional.empty();
    }

    @Override
    public Ville checkIfNull(Ville ville) {
        return null;
    }

//    @Override
//    public void deleteville(int i) {
//
//    }
}
