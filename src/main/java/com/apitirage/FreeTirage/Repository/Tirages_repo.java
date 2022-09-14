package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Tirages;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface Tirages_repo extends JpaRepository<Tirages, Long> {

    @Query(value = "SELECT COUNT(*) FROM `tirages`;", nativeQuery = true)
    public Integer countListe();
    @Query(value ="SELECT DISTINCT tirages.datetirage, tirages.libelletirage,tirages.nbr FROM `tirages`,liste WHERE tirages.liste_id= ?" , nativeQuery = true)
    public Page<Object> afichierTirage_en_fonction_liste(long id, Pageable pageable);

/*     @Query(value = "select * from tirages where liste_id = :idliste", nativeQuery = true)
    public List<Tirages> FIND_TIRAGE_IDLISTE(@Param("idliste") Long idliste);*/


}
