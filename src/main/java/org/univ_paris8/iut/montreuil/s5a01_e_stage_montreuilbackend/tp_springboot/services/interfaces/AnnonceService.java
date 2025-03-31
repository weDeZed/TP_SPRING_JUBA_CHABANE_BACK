package org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.services.interfaces;


import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.entities.Annonce;

import java.util.List;
import java.util.Optional;

public interface AnnonceService {
    Annonce saveAnnonce(Annonce annonce);
    List<Annonce> getAllAnnonces();
    Optional<Annonce> getAnnonceById(Long id);
    Annonce updateAnnonce(Long id, Annonce annonce);
    void deleteAnnonce(Long id);
}

