package com.apitirage.FreeTirage.ServiceImplements;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Repository.Liste_repo;
import com.apitirage.FreeTirage.Services.ServiceListe;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class ListeImpl implements ServiceListe {
final private Liste_repo repo;
    @Override
    public Liste creer(Liste liste) {
        return repo.save(liste) ;
    }
}
