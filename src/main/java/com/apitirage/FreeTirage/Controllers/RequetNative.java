package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServiceNative;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
@Api(value = "Vous allez retrouver tous les requêtes Native créer!")
@RequestMapping("/native")
@RestController
@AllArgsConstructor

public class RequetNative {

    private final ServiceNative service;
    @ApiOperation(value = "Cette methode va vous permettre de lister les postulants par rapport au libellé de la LISTE donner dans le lien!")
    @GetMapping("/listPostulants_avec_libelle/{libelle}")
    public List<Object> listPostulants_avec_Libelle(@PathVariable String libelle){
        try {
            return service.list_postulant_avec_libele(libelle);
        }catch (Exception e){
            Message.Response(e.getMessage(), HttpStatus.OK,null);
        }
     return null;
    }

    @ApiOperation(value = "Cette methode va vous permettre de lister les postulants tirer par rapport au libellé de la LISTE donner dans le lien!")
    @GetMapping("/list_postulantTire_libelle_liste/{libelle_liste}")
    public List<Object> list_postulant_tirer_avec_libele_de_la_liste(@PathVariable String libelle_liste){
        try {
            return service.list_postulant_tirer_avec_libele_de_la_liste(libelle_liste);
        }catch (Exception e){
            Message.Response(e.getMessage(), HttpStatus.OK,null);
        }
        return null;
    }
    @ApiOperation(value = "Cette methode va vous permettre de lister les postulants tirer par rapport à la libellé de la LISTE donner dans le lien et le libellé du TIRAGE!")
    @GetMapping("/list_postulantTire_libelle_liste_libelle_tirage/{libelle_liste}/{libelle_tirage}")
    List<Object> list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(@PathVariable String libelle_liste, @PathVariable String libelle_tirage){
        try {
            return service.list_postulant_tirer_avec_libele_de_la_liste_et_du_tirage(libelle_liste,libelle_tirage);

        }catch (Exception e){
            Message.Response(e.getMessage(), HttpStatus.OK,null);
        }
        return null;
        }
}
