package com.apitirage.FreeTirage.Services;


import java.util.List;

public interface ServicePostulantTirer{
    int insertion_tirage(Long tirage, int indexT);
    List<Object> afficherPostulantsParTirge(Long id);
}
