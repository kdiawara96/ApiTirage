package com.apitirage.FreeTirage.Models;

import lombok.Data;


import javax.persistence.*;
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



    @OneToMany
    private List<Postulants> postulants;

}
