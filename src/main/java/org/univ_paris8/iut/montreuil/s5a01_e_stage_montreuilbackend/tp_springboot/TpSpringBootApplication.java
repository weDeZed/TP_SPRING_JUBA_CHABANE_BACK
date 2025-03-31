package org.univ_paris8.iut.montreuil.s5a01_e_stage_montreuilbackend.tp_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TpSpringBootApplication.class, args);
        System.out.println("juste pour les information j'ai désactive le security de springboot " +
                "\n Le user Name et mot de passe sont dans fichier config.properties" +
                "\n voici le mot de passe et username : tpspringboot");
        System.out.println("Application Démarée");

    }

}
