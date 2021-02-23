package org.sid.projetgrh.service;
import org.sid.projetgrh.Licenciement;
import org.sid.projetgrh.dao.LicenciementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class licenciementRestService {

    @Autowired
    LicenciementRepository licenciementRepository;

    public List<Licenciement> licenciementList() {
        return licenciementRepository.findAll();
    }


    public Licenciement findById(long id) {
        return licenciementRepository.findById(id).get();

    }


    public Licenciement update(long id, Licenciement l) {

        return licenciementRepository.save(l);
    }


    public Licenciement save(Licenciement l) {
        return licenciementRepository.save(l);
    }


    public void delete( long id) {

        licenciementRepository.deleteById(id);

    }
}
