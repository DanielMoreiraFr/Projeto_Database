package app;

import model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MainInterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb-pu");
        EntityManager em = emf.createEntityManager();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Sistema OLAP Interativo ===");
            System.out.println("1. Inserir Nova Venda");
            System.out.println("2. Listar Todas as Vendas");
            System.out.println("3. Atualizar Quantidade de uma Venda");
            System.out.println("4. Deletar uma Venda");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    inserirVenda(scanner, em, emf);
                    break;
                case 2:
                    listarVendas(em);
                    break;
                case 3:
                    atualizarVenda(scanner, em, emf);
                    break;
                case 4:
                    deletarVenda(scanner, em, emf);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        em.close();
        emf.close();
        scanner.close();
    }

    private static void inserirVenda(Scanner scanner, EntityManager em, EntityManagerFactory emf) {
        em.getTransaction().begin();

        DimTempo tempo = new DimTempo();
        System.out.print("Ano: ");
        tempo.setAno(scanner.nextInt());
        System.out.print("Mês: ");
        tempo.setMes(scanner.nextInt());
        System.out.print("Dia: ");
        tempo.setDia(scanner.nextInt());

        DimProduto produto = new DimProduto();
        System.out.print("Nome do Produto: ");
        scanner.nextLine(); // limpar buffer
        produto.setNome(scanner.nextLine());
        System.out.print("Categoria do Produto: ");
        produto.setCategoria(scanner.nextLine());
        System.out.print("Marca do Produto: ");
        produto.setMarca(scanner.nextLine());

        FatoVenda venda = new FatoVenda();
        System.out.print("Quantidade vendida: ");
        venda.setQuantidade(scanner.nextInt());
        System.out.print("Valor total da venda: ");
        venda.setValorTotal(new BigDecimal(scanner.nextBigDecimal().toString()));
        scanner.nextLine(); // limpar buffer

        venda.setTempo(tempo);
        venda.setProduto(produto);

        em.persist(tempo);
        em.persist(produto);
        em.persist(venda);

        em.getTransaction().commit();

        System.out.println("Venda inserida com sucesso!");
    }

    private static void listarVendas(EntityManager em) {
    try {
        Query query = em.createQuery("SELECT v FROM FatoVenda v WHERE v.idVenda IS NOT NULL", FatoVenda.class);
        List<FatoVenda> vendas = query.getResultList();

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda encontrada.");
        } else {
            System.out.println("\n=== Lista de Vendas ===");
            for (FatoVenda venda : vendas) {
                System.out.println("ID Venda: " + venda.getIdVenda());
                System.out.println("Data: " + venda.getTempo().getAno() + "-" + venda.getTempo().getMes() + "-" + venda.getTempo().getDia());
                System.out.println("Produto: " + venda.getProduto().getNome() + " (" + venda.getProduto().getCategoria() + ")");
                System.out.println("Quantidade: " + venda.getQuantidade());
                System.out.println("Valor Total: R$" + venda.getValorTotal());
                System.out.println("---------------------------");
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao listar vendas: " + e.getMessage());
        e.printStackTrace();
    }
}

    private static void atualizarVenda(Scanner scanner, EntityManager em, EntityManagerFactory emf) {
        System.out.print("Digite o ID da venda que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        FatoVenda venda = em.find(FatoVenda.class, id);

        if (venda == null) {
            System.out.println("Venda não encontrada.");
            return;
        }

        System.out.print("Nova quantidade: ");
        int novaQtd = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        em.getTransaction().begin();
        venda.setQuantidade(novaQtd);
        em.merge(venda);
        em.getTransaction().commit();

        System.out.println("Quantidade atualizada com sucesso!");
    }

    private static void deletarVenda(Scanner scanner, EntityManager em, EntityManagerFactory emf) {
        System.out.print("Digite o ID da venda que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        FatoVenda venda = em.find(FatoVenda.class, id);

        if (venda == null) {
            System.out.println("Venda não encontrada.");
            return;
        }

        em.getTransaction().begin();
        em.remove(venda);
        em.getTransaction().commit();

        System.out.println("Venda excluída com sucesso!");
    }
}