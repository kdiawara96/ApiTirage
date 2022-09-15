package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServicePostulantTirer;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Vous allez retrouver tous les requêtes qui concerne le postulants Tirer!")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/postulantTirer")
@AllArgsConstructor
public class Postulant_TirerController {
    @Autowired
    final private ServicePostulantTirer service;


    @GetMapping("/postulantsTirer/{id}")
    public Page<Object> postulantsTirer(@PathVariable Long id, Pageable pageable){
        return service.afficherPostulantsParTirge(id,pageable);
    }
}
