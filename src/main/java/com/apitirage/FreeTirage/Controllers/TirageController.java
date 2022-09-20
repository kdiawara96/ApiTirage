package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Tirages;
import com.apitirage.FreeTirage.Others.Aleatoire;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Repository.Tirages_repo;
import com.apitirage.FreeTirage.Services.ServiceListe;
import com.apitirage.FreeTirage.Services.ServicePostulantTirer;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/tirages")
@AllArgsConstructor
@Api(value = "API_TIRAGE", description = "Ce controlleur regorge les requêtes sur le tirage!")
public class TirageController {

    private final ServiceTirage service;
    private final ServicePostulants servicePostulants;
    private final ServicePostulantTirer servicePos;
    private final ServiceListe serviceListe;




    @PostMapping("/inserTirage/{libelleL}")
    @ResponseBody
    @ApiOperation(value = "Cette methode va vous permettre de faire le TIRAGE!")
    public ResponseEntity<Object> tirage(@RequestBody Tirages tirages, @PathVariable String libelleL) {
        try {

            //ous avons instancier la classe Aleatoire pour faire le trie avec sa methode tirage
            //voir la classe Others/Aleatoire.tirage
            Liste liste1 = this.serviceListe.trouverListeParLibelle(libelleL);
            tirages.setListe(liste1);

            Aleatoire tri = new Aleatoire(service, servicePostulants, servicePos);


            return Message.Response("", HttpStatus.OK, tri.tirage(tirages));
        }catch (Exception e){
          return Message.Response(e.getMessage() +"Une erreur c'est produit lors du tirage, " +
                    "MERCI DE BIEN VOULOIR VERIFIER L4EXISTANCE DE VOTRE LISTE!", HttpStatus.OK,null);
        }


    }



 /*   @PostMapping("/ajouter/{libelle}")
    public Tirages ajouterTirage(@PathVariable("libelle") String libelle, @RequestBody Tirages tirages){
        Liste liste1 = this.serviceListe.trouverListeParLibelle(libelle);
        tirages.setListe(liste1);
        tirages.setDatetirage(new Date());
        System.out.println("bien passer");
        return this.service.addTirage1(tirages);
    }
*/















    @GetMapping("/AfficherTirage")
    @ApiOperation(value = "Cette methode va vous permettre d'afficher les TIRAGES!")
    public Page<Tirages> listerTirages(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "10") int size, Pageable pageable){
      return service.afficherTirage(pageable);
    }


    @GetMapping("/totaleTirage")
    public ResponseEntity<Object> compteTirage(){
        try {
            return Message.Response("", HttpStatus.OK, service.compteTirage());

        }catch (Exception e){
            return Message.Response("Error ou liste vide! (°_~)", HttpStatus.OK, null);
        }
    }

    @GetMapping("/detailleTirageParListe/{id}")
    public Page<Object> detailleTirageParListe(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name ="size", defaultValue = "10") int size, @PathVariable long id, Pageable pageable){
        return service.afichierTirage_en_fonction_liste(id,pageable);
    }

   /* @GetMapping("/tiragesParIdListe/{idliste}")
    public List<Tirages> retournerTirageListe(@PathVariable Long idliste){
        return tirages_repo.FIND_TIRAGE_IDLISTE(idliste);
    }*/
}
