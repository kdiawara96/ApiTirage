package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Services.ServiceNative;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequestMapping("/native")
@RestController
@AllArgsConstructor

public class RequetNative {

    private final ServiceNative service;

    @GetMapping("/list_avec_libelle/{libelle}")

    public List<Object> listPostulants_avec_Libelle(@PathVariable String libelle){
        try {
            return service.list_postulant_avec_libele(libelle);
        }catch (Exception e){
            Message.Response(e.getMessage(), HttpStatus.OK,null);
        }
     return null;
    }
}
