package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Liste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;

public interface ServiceListe {
    Liste creer(Liste liste);
    List<Integer> countListe();
    Liste trouverListeParLibelle(String libelle);
    Page<Object> listeDetaill(Pageable pageable);
    List<Object> nbr_Tirage_sur_liste();
    Page<Object>liste_et_nombre_postulants(Pageable pageable);
    List<Object>nbr_postulant_sur_list();

}
