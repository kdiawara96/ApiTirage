package com.apitirage.FreeTirage.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tirages")
public class Tirages {
    //GenerationType.Identity veut dire que la generation de la clé unique est laissé au sgbd utiliser
    //GenerationType.auto veut dire que la generation de la clé unique est laissé a Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelletirage",nullable = false,length = 100)
    private String libelletirage;

    @Column(name = "datetirage",nullable = false)
    private LocalDate datetirage;

}
