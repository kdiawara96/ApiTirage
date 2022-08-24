package com.apitirage.FreeTirage.Repository;
import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Postulants_repo extends JpaRepository<Postulants, Long> {

    @Query(value = "SELECT id FROM postulants", nativeQuery = true)
    public List<Object> listId();

    @Query(value = "SELECT postulants.nom, postulants.prenom,postulants.numero, postulants.email FROM `postulants`, `liste` WHERE liste.libelle = ?", nativeQuery = true)
    List<Object> list_postulant_avec_libele(@Param("libelle") String libelle);

}
