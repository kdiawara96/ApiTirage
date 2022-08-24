package com.apitirage.FreeTirage.Models;

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


          @ManyToMany(mappedBy = "liste")
          private List<Postulants> postulant = new ArrayList<Postulants>();
/*
        @OneToMany(mappedBy = "liste")
        private Tirages tirages;
*/
}
