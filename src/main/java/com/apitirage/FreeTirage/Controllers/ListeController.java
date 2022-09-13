package com.apitirage.FreeTirage.Controllers;


import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServiceListe;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Api(value = "Vous allez retrouver tous les requêtes qui concerne le postulants!")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/liste")
@AllArgsConstructor
public class ListeController {

    @Autowired
    private ServiceListe service;
/*
    @GetMapping("/totalListeTire")
    public ResponseEntity<Object> allListe(){
        try{
            return Message.Response("", HttpStatus.OK, service.countListe());
        }catch (Exception e){
            return Message.Response("Error ou liste vide! (°_~)", HttpStatus.OK, null);
        }

    }*/
@GetMapping("/totalListeTire")
public ResponseEntity<Object> allListe(){
    int nbr = service.countListe().size();
    try{
        return Message.Response("", HttpStatus.OK, nbr);
    }catch (Exception e){
        return Message.Response("Error ou liste vide! (°_~)", HttpStatus.OK, null);
    }
    }

   /* @GetMapping("/detailleListe")
    public ResponseEntity<Object> detailleListe(){

        try{
            return Message.Response("", HttpStatus.OK, service.listeDetaill());
        }catch (Exception e){
            return Message.Response("Error ou liste vide! (°_~)", HttpStatus.OK, null);
        }
    }*/

    @GetMapping("/detailleListe")
    public List<Object> detailleListe(){
  return service.listeDetaill();
    }

}
