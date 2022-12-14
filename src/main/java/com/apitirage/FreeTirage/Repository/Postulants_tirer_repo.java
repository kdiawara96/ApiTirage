package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Postulants_Tirer;
import com.apitirage.FreeTirage.Models.Tirages;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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



    @Query(value = "SELECT DISTINCT postulants.nom, postulants.prenom,postulants.email, postulants.numero, tirages.libelletirage, liste.libelle FROM postulants, liste, postulants_tirer,tirages WHERE postulants.id = postulants_tirer.index_tirage AND postulants_tirer.tirage_id = tirages.id AND tirages.liste_id =liste.id AND tirages.libelletirage=?",nativeQuery = true)
    public Page<Object> afficherPostulantsPar_Libelle_Tirage(String libelle, Pageable pageable);

    @Query(value = "SELECT DISTINCT postulants.nom, postulants.prenom, tirages.libelletirage, liste.libelle FROM postulants, liste, postulants_tirer,tirages WHERE postulants.id = postulants_tirer.index_tirage AND postulants_tirer.tirage_id = tirages.id AND tirages.liste_id =liste.id AND postulants_tirer.tirage_id=?",nativeQuery = true)
    public Page<Object> afficherPostulantsParTirage(Long id, Pageable pageable);
}