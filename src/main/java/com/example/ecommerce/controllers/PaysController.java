package com.example.ecommerce.controllers;

import com.example.ecommerce.exception.domain.UserNotFoundException;
import com.example.ecommerce.model.ExceptionResponse;
import com.example.ecommerce.model.Pays;
import com.example.ecommerce.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")

public class PaysController {
    @Autowired
    private PaysService paysService;

    @GetMapping("/pays")
    public List<Pays> paysList() {
        return paysService.getPays();
    }

    @PostMapping("/pays")
    public ResponseEntity<Object> addPays(@RequestBody Pays pays) throws Exception {
        if (paysService.checkIfNull(pays) == null) {
            throw new Exception("Tous les champs sont requis");
        } else {
            Pays savedPays = paysService.addPays(pays);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedPays.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PostMapping("/pays/{id}")
    public ResponseEntity updatePays(@PathVariable int id, @RequestBody Pays pays) throws Exception {
        Optional<Pays> update = paysService.show(id);
        if (paysService.show(id).isEmpty()) {
            throw new UserNotFoundException("Ce pays n'existe pas");
        }
        update.get().setCode(pays.getCode());
        update.get().setNom(pays.getNom());
        paysService.addPays(update.get());
        return new ResponseEntity(new ExceptionResponse(new Date(), "Modification avec succès"), HttpStatus.OK);
    }

    @GetMapping("/pays/{id}")
    public Optional<Pays> updatePays(@PathVariable int id) {
        if (paysService.show(id).isEmpty()) {
            throw new UserNotFoundException("Ce pays n'existe pas");
        }
        return paysService.show(id);
    }

    @DeleteMapping("/pays/{id}")
    public ResponseEntity deletePays(@PathVariable int id) {
        if (paysService.show(id).isEmpty()) {
            throw new UserNotFoundException("Ce pays n'existe pas");
        }
        paysService.deletepays(id);
        return new ResponseEntity(new ExceptionResponse(new Date(), "Suppression effectué avec succès"), HttpStatus.OK);
    }
}
