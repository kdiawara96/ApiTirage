package com.apitirage.FreeTirage.Services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicePostulantTirer{
    Integer insertion_tirage(Long tirage, int indexT);
    Page<Object> afficherPostulantsParTirge(Long id, Pageable pageable);
    Page<Object> afficherPostulantsPar_Libelle_Tirage(String libelle ,Pageable pageable);


}
