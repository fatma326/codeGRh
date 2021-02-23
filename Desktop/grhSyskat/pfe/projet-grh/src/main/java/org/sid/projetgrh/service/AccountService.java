package org.sid.projetgrh.service;

import org.sid.projetgrh.Employe;

public interface AccountService {

    public Employe saveUser(Employe data);

    public Employe findUserByUsername(String username);
    public void addRoleToUser(String username, String roleName);


}
