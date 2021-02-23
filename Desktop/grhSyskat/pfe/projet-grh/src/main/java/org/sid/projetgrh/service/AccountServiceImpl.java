package org.sid.projetgrh.service;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.EmployeRepository;
import org.sid.projetgrh.dao.RoleRepository;
import org.sid.projetgrh.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    private EmployeRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Employe saveUser(Employe data) {

        Employe u = new Employe();
        u.setEmail(data.getEmail());
        u.setUsername(data.getUsername());
        u.setNom(data.getNom());
        u.setPrenom(data.getPrenom());
        u.setPassword(bcryptPasswordEncoder.encode(data.getPassword()));

        userRepository.save(u);

        this.addRoleToUser(u.getUsername(), "USER");

        return u;
    }

    public Role saveRole(Role r) {

        return roleRepository.save(r);
    }

    @Override
    public Employe findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        Employe user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(roleName);
        user.getRoles().add(role);

    }

}
