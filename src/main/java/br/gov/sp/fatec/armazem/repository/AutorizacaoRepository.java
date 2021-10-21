package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.armazem.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao,Long>{

    public List<Autorizacao> findByUsuariosNome(String nome);
    
}