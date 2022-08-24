package com.apitirage.FreeTirage.ServiceImplements;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Repository.Postulants_repo;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantsImple implements ServicePostulants {

    private final Postulants_repo post_repo;

    @Override
    public List<Postulants> insererPostulant(List<Postulants> listInser) {
        return post_repo.saveAll(listInser);
    }


    @Override
    public List<Object> listId() {
       return post_repo.listId();
    }
}
