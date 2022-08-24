package com.apitirage.FreeTirage.Controllers;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Others.InsertionExcel;
import com.apitirage.FreeTirage.Services.ServiceListe;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@Api(value = "Vous allez retrouver tous les requêtes qui concerne le postulants!")
@RestController
@RequestMapping("/postulants")
@AllArgsConstructor
public class PostulantsController {

    @Autowired
    final private ServicePostulants service;
    final private ServiceListe listPostulants;



    @ApiOperation(value = "Cette methode va vous permettre de TELEVERSER le fichier EXCEL et INSERER les POSTULANTS")
    @PostMapping("/add/{libelle}")
    public String add(@Param("file") MultipartFile file, Liste listp, @PathVariable("libelle") String libelle){


            InsertionExcel inser =  new InsertionExcel();

            List<Postulants> postList = inser.insert(file);
            
            listp.setDatetlist(new Date());

            Liste el = listPostulants.creer(listp);

            for(Postulants lili : postList){
                lili.setListe(el);
            }
            service.insererPostulant(postList);

           // service.read(file);
          //  list.add((List_Postulants) service.read(file));


        return "Success!";
        }

}
