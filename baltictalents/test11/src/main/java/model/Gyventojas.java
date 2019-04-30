package model;

import java.sql.Date;

public class Gyventojas {

    private Integer id;
    private String vardas;
    private String pavarde;
    private java.sql.Date gimimoMetai;
    private String gatve;
    private String tautybe;

    public Gyventojas() {

    }

    public Gyventojas(Integer id, String vardas, String pavarde, Date gimimoMetai, String gatve, String tautybe) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoMetai = gimimoMetai;
        this.gatve = gatve;
        this.tautybe = tautybe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Date getGimimoMetai() {
        return gimimoMetai;
    }

    public void setGimimoMetai(Date gimimoMetai) {
        this.gimimoMetai = gimimoMetai;
    }

    public String getGatve() {
        return gatve;
    }

    public void setGatve(String gatve) {
        this.gatve = gatve;
    }

    public String getTautybe() {
        return tautybe;
    }

    public void setTautybe(String tautybe) {
        this.tautybe = tautybe;
    }

    @Override
    public String toString() {
        return "Gyventojas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", gimimoMetai=" + gimimoMetai +
                ", gatve='" + gatve + '\'' +
                ", tautybe='" + tautybe + '\'' +
                '}';
    }
}
