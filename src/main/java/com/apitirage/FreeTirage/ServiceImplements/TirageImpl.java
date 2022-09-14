package com.apitirage.FreeTirage.ServiceImplements;

import com.apitirage.FreeTirage.Models.Tirages;
import com.apitirage.FreeTirage.Repository.Tirages_repo;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TirageImpl implements ServiceTirage {
  private final Tirages_repo repo;

    @Override
    public Tirages addTirage(Tirages tirage) {
        tirage.setDatetirage(new Date());
        return  repo.save(tirage);
    }


    @Override
    public Tirages addTirage1(Tirages tirage) {
        return this.repo.save(tirage);
    }

    @Override
    public List<Tirages> afficherTirage() {
        return repo.findAll();
    }

    @Override
    public Integer compteTirage() {
        return repo.countListe();
    }

    @Override
    public Page<Object> afichierTirage_en_fonction_liste(long id, Pageable pageable) {
        return repo.afichierTirage_en_fonction_liste(id,pageable);
    }
}
