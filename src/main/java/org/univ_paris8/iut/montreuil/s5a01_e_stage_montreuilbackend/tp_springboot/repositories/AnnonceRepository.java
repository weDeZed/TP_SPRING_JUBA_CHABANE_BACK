package org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot.entities.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
