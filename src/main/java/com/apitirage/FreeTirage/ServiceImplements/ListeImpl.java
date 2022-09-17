package com.apitirage.FreeTirage.ServiceImplements;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Repository.Liste_repo;
import com.apitirage.FreeTirage.Services.ServiceListe;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
@AllArgsConstructor
public class ListeImpl implements ServiceListe {
final private Liste_repo repo;

    @Override
    public Liste creer(Liste liste) {
        return repo.save(liste) ;
    }

    @Override
    public List<Integer> countListe() {
        return repo.countListe();
    }

    @Override
    public Liste trouverListeParLibelle(String libelle) {
        return this.repo.findByLibelle(libelle);
    }

    @Override
    public Page<Object> listeDetaill(Pageable pageable) {
        return repo.listedetail(pageable);
    }


    @Override
    public List<Object> nbr_Tirage_sur_liste() {
        return repo.totalTirageSurListe();
    }

    @Override
    public Page<Object> liste_et_nombre_postulants(Pageable pageable) {
        return repo.liste_et_nombre_postulants(pageable);
    }

    @Override
    public List<Object> nbr_postulant_sur_list() {
        return repo.nbr_postulant_sur_list();
    }

    @Override
    public List<Object> listeComplet() {
        return repo.listeComplet();
    }








    @Override
    public List<Object> Afficher_detailListe_et_nombrePostulant_de_la_liste(Pageable pageable) {
        return repo.Afficher_detailListe_et_nombrePostulant_de_la_liste(pageable);
    }


    @Override
    public List<Object> liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste(Pageable pageable) {
        return repo.liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste(pageable);
    }

}
