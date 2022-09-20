package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Tirages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceTirage {
     Tirages addTirage(Tirages tirage);

    //Tirages addTirage1(Tirages tirage);

    Page<Tirages> afficherTirage(Pageable pageable);

    Integer compteTirage();

    Page<Object>afichierTirage_en_fonction_liste(long id, Pageable pageable);
}
