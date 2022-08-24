package com.apitirage.FreeTirage.ServiceImplements;

import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Repository.Postulants_repo;
import com.apitirage.FreeTirage.Services.ServiceNative;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor

public class NatifImpl implements ServiceNative {

    private final Postulants_repo repoPo;

    @Override
    public List<Object> list_postulant_avec_libele(String libelle) {
        return repoPo.list_postulant_avec_libele(libelle);
    }

    @Override
    public List<Object> list_postulant_tirer_avec_libele_de_la_liste(String libelle_liste) {
        return repoPo.list_postulant_tirer_avec_libele_de_la_liste(libelle_liste);
    }

    @Override
    public List<Object> list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(String libelle_liste, String libelle_tirage) {
        return repoPo.list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(libelle_liste, libelle_tirage);
    }
}
