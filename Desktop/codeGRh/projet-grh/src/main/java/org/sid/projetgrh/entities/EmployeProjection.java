package org.sid.projetgrh.entities;

import org.sid.projetgrh.Employe;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types =Employe.class)
public interface EmployeProjection {
    public double getContact();
    public String getAdresse();
}
