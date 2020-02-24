package Helikopter.Service;

import Helikopter.Vmesnik.HelikopterVmesnik;
import Helikopter.Entitete.Helikopter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HelikopterServiceImpl implements HelikopterService{

    @Resource
    HelikopterVmesnik helikopterVmesnik;

    @Override
    public List<Helikopter> findAll() {
        return helikopterVmesnik.findAll();
    }

    @Override
    public void dodajHelikopter(Helikopter helikopter) {
        helikopterVmesnik.dodajHelikopter(helikopter);
    }

    @Override
    public void brisiHelikopter(int id) {
        helikopterVmesnik.brisiHelikopter(id);
    }
}