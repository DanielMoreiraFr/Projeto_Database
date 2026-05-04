package model;

import javax.persistence.*;

@Entity
public class DimProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduto;
    private String nome;
    private String categoria;
    private String marca;

    public DimProduto() {}
    
    public DimProduto(String nome, String categoria, String marca) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
    }

    // Getters e Setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    @Override
    public String toString() {
        return "DimProduto [idProduto=" + idProduto +
                ", nome=" + nome +
                ", categoria=" + categoria +
                ", marca=" + marca + "]";
    }
}