package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceNative {
    List<Object> list_postulant_avec_libele(String libelle);


    List<Object>list_postulant_tirer_avec_libele_de_la_liste(String libelle_liste);

    List<Object> list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(String libelle_liste, String libelle_tirage);
}
