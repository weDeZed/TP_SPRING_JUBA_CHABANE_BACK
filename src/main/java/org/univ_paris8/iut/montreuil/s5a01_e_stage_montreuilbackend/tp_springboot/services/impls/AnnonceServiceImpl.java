package org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.entities.Annonce;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.repositories.AnnonceRepository;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.services.interfaces.AnnonceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServiceImpl implements AnnonceService {


    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        annonce.setDate(LocalDateTime.now());
        return annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Optional<Annonce> getAnnonceById(Long id) {
        return annonceRepository.findById(id);
    }

    @Override
    public Annonce updateAnnonce(Long id, Annonce annonce) {
        return annonceRepository.findById(id)
                .map(existingAnnonce -> {
                    existingAnnonce.setTitle(annonce.getTitle());
                    existingAnnonce.setDescription(annonce.getDescription());
                    existingAnnonce.setAdress(annonce.getAdress());
                    existingAnnonce.setMail(annonce.getMail());
                    existingAnnonce.setDate(LocalDateTime.now());
                    return annonceRepository.save(existingAnnonce);
                }).orElseThrow(() -> new RuntimeException("Annonce pas trouvée " + id));
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}

