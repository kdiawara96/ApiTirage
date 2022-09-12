package com.apitirage.FreeTirage.Repository;

import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Tirages;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface Tirages_repo extends JpaRepository<Tirages, Long> {



}
