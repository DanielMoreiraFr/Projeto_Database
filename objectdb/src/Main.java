import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.model.DimProduto;
import main.java.model.DimTempo;
import main.java.model.FatoVenda;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "data/database.odb");
        properties.put("javax.persistence.provider", "com.objectdb.jpa.Provider");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:data/database.odb", properties);
        EntityManager em = emf.createEntityManager();

        // Inserir dados
        em.getTransaction().begin();

        DimTempo t1 = new DimTempo();
        t1.setAno(2024);
        t1.setMes(1);
        t1.setDia(15);

        DimProduto p1 = new DimProduto();
        p1.setNome("Notebook Dell XPS");
        p1.setCategoria("Eletrônicos");
        p1.setMarca("Dell");

        FatoVenda v1 = new FatoVenda();
        v1.setIdVenda(1);
        v1.setTempo(t1);
        v1.setProduto(p1);
        v1.setQuantidade(2);
        v1.setValorTotal(new BigDecimal("6000.00"));

        em.persist(t1);
        em.persist(p1);
        em.persist(v1);

        em.getTransaction().commit();

        // Consultar dados
        var query = em.createQuery("SELECT v FROM FatoVenda v JOIN FETCH v.tempo JOIN FETCH v.produto");
        var vendas = query.getResultList();

        for (Object o : vendas) {
            System.out.println(o.toString());
        }

        em.close();
        emf.close();
    }
}