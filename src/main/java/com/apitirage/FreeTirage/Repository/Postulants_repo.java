package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Postulants;
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
public interface Postulants_repo extends JpaRepository<Postulants, Long> {
   // @Modifying
   // @Transactional
    //@Query(value = "INSERT INTO `postulants`(`email`, `nom`, `numero`, `prenom`) VALUES (:email, :nom, :numero,:prenom);", nativeQuery = true)
    //int insererPostulants(@Param("nom") String nom, @Param("prenom") String prenom ,@Param("numero") String numero, @Param("email") String email);
}
