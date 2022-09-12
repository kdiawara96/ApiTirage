package com.apitirage.FreeTirage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "postulants")
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Postulants {

    //GenerationType.Identity veut dire que la generation de la clé unique est laissé au sgbd utiliser
    //GenerationType.auto veut dire que la generation de la clé unique est laissé a Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false,length = 25)
    private String nom;

    @Column(nullable = false,length = 25)
    private String prenom;

    @Column(nullable = false,length = 25)
    private String numero;

    @Column(nullable = false,length = 35)
    private String email;

    public Postulants(String nom, String prenom, String numero, String email) {
        this.nom =nom;
        this.prenom =prenom;
        this.numero =numero;
        this.email = email;
    }

    @JoinTable( name = "postulants_liste",
            joinColumns = @JoinColumn( name = "idpostulants" ),
            inverseJoinColumns = @JoinColumn( name = "idliste" ) )

    @ManyToMany
    private List<Liste> liste = new ArrayList<Liste>();

    //@ManyToMany
   // private Collection<List_Postulants> listpostulants;

   // private List_Postulants listPostulants;
   // @ManyToMany(mappedBy = "postulants")


}
