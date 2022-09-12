package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Models.Postulants_Tirer;
import com.apitirage.FreeTirage.Models.Tirages;
import com.apitirage.FreeTirage.Others.Aleatoire;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServicePostulantTirer;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/tirages")
@AllArgsConstructor
@Api(value = "API_TIRAGE", description = "Ce controlleur regorge les requêtes sur le tirage!")
public class TirageController {

    private final ServiceTirage service;
    private final ServicePostulants servicePostulants;
    private final ServicePostulantTirer servicePos;


    @PostMapping("/inserTirage")
    @ResponseBody
    @ApiOperation(value = "Cette methode va vous permettre de faire le TIRAGE!")
    public ResponseEntity<Object> tirage(@RequestBody Tirages tirages) {
        try {
            //ous avons instancier la classe Aleatoire pour faire le trie avec sa methode tirage
            //voir la classe Others/Aleatoire.tirage

            Aleatoire tri = new Aleatoire(service, servicePostulants, servicePos);

            return Message.Response("", HttpStatus.OK, tri.tirage(tirages));
        }catch (Exception e){
          return Message.Response(e.getMessage() +"Une erreur c'est produit lors du tirage, " +
                    "MERCI DE BIEN VOULOIR VERIFIER L4EXISTANCE DE VOTRE LISTE!", HttpStatus.OK,null);
        }


    }


    @GetMapping("/AfficherTirage")
    @ApiOperation(value = "Cette methode va vous permettre d'afficher les TIRAGES!")
    public ResponseEntity<Object> listerTirages(){
        return Message.Response("", HttpStatus.OK, service.afficherTirage());
    }
}
