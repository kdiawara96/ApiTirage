package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Tirages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

public interface ServiceTirage {
     Tirages addTirage(Tirages tirage);

    //Tirages addTirage1(Tirages tirage);

    List<Tirages> afficherTirage();

    Integer compteTirage();

    Page<Object>afichierTirage_en_fonction_liste(long id, Pageable pageable);
}
