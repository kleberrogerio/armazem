package br.gov.sp.fatec.armazem.service;

import java.util.List;

import br.gov.sp.fatec.armazem.entity.Usuario;

public interface SegurancaService {

    public Usuario cadastrarUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
