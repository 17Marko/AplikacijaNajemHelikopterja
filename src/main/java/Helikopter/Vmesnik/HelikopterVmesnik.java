package Helikopter.Vmesnik;

import Helikopter.Entitete.Helikopter;

import java.util.List;

public interface HelikopterVmesnik {
    List<Helikopter> findAll();
    void dodajHelikopter(Helikopter helikopter);
    void brisiHelikopter(int id);
}