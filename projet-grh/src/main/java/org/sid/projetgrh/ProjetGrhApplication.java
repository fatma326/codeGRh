package org.sid.projetgrh;

import org.sid.projetgrh.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProjetGrhApplication implements CommandLineRunner {
  @Autowired
    private EmployeRepository EmployeRepository;


@Autowired
  private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(ProjetGrhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Employe.class);
        EmployeRepository.save(new Employe(1,
                        "fatma",
                        "amara",
                        "tvz",
                        46575657,
                        1,
                        "IT",
                        "m",
                        "fatmamedcheikh@gmail.com",
                        "femelle",
                        19090,
                        23555));

        EmployeRepository.save(new Employe(2,
                "amy",
                "zein",
                "tvz",
                32555657,
                1,
                "IT",
                "m",
                "amy@gmail.com",
                "femelle",
                233090,
                23577755));

        EmployeRepository.save(new Employe(3,
                "ghlane",
                "amara",
                "tvz",
                32888857,
                1,
                "grh",
                "m",
                "ghlane@gmail.com",
                "femelle",
                2388090,
                88877755));








        EmployeRepository.findAll().forEach(p->{System.out.println((p.toString()));});
    }
}
