package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Liste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceListe {
    Liste creer(Liste liste);

}
