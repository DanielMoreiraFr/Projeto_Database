package model;

import javax.persistence.*;

@Entity
public class DimTempo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTempo;
    private int ano;
    private int mes;
    private int dia;
    // Construtor padrão
    public DimTempo() {}

    public DimTempo(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    // Getters e Setters
    public int getIdTempo() { return idTempo; }
    public void setIdTempo(int idTempo) { this.idTempo = idTempo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }

    @Override
    public String toString() {
        return "DimTempo [idTempo=" + idTempo +
                ", ano=" + ano +
                ", mes=" + mes +
                ", dia=" + dia + "]";
    }
}