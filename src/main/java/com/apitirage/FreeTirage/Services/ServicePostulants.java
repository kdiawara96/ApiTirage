package com.apitirage.FreeTirage.Services;

import com.apitirage.FreeTirage.Models.Postulants;

import java.util.List;


public interface ServicePostulants {
    List<Postulants> insererPostulant(List<Postulants> listInser);
    Postulants insererUnPostulant(Postulants postulant);
   public List<Object> listId();
    public Postulants findByEmail(String email);
    public Integer ComptePostulants();
}
