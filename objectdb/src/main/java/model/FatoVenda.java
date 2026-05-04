package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class FatoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVenda;

    @OneToOne
    @JoinColumn(name = "tempo_id")
    private DimTempo tempo;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private DimProduto produto;

    private int quantidade;
    private BigDecimal valorTotal;

    public FatoVenda() {}

    public FatoVenda(DimTempo tempo, DimProduto produto, int quantidade, BigDecimal valorTotal) {
        this.tempo = tempo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public int getIdVenda() { return idVenda; }
    public void setIdVenda(int idVenda) { this.idVenda = idVenda; }

    public DimTempo getTempo() { return tempo; }
    public void setTempo(DimTempo tempo) { this.tempo = tempo; }

    public DimProduto getProduto() { return produto; }
    public void setProduto(DimProduto produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    @Override
    public String toString() {
        return "FatoVenda [idVenda=" + idVenda +
                ", tempo=" + tempo +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal + "]";
    }
}