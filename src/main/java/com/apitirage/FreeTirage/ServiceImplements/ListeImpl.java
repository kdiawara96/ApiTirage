package com.apitirage.FreeTirage.ServiceImplements;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Postulants;
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


}
