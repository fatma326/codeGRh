package org.sid.projetgrh.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Data {
    private Long idEmploye;
    private LocalDate date;
}
