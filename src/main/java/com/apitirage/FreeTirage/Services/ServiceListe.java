package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Liste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;

public interface ServiceListe {
    Liste creer(Liste liste);
    List<Integer> countListe();
    Liste trouverListeParLibelle(String libelle);
    List<Object> listeDetaill();

}
