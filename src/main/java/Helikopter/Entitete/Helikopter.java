package Helikopter.Entitete;

import javax.persistence.*;

public class Helikopter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String sifra;
    private String imeHelikopterja;
    private String status;

    //setterji
    public void setId(int id){
        this.id = id;
    }

    public void setSifra(String sifra){
        this.sifra = sifra;
    }

    public void setImeHelikopterja(String imeHelikopterja){
        this.imeHelikopterja = imeHelikopterja;
    }

    public void setStatus(String status){
        this.status = status;
    }

    //getterji
    public int getId(){
        return id;
    }

    public String getSifra(){
        return sifra;
    }

    public String getImeHelikopterja(){
        return imeHelikopterja;
    }

    public String getStatus(){
        return status;
    }
}