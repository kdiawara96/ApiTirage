package com.apitirage.FreeTirage.Repository;
import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Postulants_repo extends JpaRepository<Postulants, Long> {

    @Query(value = "SELECT id FROM postulants", nativeQuery = true)
    public List<Object> listId();

}
