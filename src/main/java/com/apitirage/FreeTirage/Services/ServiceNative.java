package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceNative {
    List<Object> list_postulant_avec_libele(String libelle);
}
