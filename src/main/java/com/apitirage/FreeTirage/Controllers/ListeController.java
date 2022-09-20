package com.apitirage.FreeTirage.Controllers;


import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServiceListe;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Vous allez retrouver tous les requêtes qui concerne le postulants!")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/liste")
@AllArgsConstructor
public class ListeController {

    @Autowired
    private ServiceListe service;
    @Autowired
    private ServiceListe listServ;
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
    public Page<Object> detailleListe(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "5") int size, Pageable pageable){

        listServ.nbr_Tirage_sur_liste();
  return service.listeDetaill(pageable);
    }

    @GetMapping("/nombreTirageuriste")
    public List<Object> nombreTirageuriste(){
        return listServ.nbr_Tirage_sur_liste();
    }

    @GetMapping("/liste_nbr_postulant")
    public Page<Object> liste_et_nombre_postulants(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "10") int size, Pageable pageable){
        return listServ.liste_et_nombre_postulants(pageable);
    }

    @GetMapping("/nbr_postulant_sur_list")
    public List<Object> nbr_postulant_sur_list(){
        return listServ.nbr_postulant_sur_list();
    }

    @GetMapping("/listeComplet")
    public List<Object> listeComplet(){
        return listServ.listeComplet();
    }





    @GetMapping("/Afficher_detailListe_et_nombrePostulant_de_la_liste")
    public Page<Object>Afficher_detailListe_et_nombrePostulant_de_la_liste(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "10") int size, Pageable pageable){
        return listServ.Afficher_detailListe_et_nombrePostulant_de_la_liste(pageable);
    }


    @GetMapping("/liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste")
    public List<Object>liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "10") int size, Pageable pageable){
        return listServ.liste_detail_et_nbr_Tirage_Fait_Sur_La_Liste(pageable);
    }

}
