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


/*
     Nous allons recuper le nombre entreer par l'utilisateur
 */
        int nbr = tirages.getNbr();

        /*
             Ici nous instancions la valeur value en 1 qui va prendre la valeur aléatoire
         */

        int value =1;

        /*
         Nous créons un tableau Dynamique de type Object et recevons la liste des id de la table Postulants
         */

        List<Object> idl= servicePostulants.listId();

        /*
          Nous créons encore un tableau dynamique pour recevoir les valeurs randoms qui va être generer
         */
         List<Integer> valeurRandom = new ArrayList<>();
        /*
            Nous appelons la fonction random qui aura un nom random
         */

         Random random = new Random();


        /*
            Nous aurons besoins d'unE boucle qui va nous permettre d'iterer jusqu'à ce que nous trouvons les valeurs demander par le
            user (nbr)
         */

         do {
             /*
                nous appliquons la fonction random à la taille du
                tableau avec idl.size et mettre la valeur retourner dans  value declarer en haut

              */
             value = random.nextInt(idl.size());

             /*
                 nous mettons des conditions pour eviter des redondance de valeur et de consideration de l'index
                 zero
              */
                 if (value != 0 && valeurRandom.contains(value) == false ){
                 /*
                 Après nous ajoutons la value dans le tableau dynamique valeurRandom
                  */
                 valeurRandom.add(value);
                 /*
                    et nous supprimons la valeur prise déjà par le random dans le tableau idl
                  */

                 idl.remove(value);
                     /*
                      Nous decrementons le nbr pour que la boucle puisse s'arrêter
                      */
                 --nbr;
             }
         }while (nbr > 0);

        /*
           Nous ajouter les valeurs de Tirage en recuperant son id encours pour donner au Postulant tiré
         */

        Tirages tt = service.addTirage(tirages);

        Long id = tt.getId();

        /*
           Nous iterons le tableau valeurRandom pour donner les valeur au requête native declarer dans le repository

         */

        for (int  po : valeurRandom)
        {

            /*
               Insertion dans la table postulant tiré
             */

            servicePos.insertion_tirage(id, po);
        }
        /*
          Pas neccessaire mais juste pour voir les valeur tiré dans postman
         */

       return  valeurRandom;
    }



}
