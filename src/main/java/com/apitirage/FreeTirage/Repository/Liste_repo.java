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

    @Query(value = "SELECT liste.id, liste.libelle, liste.datelist FROM liste, tirages WHERE liste.id = tirages.liste_id", nativeQuery = true)
    public Page<Object> listedetail(Pageable pageable);

   @Query(value = "SELECT COUNT(*) FROM tirages,liste WHERE tirages.liste_id=liste.id GROUP BY liste.id", nativeQuery = true)
   List<Object>totalTirageSurListe();

    @Query(value = "SELECT DISTINCT liste.libelle, liste.datelist FROM postulants_liste, liste,postulants WHERE liste.id=postulants_liste.idliste AND postulants_liste.idpostulants=postulants.id", nativeQuery = true)
    Page<Object>liste_et_nombre_postulants(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM postulants_liste, liste,postulants WHERE liste.id=postulants_liste.idliste AND postulants_liste.idpostulants=postulants.id GROUP BY postulants_liste.idpostulants", nativeQuery = true)
    List<Object>nbr_postulant_sur_list();


    Liste findByLibelle(String libelle);

//cette requet nous affiche les elements en fonction de la liste
// SELECT liste.libelle, liste.datelist, postulants.nom FROM postulants_liste, liste,postulants WHERE liste.id=postulants_liste.idliste AND postulants_liste.idpostulants=postulants.id;



}
