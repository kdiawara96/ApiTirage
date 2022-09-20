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
    List<Object> listeComplet();


    Page<Object> Afficher_detailListe_et_nombrePostulant_de_la_liste(Pageable pageable);
    List<Object> liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste(Pageable pageable);

}
