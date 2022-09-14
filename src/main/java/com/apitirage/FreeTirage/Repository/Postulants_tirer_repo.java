package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Postulants_Tirer;
import com.apitirage.FreeTirage.Models.Tirages;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Postulants_tirer_repo extends JpaRepository<Postulants_Tirer, Long> {

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO postulants_tirer (tirage_id,index_tirage) VALUES (?,?)" ,nativeQuery = true)
    public int insertion_tirage( Long tirage, int indexT);

    @Query(value = "SELECT postulants.nom, postulants.prenom, liste.libelle,tirages.libelletirage FROM tirages, postulants, liste, postulants_liste WHERE   tirages.liste_id = liste.id AND postulants_liste.idliste=liste.id AND postulants.id =postulants_liste.idpostulants AND tirages.id=?",nativeQuery = true)
    public List<Object> afficherPostulantsParTirge(Long id);
}