package com.example.ecommerce.controllers;

import com.example.ecommerce.exception.domain.UserNotFoundException;
import com.example.ecommerce.model.ExceptionResponse;
import com.example.ecommerce.model.Ville;
import com.example.ecommerce.service.PaysService;
import com.example.ecommerce.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class VilleController {
    @Autowired
    private VilleService villeService;
    @Autowired
    private PaysService paysService;

    @PostMapping("/villes/{id}")
    public ResponseEntity<Object> addVilles(@PathVariable int id, @RequestBody Ville ville) throws Exception {
        if (paysService.show(id).isEmpty()) {
            throw new UserNotFoundException("Ce pays n'existe pas. Donc pas de villes");
        }
        ville.setPays(paysService.show(id).get());
        villeService.addVille(ville);
        return new ResponseEntity(new ExceptionResponse(new Date(), "Ville ajoutée avec succès"), HttpStatus.CREATED);
    }

    @GetMapping("/villes/{id}")
    public List<Ville> getVilles(@PathVariable int id) throws Exception {
        if (paysService.show(id).isEmpty()) {
            throw new UserNotFoundException("Ce pays n'existe pas. Donc pas de villes");
        }
        return paysService.show(id).get().getVilles();

    }
}
