package org.sid.projetgrh;

import org.sid.projetgrh.dao.*;
import org.sid.projetgrh.entities.Role;
import org.sid.projetgrh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication

public class ProjetGrhApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(ProjetGrhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findByRole("USER")==null) {
            Role r = new Role();
            r.setRole("USER");
            roleRepository.save(r);
        }
        if (roleRepository.findByRole("ADMIN")==null) {
            Role r = new Role();
            r.setRole("ADMIN");
            roleRepository.save(r);
        }

        if (employeRepository.findByUsername("admin")==null) {
            accountService.saveUser(Employe.builder().nom("admin").username("admin").password("admin").etat(1).build());
        }
        //displine
        restConfiguration.exposeIdsFor(Displine.class);

        // DisplineRepository.save(new Displine(1,"test","test",new Date(),"test","test", null));
        // DisplineRepository.save(new Displine(2,"test1","test2",new Date(),"test3","test4", null));
        //DisplineRepository.findAll().forEach(d->{System.out.println((d.toString()));});

        //partie employe

        restConfiguration.exposeIdsFor(Employe.class);

        List<Displine> displines = null;
        List<Conges> conges = null;
        Licenciement licenciement = null;
        List<Contrats> contrats = null;
        Departement departement = null;
        List<Fonction> fonctions = null;

    /*  EmployeRepository.save(
              Employe.builder()
                      .nom("fatma")
                      .email("fatmamedcheikh@gmail.com")
                      .displines(displines)
                      .conges(conges)
                      .licenciement(licenciement)
                      .departement(departement)
                      .fonctions(fonctions)
                      .build());
      EmployeRepository.save(
              Employe.builder()
                      .nom("amy")
                      .email("amy@gmail.com")
                      .displines(displines)
                      .conges(conges)
                      .licenciement(licenciement)
                      .departement(departement)
                      .fonctions(fonctions)
                      .build());
        EmployeRepository.findAll().forEach(p->{System.out.println((p.toString()));});*/

        //Fonction


        restConfiguration.exposeIdsFor(Fonction.class);

        //FonctionRepository.save(new Fonction(1,"dir finacier","finance",null,null,null));
        //FonctionRepository.findAll().forEach(f->{System.out.println((f.toString()));});

//Profession
        restConfiguration.exposeIdsFor(Profession.class);

        //ProfessionRepository.save(new Profession(1,"grh",null,null));
        //ProfessionRepository.save(new Profession(2,"IT manager",null,null));
        //ProfessionRepository.findAll().forEach(r->{System.out.println((r.toString()));});

//type departement
        restConfiguration.exposeIdsFor(Type_departement.class);

        //TypeDepartement_Repository.save(new Type_departement(1,"Direction informatique"));
        //TypeDepartement_Repository.save(new Type_departement(2,"Direction gestion de RH"));
        // TypeDepartement_Repository.findAll().forEach(t->{System.out.println((t.toString()));});


//type contrat
        restConfiguration.exposeIdsFor(Type_contrat.class);

        //typeContrat_Repository.save(new Type_contrat(1,123,"contra1"));
        // typeContrat_Repository.save(new Type_contrat(2,124,"contra2"));
        //typeContrat_Repository.save(new Type_contrat(3,125,"contra3"));
        //typeContrat_Repository.findAll().forEach(c->{System.out.println((c.toString()));});

//ITS
        restConfiguration.exposeIdsFor(ITS.class);

        //ItsRepository.save(new ITS(1,25,2,5,200000,9000));
        //ItsRepository.save(new ITS(2,3,5,10,900000,5000));
        //ItsRepository.findAll().forEach(i->{System.out.println((i.toString()));});

//cnam

        restConfiguration.exposeIdsFor(CNAM.class);

        //CnamRepository.save(new CNAM(1,Float.parseFloat("0.04"), 0.0));
        //CnamRepository.findAll().forEach(n->{System.out.println((n.toString()));});


//cnss

        restConfiguration.exposeIdsFor(CNSS.class);

        //CnssRepository.save(new CNSS(1,Float.parseFloat("0.01"),7000));
        //CnssRepository.findAll().forEach(s->{System.out.println((s.toString()));});


//anciennete

        restConfiguration.exposeIdsFor(org.sid.projetgrh.Anciennete.class);

        //AncienneteRepository.save(new Anciennete(1,5,2,5,150000));
        //AncienneteRepository.save(new Anciennete(2,10,5,10,190000));
        //AncienneteRepository.findAll().forEach(s->{System.out.println((s.toString()));});


//conges

        restConfiguration.exposeIdsFor(Conges.class);

        //CongesRepository.save(new Conges(1,30,null,"conges maternites", null));
        //CongesRepository.save(new Conges(2,30,null,"conges annuelles", null));
        //CongesRepository.findAll().forEach(s->{System.out.println((s.toString()));});


        //licenciemnet
        restConfiguration.exposeIdsFor(Licenciement.class);
        //   licenciementRepository.save(new licenciement(1,null,"avertissement", null));
        // licenciementRepository.save(new licenciement(2,null,"mise a pied", null));
        //licenciementRepository.findAll().forEach(s->{System.out.println((s.toString()));});


        //Contrats
        restConfiguration.exposeIdsFor(Contrats.class);
        //  ContratsRepository.save(new Contrats(1,null,"par caisse",2120000, null, null));
        //ContratsRepository.save(new Contrats(2,null,"par cheque",3120000, null, null));
        //ContratsRepository.findAll().forEach(s->{System.out.println((s.toString()));});


//departement


        restConfiguration.exposeIdsFor(Departement.class);
/*        derpartementRepository.save(new Departement(1,"informatique", null, null, null, null));
        derpartementRepository.save(new Departement(2,"finance", null, null, null, null));
        derpartementRepository.findAll().forEach(s->{System.out.println((s.toString()));});*/

//pointage
        restConfiguration.exposeIdsFor(Pointage.class);
        long l = 1;

     /*  PointgeRepository.save(new Pointage(2,null,Timestamp.valueOf("2020-10-10 08:20:00.123456789"),Timestamp.valueOf("2020-10-10 16:20:00.123456789"),"absence","justifie",7,20, 80, e));
       PointgeRepository.findAll().forEach(s->{System.out.println((s.toString()));});

*/


    }


}
