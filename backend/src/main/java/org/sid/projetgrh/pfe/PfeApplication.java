package org.sid.projetgrh.pfe;

import org.sid.projetgrh.pfe.entities.Employe;
import org.sid.projetgrh.pfe.entities.Pointage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class PfeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PfeApplication.class, args);
    }

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Employe.class,Pointage.class);

    }




}


