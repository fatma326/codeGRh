package org.sid.projetgrh.service;

import org.sid.projetgrh.*;
import org.sid.projetgrh.dao.*;
import org.sid.projetgrh.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class EmployeRestService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private PrimeFixeRep primeFixeRep;
    @Autowired
    private PrimeVarRep primeVarRep;
    @Autowired
    private PointgeRepository pointgeRepository;
    @Autowired
    private AvanceRep avanceRep;
    @Autowired
    private CnssRepository cnssRepository;
    @Autowired
    private CnamRepository cnamRepository;
    @Autowired
    private ContratsRepository contratsRepository;
    @Autowired
    private LicenciementRepository licenciementRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;


    @Autowired
    private AccountService accountService;
    @CrossOrigin("*")
    @PostMapping(value = "/signup")
    public Employe signup(@RequestBody Employe p) {
        return accountService.saveUser(p);

    }
    @GetMapping(value = "/listemployes")
    public List<Employe> listEmployes() {
        List<Employe> employes = employeRepository.findAll().stream().map(employe -> {
            return Employe.builder()
                    .nom(employe.getNom())
                    .idEmploye(employe.getIdEmploye())
                    .adresse(employe.getAdresse())
                    .email(employe.getEmail())
                    .etat(employe.getEtat())
                    .genre(employe.getGenre())
                    .nni(employe.getNni())
                    .matricule(employe.getMatricule())
                    .numeroCompte(employe.getNumeroCompte())
                    .build();
        }).collect(Collectors.toList());
        return employes;
    }






    /* @GetMapping(value = "/recherche-employes")
    public List<Employe> rechercheEmploye(@RequestParam(defaultValue = "") String nom, @RequestParam(defaultValue = "") String prenom, @RequestParam(defaultValue = "0") int nni)
    {
       if(nni > 0)
       {
            return employeRepository.findByNomContainsAndPrenomContainsAndNniEquals(nom, prenom, nni);
       }
       else
       {
            return employeRepository.findByNomContainsAndPrenomContains(nom, prenom);
       }
       
    }*/

    @GetMapping(value = "/listemployes/{idEmploye}")
    public Employe listEmployes(@PathVariable(name = "idEmploye") long idEmploye) {
        return employeRepository.findById(idEmploye).get();

    }

    @PutMapping(value = "/listemployes/{idEmploye}")
    public Employe update(@PathVariable(name = "idEmploye") long idEmploye, @RequestBody Employe p) {
        // p.setIdEmploye(idEmploye);
        return employeRepository.save(p);

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/listemployes")
    public Employe save(@RequestBody Employe p) {
        if (p.getUsername() == null || p.getPassword() == null) {
            throw new RuntimeException("required username and password");
        }

        if (employeRepository.findByUsername(p.getUsername()) != null) {
            throw  new RuntimeException("username exist deja");
        }

        p.setPassword(bcryptPasswordEncoder.encode(p.getPassword()));
        p =  employeRepository.save(p);

        return p;
    }

    @DeleteMapping(value = "/listemployes/{idEmploye}")
    public void delete(@PathVariable(name = "idEmploye") long idEmploye) {

        employeRepository.deleteById(idEmploye);

    }

    //calcul sal pour un seul emp
    @PostMapping(value = "/bultinSalaire")
    public HashMap getBultinSalaire(@RequestBody Data data) {
        if (data.getIdEmploye() == null || data.getDate() == null) {
            throw new RuntimeException("required idEmp or date");
        }
        Integer month = data.getDate().getMonthValue();
        Employe e = employeRepository.getOne(data.getIdEmploye());
        List<Pointage> pointages = pointgeRepository.getEmployePointages(data.getDate().getYear(), data.getDate().getMonthValue(), data.getIdEmploye());
        Long totalHeures = pointages.isEmpty()  ? 0L : pointages.stream()
                .map(pointage -> ChronoUnit.MINUTES.between(pointage.getHeures_entree().toInstant(), pointage.getHeures_sortie().toInstant())).reduce(Long::sum).get() / 60;

        HashMap res = new HashMap<String, Object>();

        double heureNormale = totalHeures >= 172.33 ? 172.33 : totalHeures;
        double heureSup = totalHeures > 172.33 ? totalHeures - 172.33 : 0;
        double tauxHor = e.getSalBase() / (172.33);

        double heureSupPrix = 0D; //heureSup > 0 ? heureSup * tauxHor : 0;

        double salaireBrut = heureNormale * tauxHor;

        // double mntPointage = heureNormale / tauxHor;

        double sommePrime = (!e.getPrimefixe().isEmpty() && !e.getPrimevariable().isEmpty()) ? e.getPrimefixe().get(0).getValeur_prime() + e.getPrimevariable().get(0).getValeur_prime() : 0D;
//calcul pourcentage licenciment
        double sommeGain = sommePrime + salaireBrut;

        //double primeSalBase = sommePrime + e.getSalBase();
        //
        double totalAPayer = sommePrime + e.getSalBase();
///cnam app sur sommeGain au lieu totalpayer
        double cnam = (4 * sommeGain) / 100;
//CNSs
        double plafondSalCnss = cnssRepository.getOne(Long.parseLong("1")).getPlafondSalarial();
// a corriger cnss surtt calcul
        int nbrPlafondInSal = (int) (e.getSalBase() / plafondSalCnss);

        double percentCnss = cnssRepository.getOne(Long.parseLong("1")).getPourcentageCnss();

        double sommeMntCnss = 0;

        if (e.getSalBase() > plafondSalCnss) {
            sommeMntCnss = nbrPlafondInSal * (percentCnss * plafondSalCnss);
        }


        AvanceSalaire avanceSalaire = avanceRep.findFirstByEmploye_IdEmployeAndMois(data.getIdEmploye(), month);
        double avanceSalValue = avanceSalaire != null ? avanceSalaire.getValeur() : 0D;
//sommeGain*0.15



        double its = 0;

       if (e.getSalBase() > 6000 && e.getSalBase() <= 9000) {
          its = sommeGain * 0.15 ;
     } else if (e.getSalBase() > 9000 && e.getSalBase() <= 21000) {
           its = sommeGain * 0.25 - 900;
      } else {
           its = sommeGain * 0.40 - 4050;
        }




        double anciennete = 0D;
        Contrats contrats = contratsRepository.findFirstByEmploye_IdEmploye(data.getIdEmploye());
        if (contrats != null && contrats.getDate_emabauche() != null) {
            LocalDate today = LocalDate.now();
            Integer yearEx = today.getYear() - contrats.getDate_emabauche().getYear();
            Integer totalPercent = 0;
            if (yearEx > 2 && yearEx < 16) {
                totalPercent = (yearEx - 2) * 2;
            }
            // a corriger
            if (yearEx > 16) {
                totalPercent = totalPercent + ((yearEx - 16) * 1);
            }
            totalPercent = totalPercent > 30 ? 30 : totalPercent;
            anciennete = e.getSalBase() * (totalPercent / 100);
        }

        double netAPayer = (sommePrime - its) + e.getSalBase() - (sommeMntCnss + cnam) + anciennete;

        heureSupPrix = getHeureSupValue(pointages, tauxHor);

        res.put("heureTotal", totalHeures);
        res.put("heureNormale", heureNormale);
        res.put("heureSup", heureSup);
        res.put("heureSupPrix", heureSupPrix);
        res.put("total", totalAPayer);
        res.put("montantPayer", sommeMntCnss);
        res.put("montantCnam", cnam);
        res.put("montantPrimes", sommePrime);
        res.put("salaireBrut", salaireBrut);
        res.put("netAPayer", netAPayer);
        res.put("avance", avanceSalValue);
        res.put("sommeGain",sommeGain);
        res.put("pret", 0);
        res.put("ITS", its);
        res.put("Anciennete", anciennete);
        res.put("congesAmount", getCongesAmount(e));
        res.put("retraiteAmount", licensimentEtRetraite(sommeGain,e));

        return res;
    }

    private double getHeureSupValue(List<Pointage> pointages, double taux) {
        List<Long> weeksHours = new ArrayList<>();
        double heureSupVal = 0;
        weeksHours.add(getWeekHours(pointages, 1, 6));
        weeksHours.add(getWeekHours(pointages, 8, 14));
        weeksHours.add(getWeekHours(pointages, 15, 21));
        weeksHours.add(getWeekHours(pointages, 21, 30));
        for (Long weeksHour : weeksHours) {
            if (weeksHour > 40 && weeksHour < 49) {
                heureSupVal = heureSupVal + ((weeksHour - 40) * (taux + (taux * 0.15)));
            } else if (weeksHour > 49) {
                heureSupVal = heureSupVal + ((weeksHour - 40) * (taux + (taux * 0.40)));
            }
        }
        return heureSupVal;
    }

    private Long getWeekHours(List<Pointage> pointages, Integer min, Integer max) {
        List<Pointage> pointages1 = pointages.stream()
                .filter(pointage -> pointage.getHeures_entree().getDate() > min && pointage.getHeures_entree().getDate() <= max)
                .collect(Collectors.toList());
        if (!pointages1.isEmpty()) {
            return pointages1.stream().map(pointage ->
                    ChronoUnit.MINUTES.between(pointage.getHeures_entree().toInstant(), pointage.getHeures_sortie().toInstant())).reduce(Long::sum).get() / 60;
        } else return 0L;
    }

    //code licenciement et conges
    public double getSalaireBrutePerMonth(int yaer, int month, Employe employe) {
        List<Pointage> pointages = pointgeRepository.getEmployePointages(yaer, month, employe.getIdEmploye());
        Long totalHeures = pointages.stream()
                .map(pointage -> ChronoUnit.MINUTES.between(pointage.getHeures_entree().toInstant(), pointage.getHeures_sortie().toInstant())).reduce(Long::sum).get() / 60;
        double heureNormale = totalHeures >= 172.33 ? 172.33 : totalHeures;
        double tauxHor = employe.getSalBase() / (172.33);
        return heureNormale * tauxHor;
    }

    public double getCongesAmount(Employe employe) {
        Contrats contrats = contratsRepository.findFirstByEmploye_IdEmploye(
                employe.getIdEmploye()
        );
        if (contrats == null) {
            System.out.println("invalid contract !");
            return -1D;
        }
        int currentYear = LocalDate.now().getYear();
        Date embaucheDate = contrats.getDate_emabauche();
        Date startYear = new Date(currentYear, embaucheDate.getMonth(), embaucheDate.getDay());
        List<Pointage> pointages = pointgeRepository.getEmployePointages(startYear.getYear(), startYear.getMonth(), employe.getIdEmploye());
        long countWorkedMonths = ChronoUnit.MONTHS.between(
                LocalDate.parse(startYear.toString()).withDayOfMonth(1),
                LocalDate.parse(pointages.get(pointages.size() - 1).getDate_Pointage().toString()).withDayOfMonth(1));
        if (countWorkedMonths == 12) {
            double totalSalBrut = 0.0;
            for (int i = 1; i <= 12; i++) {
                totalSalBrut += getSalaireBrutePerMonth(startYear.getYear(), i, employe);
            }

            return totalSalBrut != 0.0 ? ((totalSalBrut / 12) + employe.getSalBase()) : 0.0;
        }
        return 0D;
    }

    public Double licensimentEtRetraite(Double sommeGain, Employe employe) {
        Contrats contrats = contratsRepository.findFirstByEmploye_IdEmploye(
                employe.getIdEmploye()
        );
        Licenciement ls = licenciementRepository.findFirstByEmploye_IdEmploye(employe.getIdEmploye());
        if (contrats == null || ls == null || ls.getDate() == null) {
            System.out.println("invalid contract !");
            return -1D;
        }

        int nbOfYear =  ls.getDate().getYear() - contrats.getDate_emabauche().getYear();
        if (nbOfYear <= 5) {
            return sommeGain * 25;
        } else if (nbOfYear <= 10) {
            return sommeGain * 30;
        }

        return 0.0;
    }


}
