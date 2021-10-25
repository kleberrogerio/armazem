package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.armazem.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long>{

    public Usuario findbyUsuarioNome(String nome);

    public List<Usuario> findbyNomeContainsOrEmailContains(String nome, String email);
    
    public List<Usuario> findByAutorizacoesNome(String nome);
}
