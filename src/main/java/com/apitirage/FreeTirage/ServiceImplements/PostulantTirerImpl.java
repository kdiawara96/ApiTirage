package com.apitirage.FreeTirage.ServiceImplements;

import com.apitirage.FreeTirage.Repository.Postulants_tirer_repo;
import com.apitirage.FreeTirage.Services.ServicePostulantTirer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostulantTirerImpl implements ServicePostulantTirer {

    @Autowired
    private final Postulants_tirer_repo ptr;

    @Override
    public int insertion_tirage(Long tirage, int indexT) {
        return ptr.insertion_tirage(tirage,indexT);
    }

}
