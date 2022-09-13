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
    public Postulants insererUnPostulant(Postulants postulant) {
        return post_repo.save(postulant);
    }


    @Override
    public List<Object> listId() {
       return post_repo.listId();
    }

    public Postulants findByEmail(String email){
        return post_repo.findByEmail(email);
    }

    @Override
    public Integer ComptePostulants() {
        return post_repo.countPostulants();
    }

}
