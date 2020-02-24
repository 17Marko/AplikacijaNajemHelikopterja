package Helikopter.Service;

import Helikopter.Entitete.Helikopter;
import java.util.List;

public interface HelikopterService {
    List<Helikopter> findAll();
    void dodajHelikopter(Helikopter helikopter);
    void brisiHelikopter(int id);
}