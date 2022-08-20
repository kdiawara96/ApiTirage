package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Postulants;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ServicePostulants {
    List<Postulants> insererPostulant(List<Postulants> listInser);
    List<Postulants> read(MultipartFile file);
}
