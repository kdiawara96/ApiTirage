package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Liste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Liste_repo extends JpaRepository<Liste,Long> {

    @Query(value = "SELECT DISTINCT liste.id FROM liste, tirages WHERE liste.id = tirages.liste_id", nativeQuery = true)
    public List<Integer> countListe();

    @Query(value = "SELECT liste.id, liste.libelle, liste.datelist, tirages.nbr FROM liste, tirages WHERE liste.id = tirages.liste_id", nativeQuery = true)
    public Page<Object> listedetail(Pageable pageable);


    Liste findByLibelle(String libelle);





}
