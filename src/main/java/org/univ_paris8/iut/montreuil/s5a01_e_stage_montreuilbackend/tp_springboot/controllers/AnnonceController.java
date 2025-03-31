package org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.entities.Annonce;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.services.interfaces.AnnonceService;

import java.util.List;

@RestController
@RequestMapping("annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    // Créer une annonce
    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce savedAnnonce = annonceService.saveAnnonce(annonce);
        return ResponseEntity.ok(savedAnnonce);
    }

    // Récupérer toutes les annonces
    @GetMapping
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        List<Annonce> annonces = annonceService.getAllAnnonces();
        return ResponseEntity.ok(annonces);
    }

    // Récupérer une annonce par son id
    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id) {
        return annonceService.getAnnonceById(id)
                .map(ResponseEntity::ok)

                .orElse(ResponseEntity.notFound().build());
    }

    // Mettre à jour une annonce
    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonce) {
        Annonce updatedAnnonce = annonceService.updateAnnonce(id, annonce);
        return ResponseEntity.ok(updatedAnnonce);
    }

    // Supprimer une annonce
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }

}
