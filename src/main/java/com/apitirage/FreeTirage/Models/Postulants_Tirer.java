package com.apitirage.FreeTirage.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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
