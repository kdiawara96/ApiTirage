package com.apitirage.FreeTirage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tirages")
@AllArgsConstructor
@NoArgsConstructor

public class Tirages {
    //GenerationType.Identity veut dire que la generation de la clé unique est laissé au sgbd utiliser
    //GenerationType.auto veut dire que la generation de la clé unique est laissé a Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelletirage",nullable = false,length = 100, unique = true)
    private String libelletirage;

    @Column(name = "datetirage",nullable = false)
    private Date datetirage;

    @Column(name = "nbr")
    private int nbr;

         @JsonIgnore
         @ManyToOne
         @JoinColumn(name = "liste_id")
         private Liste liste;

        //@OneToMany(mappedBy = "tirage")
        //private Postulants_Tirer postulantsTirers;
}
