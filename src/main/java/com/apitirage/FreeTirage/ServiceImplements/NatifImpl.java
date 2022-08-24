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
}
