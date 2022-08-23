package com.apitirage.FreeTirage.Controllers;

import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Models.Postulants_Tirer;
import com.apitirage.FreeTirage.Models.Tirages;
import com.apitirage.FreeTirage.Services.ServicePostulantTirer;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import com.apitirage.FreeTirage.Services.ServiceTirage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/tirages")
@AllArgsConstructor
public class TirageController {

    private final ServiceTirage service;
    private final ServicePostulants servicePostulants;
    private final ServicePostulantTirer servicePos;

    @PostMapping("/inserTirage")
    @ResponseBody
    public List<Integer> tirage(@RequestBody Tirages tirages){



        int nbr = tirages.getNbr() -1;


        int value =1;
    List<Object> idl= servicePostulants.listId();

    List<Integer> valeurRandom = new ArrayList<>();

     Random random = new Random();


         do {
             value = random.nextInt(idl.size());

             if (value != 0 && valeurRandom.contains(value) == false ){

                 valeurRandom.add(value);

                 idl.remove(value);

                 --nbr;
             }
         }while (nbr > 0);
        Tirages tt = service.addTirage(tirages);

        Long id = tt.getId();
        for (int  po : valeurRandom)
        {

            servicePos.insertion_tirage(id, po);
        }

       return  valeurRandom;
    }



    @GetMapping("/idlist")
    @ResponseBody
    public List<Object> idliste(){
        if (servicePostulants.listId() == null){
            return null;
        }else {
            return servicePostulants.listId();
        }
    }
}
