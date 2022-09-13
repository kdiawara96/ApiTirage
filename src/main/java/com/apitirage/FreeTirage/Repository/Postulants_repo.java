package com.apitirage.FreeTirage.Repository;
import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Postulants_repo extends JpaRepository<Postulants, Long> {

    public Postulants findByEmail(String email);

    @Query(value = "SELECT postulants.id FROM postulants", nativeQuery = true)
    public List<Object> listId();

    @Query(value = "SELECT postulants.nom, postulants.prenom,postulants.numero, postulants.email FROM `postulants`, `liste` WHERE liste.libelle = ?", nativeQuery = true)
    List<Object> list_postulant_avec_libele(@Param("libelle") String libelle);

    // cette requette va nous ramener la liste des personnes tirer sur la liste indiquer
    //Sur la requette il y a une partie qu'on doit mettre le libelle <<liste.libelle = ? >>

    @Query(value = "SELECT postulants.nom, postulants.prenom , postulants.numero , postulants.email FROM `postulants`,`liste`,`tirages`,`postulants_tirer` WHERE postulants.liste_id = liste.id AND liste.libelle = ? AND tirages.liste_id = liste.id AND tirages.id = postulants_tirer.tirage_id AND postulants.id = postulants_tirer.index_tirage;", nativeQuery = true)
    List<Object> list_postulant_tirer_avec_libele_de_la_liste(@Param("libelle_liste") String libelle_liste);

    @Query(value = "SELECT postulants.nom, postulants.prenom, postulants.numero, postulants.email FROM `postulants`,`liste`,`tirages`,`postulants_tirer` WHERE postulants.liste_id = liste.id AND liste.libelle =? AND tirages.liste_id = liste.id AND tirages.id = postulants_tirer.tirage_id AND postulants.id = postulants_tirer.index_tirage AND tirages.libelletirage =?", nativeQuery = true)
    List<Object> list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(@Param("libelle_liste") String libelle_liste, @Param("libelle_tirage") String libelle_tirage);

    @Query(value = "SELECT COUNT(*) FROM `postulants`;", nativeQuery = true)
    Integer countPostulants();
}
