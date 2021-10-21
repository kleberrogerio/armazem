package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.armazem.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

    public Produto findbyProdutoNomeTest(String nome);

    public List<Produto> findbyProdutoNomeConstainsOrPeso(String nome, Long peso);
    
}
