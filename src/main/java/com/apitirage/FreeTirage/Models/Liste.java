package com.apitirage.FreeTirage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Liste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle",length = 100)
    private String libelle;

    @Column(name = "datelist",nullable = false)
    private Date datetlist;

    @JoinTable( name = "postulants_liste",
            joinColumns = @JoinColumn( name = "idliste" ),
            inverseJoinColumns = @JoinColumn( name = "idpostulants" ) )
    @ManyToMany
    private List<Postulants> postulant = new ArrayList<Postulants>();

    @JsonIgnore
    //cascade = CascadeType.REMOVE
    @OneToMany(mappedBy = "liste",cascade = CascadeType.REMOVE )
    private List<Tirages> tirages;
/*
        @OneToMany(mappedBy = "liste")
        private Tirages tirages;
*/
}
