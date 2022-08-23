package com.apitirage.FreeTirage.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Postulants_Tirer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "index_tirage")
    private int index_tirage;

    @ManyToOne
    @JoinColumn(name = "tirage_id")
    private Tirages tirage;
}
